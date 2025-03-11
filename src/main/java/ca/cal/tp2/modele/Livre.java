package ca.cal.tp2.modele;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;


@Entity
@Table(name = "livre")
@Getter
@Setter
public class Livre extends Document{
    @Column(name = "isbn")
    private String ISBN;

    @Column(name = "auteur")
    private String auteur;

    @Column(name = "editeur")
    private String editeur;

    @Column(name = "nb_pages")
    private int nbPages;
}
