package com.amit.jobapp.company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    Company getCompanyById(Long id);
    void createCompany(Company company);
    boolean deleteCompanyById(Long id);
    boolean updateCompany(Company company, Long id);

}
