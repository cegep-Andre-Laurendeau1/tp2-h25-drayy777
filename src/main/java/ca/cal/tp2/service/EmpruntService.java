package ca.cal.tp2.service;

import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.persistance.EmpruntDAO;

import java.util.List;

public class EmpruntService {

    private final EmpruntDAO empruntDAO;

    public EmpruntService(EmpruntDAO empruntDAO) {
        this.empruntDAO = empruntDAO;
    }


    public void createEmprunt(Emprunt emprunt) {
        empruntDAO.save(emprunt);
    }


    public Emprunt findEmpruntById(int id) {
        return empruntDAO.findById(id);
    }


    public List<Emprunt> findAllEmprunts() {
        return empruntDAO.findAll();
    }


    public List<Emprunt> findEmpruntsByEmprunteur(Emprunteur emprunteur) {
        return empruntDAO.findByEmprunteur(emprunteur);
    }


    public void updateEmprunt(Emprunt emprunt) {
        empruntDAO.update(emprunt);
    }


    public void deleteEmprunt(Emprunt emprunt) {
        empruntDAO.delete(emprunt);
    }
}
