package ca.cal.tp2.modele;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Entity
 @Table(name = "emprunteur")
 @Getter
 @Setter
 public class Emprunteur extends Utilisateur {

    @OneToMany(mappedBy = "emprunteur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Emprunt> emprunts;

    @OneToMany(mappedBy = "emprunteur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Amande> amandes;
}
