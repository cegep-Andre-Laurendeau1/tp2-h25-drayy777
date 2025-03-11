package ca.cal.tp2.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CdDTO extends DocumentDTO{
    private String artiste;
    private int duree;
    private String genre;
}
