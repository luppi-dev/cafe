package br.com.luppi.api.cafe.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "user_")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user__id_seq")
    @SequenceGenerator(name = "user__id_seq", sequenceName = "user__id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "exposed_id", nullable = false, unique = true)
    private UUID exposedID;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private byte[] hash;

    @Column(nullable = false)
    private byte[] salt;

    @Column(name = "created_at")
    private LocalDate createdAt;

}
