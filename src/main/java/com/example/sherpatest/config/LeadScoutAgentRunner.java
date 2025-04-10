package com.example.sherpatest.config;

import com.example.sherpatest.service.LeadScoutAgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LeadScoutAgentRunner implements CommandLineRunner {

    private final LeadScoutAgentService leadScoutAgentService;

    @Override
    public void run(String... args) {
        String companyName = "카카오페이"; // 테스트할 회사명
        System.out.println("Searching for: " + companyName);

        String result = leadScoutAgentService.runWebResearchWithToolSupport(companyName);

        System.out.println("\n Result:");
        System.out.println(result);
    }
}
