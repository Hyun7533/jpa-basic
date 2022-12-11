package jpabook.jpashop.newDomain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class InvtReprt {

    @Id @GeneratedValue
    @Column(name = "INVT_REPRT_NO")
    private Long id;

    private String name;

    private String reprtKnd;

    @OneToMany(mappedBy = "invtReprt")
    private List<InvtReprtErr> invtReprtErrs;

}
