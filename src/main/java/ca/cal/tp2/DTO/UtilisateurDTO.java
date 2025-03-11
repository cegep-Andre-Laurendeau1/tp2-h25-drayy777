package ca.cal.tp2.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class UtilisateurDTO {
    private int userID;
    private String nom;
    private String email;
    private String phoneNumber;
}
