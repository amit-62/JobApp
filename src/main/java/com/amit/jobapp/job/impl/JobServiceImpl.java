package com.amit.jobapp.job.impl;

import com.amit.jobapp.job.Job;
import com.amit.jobapp.job.JobRepository;
import com.amit.jobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobServiceImpl implements JobService {

    JobRepository jobRepository;
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    //    private List<Job> jobs = new ArrayList<>();

    private Long NextId=1L;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long id){
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public void createJob(Job job) {
        job.setId(NextId++);
        jobRepository.save(job);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional= jobRepository.findById(id);

        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            if(updatedJob.getDescription()!=null) job.setDescription(updatedJob.getDescription());
            if(updatedJob.getTitle()!=null) job.setTitle(updatedJob.getTitle());
            if(updatedJob.getMinSalary()!=null) job.setMinSalary(updatedJob.getMinSalary());
            if(updatedJob.getMaxSalary()!=null) job.setMaxSalary(updatedJob.getMaxSalary());
            if(updatedJob.getLocation()!=null) job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
