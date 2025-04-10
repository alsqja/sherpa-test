package com.example.sherpatest.controller;

import com.example.sherpatest.entity.CompanyData;
import com.example.sherpatest.service.CompanyDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/company-data")
public class CompanyDataController {

    private final CompanyDataService companyDataService;

    @GetMapping("/{id}")
    public ResponseEntity<CompanyData> getCompanyData(@PathVariable("id") Long id) {

        return new ResponseEntity<>(companyDataService.findCompanyById(id), HttpStatus.OK);
    }
}
