package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "cd")
@Getter
@Setter
public class CD extends Document{
    @Column(name = "artiste")
    private String artiste;

    @Column(name = "duree")
    private int duree;

    @Column(name = "genre")
    private String genre;
}
