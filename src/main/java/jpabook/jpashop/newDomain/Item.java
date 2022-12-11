package jpabook.jpashop.newDomain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private Long price;
}
