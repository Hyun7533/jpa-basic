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

            InvtReprtList invtReprtList = em.find(InvtReprtList.class, 1L);
            InvtReprt invtReprt = invtReprtList.getInvtReprt();
            List<InvtReprtErr> invtReprtErrs = invtReprt.getInvtReprtErrs();
            System.out.println("invtReprtErrs.size() = " + invtReprtErrs.size());


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
