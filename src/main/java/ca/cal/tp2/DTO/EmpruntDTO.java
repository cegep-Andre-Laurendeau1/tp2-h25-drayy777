package ca.cal.tp2.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class EmpruntDTO {
    private int empruntID;
    private LocalDate dateEmprunt;
    private String status;
    private EmprunteurDTO emprunteur;
    private List<EmpruntDetailDTO> empruntDetails;
}
