package jpabook.jpashop.newDomain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name ="MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "orderId")
    private List<OrderItem> orderItemList = new ArrayList<>();

}
