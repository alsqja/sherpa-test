package com.example.sherpatest.service;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class WebSearchService {

    public String search(String query) {
        try {
            String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
            String url = "https://www.google.com/search?q=" + encodedQuery;

            log.info("🔍 검색 URL: {}", url);

            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/113.0.0.0 Safari/537.36")
                    .timeout(5000)
                    .get();

            log.debug("📄 HTML 결과: {}", doc.outerHtml());

            Elements results = doc.select("div.g, div.MjjYud, div.tF2Cxc, div.kCrYT, div.VwiC3b");

            StringBuilder sb = new StringBuilder();

            int count = 0;
            for (Element result : results) {
                Element titleElement = result.selectFirst("h3");
                Element snippetElement = result.selectFirst("span.st, div.IsZvec, div.VwiC3b");
                Element linkElement = result.selectFirst("a");

                if (titleElement != null && linkElement != null) {
                    sb.append("제목: ").append(titleElement.text()).append("\n");
                    sb.append("링크: ").append(linkElement.absUrl("href")).append("\n");
                    if (snippetElement != null) {
                        sb.append("요약: ").append(snippetElement.text()).append("\n");
                    }
                    sb.append("\n");
                    if (++count >= 5) break; // 상위 5개 결과만
                }
            }

            if (sb.isEmpty()) {
                log.warn("[{}] 검색 결과 없음", query);
                return "검색 결과를 찾지 못했습니다.";
            }

            return sb.toString();
        } catch (IOException e) {
            log.error("Google 검색 중 오류 발생", e);
            return "웹 검색 중 오류가 발생했습니다: " + e.getMessage();
        }
    }
}
