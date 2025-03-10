package ca.cal.tp2.modele;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CD extends Document{
    private String artiste;
    private int duree;
    private String genre;
}
