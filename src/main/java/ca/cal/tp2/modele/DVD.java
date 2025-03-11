package ca.cal.tp2.modele;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DVD extends Document{
    private String directeur;
    private int duree;
    private String note;
}
