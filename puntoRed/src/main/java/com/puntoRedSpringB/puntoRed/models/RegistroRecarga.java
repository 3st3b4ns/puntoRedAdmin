package com.puntoRedSpringB.puntoRed.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "registrorecarga")
@ToString @EqualsAndHashCode
public class RegistroRecarga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private long id;
    @Getter @Setter @Column(name = "phonenumber")
    private String phonenumber;
    @Getter @Setter @Column(name = "amount")
    private String amount;
    @Getter @Setter @Column(name = "transaccion")
    private String transaccion;
    @Getter @Setter @Column(name = "supplier")
    private String supplier;
}
