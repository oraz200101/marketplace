package com.example.demomarketplace.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "shops")
public class Shop {
    private static final String SEQ_NAME="shop_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME,sequenceName = SEQ_NAME,allocationSize = 1)
    private long id;
    private String name;
    private String description;
    private String phone;
    @ManyToMany(mappedBy = "shops")
    private List<Product>products;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
