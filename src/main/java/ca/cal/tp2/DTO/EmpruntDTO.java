package ca.cal.tp2.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
public class EmpruntDTO {
    private int empruntID;
    private LocalDate dateEmprunt;
    private String status;
    private EmprunteurDTO emprunteur;
    private List<EmpruntDetailDTO> empruntDetails;
}
