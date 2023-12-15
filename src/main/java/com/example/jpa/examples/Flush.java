package com.example.jpa.examples;

import com.example.jpa.Agent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.FlushModeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 영속성 컨텍스트를 플러시하는 3가지 방법
 * 1. em.flush()를 직접 호출한다.
 * 2. 트랜잭션 커밋 시 플러시가 자동 호출된다.
 * 3. JPQL 쿼리 실행 시 플러시가 자동 호출된다.
 */
@Component
public class Flush {
    @Autowired
    EntityManagerFactory emf;

    public void run() {
        EntityManager em = emf.createEntityManager();

        // JPQL 실행 시 Flush 수행
        List<Agent> agentList = em.createQuery("select a from agent a", Agent.class).getResultList();

        // Flush 모드 변경
        em.setFlushMode(FlushModeType.AUTO);  // 커밋할 때만 플러시
        em.setFlushMode(FlushModeType.COMMIT);  // 커밋이나 쿼리를 실행할 때 플러시
    }
}
