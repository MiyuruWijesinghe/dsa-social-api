package com.dsa.dsa_social_api.worker;

import com.dsa.dsa_social_api.model.Job;
import com.dsa.dsa_social_api.repository.InMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class JobWorker {

    @Autowired
    private InMemoryStore store;

    @PostConstruct
    public void startWorker() {

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(3000); // every 3 seconds

                    Job job = store.jobQueue.dequeue();

                    if (job != null) {
                        System.out.println("Processing job: " + job.getType());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
