package ca.cal.tp2.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class DocumentDTO {
    private int documentID;
    private String titre;
    private int nbExemplaires;

}
