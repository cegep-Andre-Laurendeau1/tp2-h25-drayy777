package ca.cal.tp2.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class DocumentDTO {
    private int documentID;
    private String titre;
    private int nbExemplaires;

}
