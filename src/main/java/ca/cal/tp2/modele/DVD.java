package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "dvd")
@Getter
@Setter
public class DVD extends Document{
    @Column(name = "directeur")
    private String directeur;

    @Column(name = "duree")
    private int duree;

    @Column(name = "note")
    private String note;
}
