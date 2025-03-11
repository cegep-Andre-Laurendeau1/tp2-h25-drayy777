package ca.cal.tp2.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DvdDTO extends DocumentDTO{
    private String directeur;
    private int duree;
    private String note;
}
