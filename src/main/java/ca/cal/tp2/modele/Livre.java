package ca.cal.tp2.modele;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Livre extends Document{
    private String ISBN;
    private String auteur;
    private String editeur;
    private int nombrePages;
}
