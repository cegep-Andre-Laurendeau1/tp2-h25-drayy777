package ca.cal.tp2.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class AmandeDTO {
    private int amandeID;
    private double montant;
    private LocalDate dateCreation;
    private boolean status;
    private EmprunteurDTO emprunteur;
}
