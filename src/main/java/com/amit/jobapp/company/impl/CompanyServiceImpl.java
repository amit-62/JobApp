package com.amit.jobapp.company.impl;

import com.amit.jobapp.company.Company;
import com.amit.jobapp.company.CompanyRepository;
import com.amit.jobapp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    private Long NextId=1L;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void createCompany(Company company) {
        company.setId(NextId++);
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateCompany(Company updatedCompany, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);

        if(companyOptional.isPresent()){
            Company company = companyOptional.get();
            if(updatedCompany.getName()!=null) company.setName(updatedCompany.getName());
            if(updatedCompany.getDescription()!=null) company.setDescription(updatedCompany.getDescription());
            companyRepository.save(company);
            return true;
        }
        return false;
    }
}
