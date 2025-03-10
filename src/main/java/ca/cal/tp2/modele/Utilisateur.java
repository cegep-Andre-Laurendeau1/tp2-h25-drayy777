package ca.cal.tp2.modele;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Utilisateur {
    private int userID;
    private String nom;
    private String email;
    private String phoneNumber;
}
