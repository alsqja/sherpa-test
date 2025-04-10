package com.example.sherpatest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@Slf4j
public class WebSearchService {

    @Value("${brave.api.key}")
    private String braveApiKey;

    private static final String BRAVE_SEARCH_API = "https://api.search.brave.com/res/v1/web/search";

    public String searchRawHtml(String query) {
        try {
            String refinedQuery = query + " 회사 정보 대표자 홈페이지";
            URI uri = UriComponentsBuilder.fromHttpUrl(BRAVE_SEARCH_API)
                    .queryParam("q", URLEncoder.encode(refinedQuery, StandardCharsets.UTF_8))
                    .build(false)
                    .toUri();

            HttpHeaders headers = new HttpHeaders();
            headers.set("x-subscription-token", braveApiKey);
            headers.setAccept(List.of(MediaType.APPLICATION_JSON));

            HttpEntity<Void> request = new HttpEntity<>(headers);
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);

            log.info("Brave 검색 결과:\n {}", response.getBody());

            return response.getBody();
        } catch (Exception e) {
            log.error("Brave API 검색 중 오류 발생", e);
            return "웹 검색 중 오류가 발생했습니다: " + e.getMessage();
        }
    }
}
