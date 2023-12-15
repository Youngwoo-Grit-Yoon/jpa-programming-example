package com.example.jpa.examples;

import com.example.jpa.Agent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityPersist {
    @Autowired
    EntityManagerFactory emf;

    public void run() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Agent agent1 = new Agent();
        agent1.setId("id1");
        agent1.setUsername("윤영우");
        agent1.setAge(29);
        agent1.setDescription("주인선의 미래 남편");

        Agent agent2 = new Agent();
        agent2.setId("id2");
        agent2.setUsername("주인선");
        agent2.setAge(31);
        agent2.setDescription("윤영우의 미래 아내");

        tx.begin();

        em.persist(agent1);
        em.persist(agent2);

        tx.commit();
    }
}
