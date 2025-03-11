package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "amendes")
@Getter
@Setter

public class Amande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amande_id")
    private int amandeID;

    @Column(name = "montant", nullable = false)
    private double montant;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_creation", nullable = false)
    private LocalDate dateCreation;

    @Column(name = "status", nullable = false)
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Emprunteur emprunteur;

}
