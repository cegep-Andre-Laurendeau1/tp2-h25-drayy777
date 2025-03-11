package ca.cal.tp2.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CdDTO extends DocumentDTO{
    private String artiste;
    private int duree;
    private String genre;
}
