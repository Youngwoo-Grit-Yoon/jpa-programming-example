package com.example.jpa.examples;

import com.example.jpa.Agent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;

/**
 * Spring Boot를 사용하면 persistence.xml 파일을 사용할 수 없으므로 @PersistenceUnit을 이용하여 EntityManagerFactory 의존성을 주입한다.
 * Example01 클래스를 Bean으로 등록하고 @Autowired를 이용하여 사용한다.
 */
@Component
public class Example01 {
    @PersistenceUnit
    private EntityManagerFactory emf;

    public void run() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            logic(em);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

    private void logic(EntityManager em) {
        String id = "id1";
        Agent agent = new Agent();
        agent.setId(id);
        agent.setUsername("윤영우");
        agent.setAge(29);

        // 등록
        em.persist(agent);

        // 수정(JPA는 어떤 엔티티가 변경되었는지 추적하는 기능을 갖추고 있다)
        agent.setAge(30);

        // 한 건 조회
        Agent findAgent = em.find(Agent.class, id);
        System.out.println(MessageFormat.format("""
				아이디 : {0}
				이름 : {1}
				나이 : {2}""", findAgent.getId(), findAgent.getUsername(), findAgent.getAge()));

        // 목록 조회
        List<Agent> agentList = em.createQuery("""
				select a from agent a""", Agent.class).getResultList();
        System.out.println(MessageFormat.format("상담원 수 : {0}", agentList.size()));

        // 삭제
        em.remove(agent);
    }
}
