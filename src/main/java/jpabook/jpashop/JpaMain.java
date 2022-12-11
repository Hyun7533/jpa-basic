package jpabook.jpashop;

import jpabook.jpashop.newDomain.InvtReprt;
import jpabook.jpashop.newDomain.InvtReprtErr;
import jpabook.jpashop.newDomain.InvtReprtList;

import javax.persistence.*;
import java.util.List;

// JPA의 모든 데이터는 트랜잭션 안에서 실행해야한다.
public class JpaMain {

    public static void main(String[] args) {
        // 앱 뜰때 한번 생성하고 앱이꺼지면 없어진다
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 사용자가 요청이 들어올때 생성하고 버리고 계속 반복된다. 그러므로 쓰레드간에 공유를 하면 안된다. (사용하고 버려야 한다.)
        EntityManager em = emf.createEntityManager(); //

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜젝션 시작

        try {
            InvtReprtList invtReprtList = new InvtReprtList();
            InvtReprt invtReprt = new InvtReprt();


            invtReprtList.setStartDt("2022-12-11");
            invtReprtList.setEndDt("2023-1-11");
            invtReprtList.setInvtReprt(invtReprt);

            em.persist(invtReprtList);

            InvtReprtErr invtReprtErr = new InvtReprtErr();
            InvtReprtErr invtReprtErr2 = new InvtReprtErr();

            invtReprt.setName("리츠정보시스템 보고서");
            invtReprt.setReprtKnd("결산보고서");

            em.persist(invtReprt);

            invtReprtErr.setInvtReprt(invtReprt);
            invtReprtErr.setErrKnd("임의적 오류");
            invtReprtErr2.setInvtReprt(invtReprt);
            invtReprtErr2.setErrKnd("필수적 오류");

            em.persist(invtReprtErr);
            em.persist(invtReprtErr2);

            em.flush();
            em.clear();

            InvtReprt invtReprt1 = em.find(InvtReprt.class, 2L);
            List<InvtReprtErr> invtReprtErrs = invtReprt1.getInvtReprtErrs();
            for(int i=0; i<invtReprtErrs.size(); i++) {
                System.out.println("invtReprtErrs = " + invtReprtErrs.get(i).getErrKnd());
            }


            tx.commit(); // 트렌젝션을 커밋할때 쿼리가 날라간다.
        } catch (Exception e) {
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();

    }
}


/*
    1. 객체와 관계형 데이터베이스를 어떻게 매핑할것인가? (ORM)
    2. 영속성 컨텍스트 (JPA가 내부적으로 어떻게 동작하냐?)
 */
