package ca.cal.tp2.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LivreDTO extends DocumentDTO{
    private String ISBN;
    private String auteur;
    private String editeur;
    private int nbPages;
}
