package com.example.sherpatest.service;

import com.example.sherpatest.entity.CompanyData;
import com.example.sherpatest.repository.CompanyDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CompanyDataService {

    private final CompanyDataRepository companyDataRepository;

    public CompanyData findCompanyById(Long id) {

        return companyDataRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found"));
    }
}
