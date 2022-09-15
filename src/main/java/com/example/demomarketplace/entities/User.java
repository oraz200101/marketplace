package com.example.demomarketplace.entities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    private static final String SEQ_NAME="user_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME,sequenceName = SEQ_NAME,allocationSize = 1)
    Long id;
    private String phone;
    private String name;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String email;
    @OneToOne(cascade=CascadeType.REMOVE)
    private Bucket bucket;
    @OneToOne(cascade = CascadeType.REMOVE)
    private Shop shop;


}

