package com.dsa.dsa_social_api.controller;

import com.dsa.dsa_social_api.model.Job;
import com.dsa.dsa_social_api.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService service;

    @PostMapping
    public String add(@RequestBody Job job) {
        service.addJob(job);
        return "Job added to queue";
    }

    @GetMapping
    public List<Job> getAll() {
        return service.getAllJobs();
    }

    @PostMapping("/process")
    public Job process() {
        return service.processJob();
    }
}
