package com.example.jpa.examples;

import com.example.jpa.Agent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 예외가 발생하는데 검색 결과 하이버네이트 버그로 추정됨
 */
@Component
public class Detach {
    @Autowired
    EntityManagerFactory emf;

    public void run() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Agent agent = new Agent();
        agent.setId("id10");
        agent.setUsername("주현준");
        agent.setAge(1);
        agent.setDescription("별명은 황금이");

        tx.begin();

        em.persist(agent);  // 영속 상태
        em.detach(agent);  // 준영속 상태

        tx.commit();
    }
}
