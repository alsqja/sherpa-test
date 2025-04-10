package com.example.sherpatest.service;

import com.example.sherpatest.config.agent.LeadScoutAgent;
import com.example.sherpatest.config.agent.OpenAiAgentClient;
import com.example.sherpatest.config.agent.ToolCallHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LeadScoutAgentService {

    private final OpenAiAgentClient openAiAgentClient;
    private final ToolCallHandler toolCallHandler;
    private final ObjectMapper objectMapper;

    public String runWebResearchWithToolSupport(String companyName) {
        LeadScoutAgent agent = new LeadScoutAgent();
        String query = "웹 검색 도구를 사용해서 다음 회사를 조사하세요: " + companyName;
        List<Map<String, String>> messages = agent.buildMessages(query);

        // 1차 GPT 호출
        String response = openAiAgentClient.callGptRaw(messages);

        try {
            JsonNode root = objectMapper.readTree(response);
            JsonNode toolCalls = root.path("choices").get(0).path("message").path("tool_calls");

            // tool_call 있으면 실행 후 재요청
            if (toolCalls.isArray() && !toolCalls.isEmpty()) {
                System.out.println("tool_calls: " + toolCalls);
                List<Map<String, Object>> secondMessages = new ArrayList<>();

                secondMessages.add(Map.of(
                        "role", "system",
                        "content", agent.getInstructions()
                ));

                // assistant message에 전체 tool_calls 넣기
                Map<String, Object> assistantMessage = new HashMap<>();
                assistantMessage.put("role", "assistant");
                assistantMessage.put("tool_calls", objectMapper.readValue(toolCalls.toString(), List.class));
                secondMessages.add(assistantMessage);

                // 각각의 tool_call에 응답 생성
                for (JsonNode toolCall : toolCalls) {
                    String toolCallId = toolCall.path("id").asText();
                    String toolResult = toolCallHandler.handleToolCall(toolCall);

                    Map<String, Object> toolMessage = Map.of(
                            "role", "tool",
                            "tool_call_id", toolCallId,
                            "content", toolResult
                    );

                    secondMessages.add(toolMessage);
                }

                return openAiAgentClient.callGpt(secondMessages);
            } else {
                return root.path("choices").get(0).path("message").path("content").asText();
            }
        } catch (Exception e) {
            return "파싱 실패: " + e.getMessage();
        }
    }
}
