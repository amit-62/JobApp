package com.amit.jobapp.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping("/company")
    public ResponseEntity<List<Company>> findAll(){
        return ResponseEntity.ok(companyService.findAll());
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable(value = "id") Long id){
        Company company = companyService.getCompanyById(id);
        if(company != null){
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/company")
    public ResponseEntity<String> createJob(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("jobs added successfully", HttpStatus.OK);
    }

    @PutMapping("/company/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company updateCompany){
        boolean updated = companyService.updateCompany(updateCompany, id);
        if (updated) {
            return new ResponseEntity<>("updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/company/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean deleted = companyService.deleteCompanyById(id);
        if (deleted) {
            return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
