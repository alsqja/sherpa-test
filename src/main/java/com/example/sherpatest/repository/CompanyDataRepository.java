package com.example.sherpatest.repository;

import com.example.sherpatest.entity.CompanyData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDataRepository extends JpaRepository<CompanyData, Long> {
}
