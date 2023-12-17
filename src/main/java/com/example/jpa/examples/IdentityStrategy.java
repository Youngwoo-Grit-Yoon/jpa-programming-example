package com.example.jpa.examples;

import com.example.jpa.AgentStatusHistory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IdentityStrategy {
    @Autowired
    private EntityManagerFactory emf;

    public void run() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        AgentStatusHistory agentStatusHistory = new AgentStatusHistory();
        em.persist(agentStatusHistory);  // persist 즉시 SQL을 실행하여 PK 값을 가져온다.
        System.out.println(agentStatusHistory.getId());

        tx.commit();
    }
}
