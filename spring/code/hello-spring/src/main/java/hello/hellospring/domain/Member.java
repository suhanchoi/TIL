package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // db 가 알아서 생성
    private Long id;
    private String name;

    @Column()
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    @Entity
    public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 1 FetchType.EAGER // 다 대 일
    @JoinColumn(name = "userId") // 2 // 외래키 맵핑
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemId")
    private Item itemId;

    @OneToMany 다대일

    public class Member {
  //Member 1 : Order N | 이쪽 orderList는 단순히 Order에게 매핑만 된다. orderList가 변경되어도 Order의 FK는 변경되지 않는다.
  @OneToMany(mappedBy = "member")
    private List<Order> orderList = new ArrayList<>();
}

public class Order {
  //Order N : Member 1 | 해당 값의 변경이 일어날 시 member의 id값도 변경이 일어난다.
  @ManyToOne
  @JoinColumn(name = "member_id") //FK
  private Member member;
}

}

   * */

}
