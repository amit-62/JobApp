package com.amit.jobapp.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    boolean deleteJobById(Long id);

    Job getJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
