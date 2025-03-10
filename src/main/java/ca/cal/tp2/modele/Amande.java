package ca.cal.tp2.modele;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class Amande {
    private int fineID;
    private double montant;
    private LocalDate dateCreation;
    private boolean status;
}
