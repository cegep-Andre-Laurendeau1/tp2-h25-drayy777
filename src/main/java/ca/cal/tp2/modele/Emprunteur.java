package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "emprunteur")
@Getter
@Setter
public class Emprunteur extends Utilisateur {
}
