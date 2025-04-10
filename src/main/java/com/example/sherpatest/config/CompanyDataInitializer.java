package com.example.sherpatest.config;

import com.example.sherpatest.entity.CompanyData;
import com.example.sherpatest.repository.CompanyDataRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CompanyDataInitializer {

    private final CompanyDataRepository repository;

    @PostConstruct
    public void init() {
        Optional<CompanyData> companyData = repository.findById(1L);

        if (companyData.isPresent()) {
            return;
        }

        List<CompanyData> list = List.of(
                new CompanyData(1L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "인천광역시 서구 북항로 53 (석남동, 가가담목재(주))", "가가담목재", "-", "www.gagadam.co.kr", "표면 가공 목재 및 특정 목적용 제재목 제조업", "이경석", "-", "032-821-4785", "-", "-"),
                new CompanyData(2L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "부산광역시 부산진구 새싹로210번길 6-16 (초읍동)", "가가이엔지", "-", "-", "사업시설 유지ㆍ관리 서비스업", "김호협, 장광회", "-", "051-643-6119", "-", "-"),
                new CompanyData(3L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "강원특별자치도 춘천시 남면 소주고개로 238-1 (후동리) 1층", "가가이토", "-", "-", "주거용 건물 개발 및 공급업", "김소진", "-", "010-7233-5429", "-", "-"),
                new CompanyData(4L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "서울특별시 종로구 종로1길 42 (수송동, 이마빌딩) 407호", "가겐투안", "-", "www.gargantuan.co.kr", "인력 공급업", "정완수", "-", "02-398-0007", "-", "-"),
                new CompanyData(5L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-08T13:18:07.326"), "경남 밀양시 하남읍 수산중앙로 73-13", "가경", "-", "-", "슈퍼마켓", "전종명", "-", "070-4772-2276", "23억 5,992만원", "-"),
                new CompanyData(6L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "제주특별자치도 제주시 광평중길 73 (노형동)", "가경", "-", "-", "부동산 개발 및 공급업", "유영석", "-", "010-4964-3697", "-", "-"),
                new CompanyData(7L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "서울특별시 강남구 삼성로84길 14 2층 (대치동)", "가경개발", "-", "www.kgreits.com", "부동산 개발 및 공급업", "황두성", "-", "02-508-1125", "-", "-"),
                new CompanyData(8L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "서울특별시 서초구 강남대로6길 12 (양재동)", "가경디앤씨", "-", "-", "아파트 건설업", "이영길", "-", "02-567-4789", "-", "-"),
                new CompanyData(9L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "서울특별시 서초구 서초동 1360-31 정진빌딩 5층", "가경산업개발", "-", "-", "부동산업", "신상격", "-", "02-3471-0585", "-", "-"),
                new CompanyData(10L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "서울특별시 성북구 월계로 138 (장위동, 가경빌딩)", "가경엘앤에프", "-", "volpark717@hanmail.net", "봉제의복 제조업", "송경환", "-", "02-913-1606", "-", "-"),
                new CompanyData(11L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "서울특별시 영등포구 여의대로 60 (여의도동)", "가경제일차", "-", "-", "기타 금융업", "이봉관", "-", "28451663", "-", "-"),
                new CompanyData(12L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "서울특별시 양천구 목동서로 133 (목동,KGIT목동센타)", "가경종합건설", "-", "-", "종합 건설업", "서복실", "-", "02-2649-3033", "-", "-"),
                new CompanyData(13L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-08T18:38:01.301"), "경기 시흥시 공단2대로 290, 가경종합철강", "가경종합철강", "-", "-", "그 외 기타 1차 철강 제조업", "최강경", "-", "031-431-1454", "155억 4,199만원", "-"),
                new CompanyData(14L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "경상남도 김해시 생림면 나전로 60 407호(나전리)", "가교김해오토갤러리", "-", "-", "그 외 기타 분류 안된 전문, 과학 및 기술 서비스업", "박성진", "-", "055-337-2679", "-", "-"),
                new CompanyData(15L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "경상남도 김해시 한림면 김해대로 1160-22 가교산업(주)", "가교산업", "-", "-", "그 외 기타 특수목적용 기계 제조업", "박호근", "-", "055-345-3314", "-", "-"),
                new CompanyData(16L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "경상남도 김해시 번화1로79번길 2 704호 (대청동, 센터빌딩)", "가교아이앤디", "-", "-", "부동산 개발 및 공급업", "박성진", "-", "055-325-4451", "-", "-"),
                new CompanyData(17L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "서울특별시 강남구 삼성로95길 6 삼혜빌딩 4층 (삼성동)", "가교회계법인", "-", "www.gagyoac.co.kr", "공인회계사업", "강효식", "-", "02-569-9808", "-", "-"),
                new CompanyData(18L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "경기도 안양시 동안구 벌말로 123 (관양동, 평촌스마트베이) A동 805호", "가나", "-", "-", "기타 화학물질 및 화학제품 도매업", "유태규", "-", "031-398-5110", "-", "-"),
                new CompanyData(19L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "경기도 화성시 정남면 시청로 1560-42 경기 화성시 향남읍 하길로 69 (하길리, 화성향남오색마을사랑으로부영9단지)", "가나개발", "-", "-", "비금속광물 분쇄물 생산업", "정봉수", "-", "3180590029", "-", "-"),
                new CompanyData(20L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "대구광역시 달서구 성서공단남로32길 23 (월암동)", "가나공업", "-", "-", "자동차 및 트레일러 제조업", "임계식", "-", "053-583-9947", "-", "-"),
                new CompanyData(21L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "울산광역시 울주군 서생면 용연길 48 (명산리) 190", "가나공영", "-", "www.ganaeng.co.kr", "시설물 유지관리 공사업", "곽영단", "-", "522390566", "-", "-"),
                new CompanyData(22L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "경기도 화성시 효행로 1069 (진안동, 메디피아)801호", "가나다", "-", "-", "부동산업", "유미란", "-", "031-613-9095", "-", "-"),
                new CompanyData(23L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "서울특별시 동대문구 난계로 234 7층 (신설동,삼송빌딩)", "가나디비", "-", "-", "비주거용 건물 개발 및 공급업", "박광숙", "-", "02-2253-8080", "-", "-"),
                new CompanyData(24L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "서울특별시 서초구 양재동 257-3", "가나레포츠", "-", "www.kanaleports.com", "여자용 겉옷 제조업", "유상배", "-", "02-576-9891", "-", "-"),
                new CompanyData(25L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "부산광역시 동구 초량1동 1209 ~1213", "가나마린", "-", "-", "외항 화물 운송업", "정기웅", "-", "051-463-6245", "-", "-"),
                new CompanyData(26L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "서울특별시 강남구 언주로30길 13 (도곡동, 대림아크로빌,대림아크로텔) 903호", "가나상공", "-", "-", "도매 및 상품 중개업", "김준호", "-", "02-558-1625", "-", "-"),
                new CompanyData(27L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "경기도 동두천시 동두천동 545-1", "가나섬유", "-", "-", "직물, 편조원단 및 의복류 염색 가공업", "노시권", "-", "031-864-9304", "-", "-"),
                new CompanyData(28L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "경기도 화성시 팔탄면 서해로 1264-2 (창곡리)", "가나스틸", "-", "www.ganasteel.com", "1차 금속제품 도매업", "이안수", "-", "02-584-4292", "-", "-"),
                new CompanyData(29L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "서울특별시 종로구 평창동 97번지 가나아트센터", "가나아트갤러리", "-", "www.ganaart.com", "예술품 및 골동품 소매업", "이옥경", "-", "02-3217-1092", "-", "-"),
                new CompanyData(30L, LocalDateTime.parse("2025-03-05T17:23:32"), LocalDateTime.parse("2025-03-05T17:23:32"), "서울특별시 용산구 장문로 54 (동빙고동)", "가나아트한남", "-", "-", "예술품 및 골동품 소매업", "이정용", "-", "232161024", "-", "-")
        );

        repository.saveAll(list);
        System.out.println("CompanyData 초기화");
    }
}
