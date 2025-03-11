package ca.cal.tp2.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class UtilisateurDTO {
    private int userID;
    private String nom;
    private String email;
    private String phoneNumber;
}
