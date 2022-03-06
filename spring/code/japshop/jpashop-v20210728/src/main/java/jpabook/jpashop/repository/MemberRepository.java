package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContexts;
import java.util.List;

@Repository
@RequiredArgsConstructor // 대신
public class MemberRepository {

//    @PersistenceContext -> @Autowired
    private final EntityManager em; // 엔티티 매니저 선언

    public void save(Member member) {
        em.persist(member);
    } // 저장

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() { // id로 멤버 조회
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) { // 이름으로 멤머 조회
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
