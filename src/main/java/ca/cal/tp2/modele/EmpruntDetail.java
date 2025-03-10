package ca.cal.tp2.modele;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmpruntDetail {
    private int lineItemID;
    private LocalDate dateRetourPrevue;
    private LocalDate dateRetourActuelle;
    private String status;
}
