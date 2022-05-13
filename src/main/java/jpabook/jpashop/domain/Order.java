package jpabook.jpashop.domain;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne // order 입장에서는 오더가 여러개, 멤버가 한개
    @JoinColumn(name = "MEMBER_ID") // 이렇게 함으로서 테이블-객체간 연관관계를 매핑함.
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    private Date orderDate;

    @Enumerated(EnumType.STRING) // 매우 중요
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member memberId) {
        this.member = memberId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
