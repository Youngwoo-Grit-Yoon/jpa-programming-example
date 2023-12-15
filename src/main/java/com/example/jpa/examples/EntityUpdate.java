package com.example.jpa.examples;

import com.example.jpa.Agent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityUpdate {
    @Autowired
    private EntityManagerFactory emf;

    public void run() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();  // 트랜잭션 시작

        // 영속 엔티티 조회 및 데이터 수정
        Agent agent = em.find(Agent.class, "id1");
        agent.setDescription("주인선의 현재 남자친구이자 미래의 든든한 남편");

        tx.commit();  // 트랜잭션 커밋

        Agent newAgent = new Agent();
        newAgent.setId("id3");
        newAgent.setUsername("홍길동");
        newAgent.setAge(52);

        tx.begin();
        em.persist(newAgent);
        tx.commit();

        tx.begin();
        // 영속 엔티티 삭제
        em.remove(newAgent);
        tx.commit();
    }
}
