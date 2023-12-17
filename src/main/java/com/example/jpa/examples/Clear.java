package com.example.jpa.examples;

import com.example.jpa.Agent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Clear {
    @Autowired
    EntityManagerFactory emf;

    public void run() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Agent inseonAgent = em.find(Agent.class, "id2");
        em.clear();  // 영속성 컨텍스트 캐시 초기화
        inseonAgent.setDescription("사랑하는 여자친구");

        tx.commit();
    }
}
