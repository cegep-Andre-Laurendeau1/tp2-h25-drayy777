package ca.cal.tp2.modele;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Document {
    private int documentID;
    private String titre;
    private int nbExemplaires;
}
