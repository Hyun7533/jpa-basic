package jpabook.jpashop.newDomain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class InvtReprtErr {

    @Id @GeneratedValue
    @Column(name = "INVT_REPRT_ERR")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "INVT_REPRT_NO")
    private InvtReprt invtReprt;

    private String errKnd;

}
