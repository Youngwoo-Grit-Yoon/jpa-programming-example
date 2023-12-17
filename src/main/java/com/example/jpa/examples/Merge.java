package com.example.jpa.examples;

import com.example.jpa.Agent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 병합(Merge)은 save or update 기능을 수행한다.
 */
@Component
public class Merge {
    @Autowired
    EntityManagerFactory emf;

    public void run() {
        EntityManager em1 = emf.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();

        Agent agent = new Agent();
        agent.setId("id3");
        agent.setUsername("윤주");
        agent.setAge(1);

        tx1.begin();

        em1.persist(agent);

        tx1.commit();
        em1.close();

        EntityManager em2 = emf.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();

        agent.setDescription("인선이와 영우의 주니어");

        tx2.begin();

        Agent mergeAgent = em2.merge(agent);

        tx2.commit();
        em2.close();
    }
}
