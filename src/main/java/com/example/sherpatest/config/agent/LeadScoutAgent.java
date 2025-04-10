package com.example.sherpatest.config.agent;

import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class LeadScoutAgent {

    private final String instructions = """
                당신은 회사 정보를 수집하여 데이터베이스에 저장하는 리드 스카우터입니다.
                회사 이름이 주어지면 웹에서 정보를 조사하여 아래 항목을 JSON 형식으로 정리하세요.
            
                반드시 아래 필드를 포함해주세요:
                - company: 회사 이름
                - address: 본사 주소 또는 주요 사무실 위치
                - homepage: 공식 홈페이지 URL
                - email: 대표 이메일
                - industry: 산업군 또는 업종
                - keyExecutive: 대표자 또는 주요 임원 이름
                - logoUrl: 회사 로고 이미지 링크 (있다면)
                - phoneNumber: 대표 전화번호
                - sales: 최근 매출 정보 (예: 100억 원)
                - totalFunding: 총 투자 유치 금액 (있다면)
            
                정보가 없거나 찾을 수 없다면 '-' 로 표시하세요.
            """;

    public List<Map<String, String>> buildMessages(String query) {
        return List.of(
                Map.of("role", "system", "content", instructions),
                Map.of("role", "user", "content", query)
        );
    }
}
