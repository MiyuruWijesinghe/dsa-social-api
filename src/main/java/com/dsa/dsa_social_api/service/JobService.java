package com.dsa.dsa_social_api.service;

import com.dsa.dsa_social_api.model.Job;
import com.dsa.dsa_social_api.repository.InMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private InMemoryStore store;

    public void addJob(Job job) {
        store.jobQueue.enqueue(job);
    }


    public Job processJob() {
        return store.jobQueue.dequeue();
    }


    public List<Job> getAllJobs() {
        List<Job> list = new ArrayList<>();

        while (!store.jobQueue.isEmpty()) {
            Job job = store.jobQueue.dequeue();
            list.add(job);
        }

        // put back (important!)
        for (Job job : list) {
            store.jobQueue.enqueue(job);
        }

        return list;
    }
}
