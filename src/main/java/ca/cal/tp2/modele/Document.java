package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "document")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private int documentID;

    @Column(name = "titre", nullable = false)
    private String titre;

    @Column(name = "nb_exemplaires")
    private int nbExemplaires;

    @OneToMany(mappedBy = "document")
    private List<EmpruntDetail> empruntDetails;
}

