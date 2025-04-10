package com.example.sherpatest.config.agent;

import com.example.sherpatest.service.WebSearchService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ToolCallHandler {

    private final WebSearchService webSearchService;
    private final ObjectMapper objectMapper;

    public String handleToolCall(JsonNode toolCallNode) {
        try {
            String functionName = toolCallNode.path("function").path("name").asText();
            String argumentsJson = toolCallNode.path("function").path("arguments").asText();

            if ("search_web".equals(functionName)) {
                JsonNode args = objectMapper.readTree(argumentsJson);
                String query = args.path("query").asText();
                return webSearchService.searchRawHtml(query);
            }

            return "Unsupported tool function: " + functionName;
        } catch (Exception e) {
            return "Tool execution failed: " + e.getMessage();
        }
    }
}
