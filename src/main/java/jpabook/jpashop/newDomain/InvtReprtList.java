package jpabook.jpashop.newDomain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class InvtReprtList {

    @Id @GeneratedValue
    @Column(name = "INVT_REPRT_LIST_NO")
    private Long id;

    @OneToOne
    @JoinColumn(name = "INVT_REPRT_NO")
    private InvtReprt invtReprt;

    private String startDt;

    private String endDt;


}
