package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "emprunt")
@Getter
@Setter
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emprunt_id")
    private int empruntID;

    @Column(name = "date_emprunt", nullable = false)
    private LocalDate dateEmprunt;

    @Column(name = "status", length = 20)
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Emprunteur emprunteur;

    @OneToMany(mappedBy = "emprunt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmpruntDetail> empruntDetails;
}
