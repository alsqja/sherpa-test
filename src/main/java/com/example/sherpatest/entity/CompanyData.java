package com.example.sherpatest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class CompanyData extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String company;

    @Column(columnDefinition = "TEXT")
    private String keyExecutive;

    @Column(length = 100)
    private String industry;

    @Column(columnDefinition = "TEXT")
    private String address;

    private String homepage;

    @Column(length = 100)
    private String email;

    @Column(length = 50)
    private String phoneNumber;

    @Column(columnDefinition = "TEXT")
    private String sales;

    @Column(length = 100)
    private String totalFunding;

    private String logoUrl;

    public CompanyData(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String address,
                       String company, String email, String homepage, String industry,
                       String keyExecutive, String logoUrl, String phoneNumber, String sales,
                       String totalFunding) {
        this.company = company;
        this.keyExecutive = keyExecutive;
        this.industry = industry;
        this.address = address;
        this.homepage = homepage;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sales = sales;
        this.totalFunding = totalFunding;
        this.logoUrl = logoUrl;
    }

    private CompanyData(String company, String keyExecutive, String industry, String address,
                        String homepage, String email, String phoneNumber, String sales,
                        String totalFunding, String logoUrl) {
        this.company = company;
        this.keyExecutive = keyExecutive;
        this.industry = industry;
        this.address = address;
        this.homepage = homepage;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sales = sales;
        this.totalFunding = totalFunding;
        this.logoUrl = logoUrl;
    }

    public static CompanyData of(String company, String keyExecutive, String industry, String address,
                                 String homepage, String email, String phoneNumber, String sales,
                                 String totalFunding, String logoUrl) {
        return new CompanyData(company, keyExecutive, industry, address,
                homepage, email, phoneNumber, sales, totalFunding, logoUrl);
    }

    public void update(String company, String keyExecutive, String industry, String address,
                       String homepage, String sales, String logoUrl) {
        this.company = company;
        this.keyExecutive = keyExecutive;
        this.industry = industry;
        this.address = address;
        this.homepage = homepage;
        this.sales = sales;
        this.logoUrl = logoUrl;
    }
}