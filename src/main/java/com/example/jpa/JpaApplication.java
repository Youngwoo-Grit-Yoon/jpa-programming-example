package com.example.jpa;

import jakarta.persistence.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.MessageFormat;
import java.util.List;

@SpringBootApplication
public class JpaApplication {
	@PersistenceUnit
	EntityManagerFactory emf;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
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
		};
	}

	void logic(EntityManager em) {
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
