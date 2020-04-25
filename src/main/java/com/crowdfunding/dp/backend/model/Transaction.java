package com.crowdfunding.dp.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionid")
    private Long id;

    @Column(name = "sum")
    private Double sum;

    @Column(name = "transactiondate")
    private LocalDateTime transactiondate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project")
    private Project project;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doneby", nullable = true)
    private User doneBy;
}
