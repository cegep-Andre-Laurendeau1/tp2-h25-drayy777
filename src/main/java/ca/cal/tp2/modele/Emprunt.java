package ca.cal.tp2.modele;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Emprunt {
    private int empruntID;
    private LocalDate dateEmprunt;
    private String status;
}
