package ca.cal.tp2.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DvdDTO extends DocumentDTO{
    private String directeur;
    private int duree;
    private String note;
}
