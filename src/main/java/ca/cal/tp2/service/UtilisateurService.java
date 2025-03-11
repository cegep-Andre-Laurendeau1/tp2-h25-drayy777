package ca.cal.tp2.service;

import ca.cal.tp2.modele.Utilisateur;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.persistance.UtilisateurDAO;

import java.util.List;

public class UtilisateurService {

    private final UtilisateurDAO utilisateurDAO;

    public UtilisateurService(UtilisateurDAO utilisateurDAO) {
        this.utilisateurDAO = utilisateurDAO;
    }


    public void createUtilisateur(Utilisateur utilisateur) {
        utilisateurDAO.save(utilisateur);
    }


    public Utilisateur findUtilisateurById(int id) {
        return utilisateurDAO.findById(id);
    }


    public List<Utilisateur> findAllUtilisateurs() {
        return utilisateurDAO.findAll();
    }


    public Utilisateur findByEmail(String email) {
        return utilisateurDAO.findByEmail(email);
    }


    public void updateUtilisateur(Utilisateur utilisateur) {
        utilisateurDAO.update(utilisateur);
    }


    public void deleteUtilisateur(Utilisateur utilisateur) {
        utilisateurDAO.delete(utilisateur);
    }


    public List<Emprunteur> findAllEmprunteurs() {
        return utilisateurDAO.findAllEmprunteurs();
    }
}
