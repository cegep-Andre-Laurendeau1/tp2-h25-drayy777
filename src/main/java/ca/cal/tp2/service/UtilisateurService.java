package ca.cal.tp2.service;

import ca.cal.tp2.DTO.EmprunteurDTO;
import ca.cal.tp2.DTO.PreposeDTO;
import ca.cal.tp2.DTO.UtilisateurDTO;

import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.modele.Prepose;
import ca.cal.tp2.modele.Utilisateur;

import ca.cal.tp2.persistance.UtilisateurDAO;

import java.util.List;
import java.util.stream.Collectors;

public class UtilisateurService {

    private final UtilisateurDAO utilisateurDAO;

    public UtilisateurService(UtilisateurDAO utilisateurDAO) {
        this.utilisateurDAO = utilisateurDAO;
    }


    private Utilisateur fromDTO(UtilisateurDTO dto) {
        if (dto instanceof EmprunteurDTO) {
            EmprunteurDTO eDto = (EmprunteurDTO) dto;
            Emprunteur e = new Emprunteur();
            e.setUserID(eDto.getUserID());
            e.setNom(eDto.getNom());
            e.setEmail(eDto.getEmail());
            e.setPhoneNumber(eDto.getPhoneNumber());
            return e;

        } else if (dto instanceof PreposeDTO) {
            PreposeDTO pDto = (PreposeDTO) dto;
            Prepose p = new Prepose();
            p.setUserID(pDto.getUserID());
            p.setNom(pDto.getNom());
            p.setEmail(pDto.getEmail());
            p.setPhoneNumber(pDto.getPhoneNumber());
            return p;

        } else {
            throw new IllegalArgumentException(
                    "Type de UtilisateurDTO non pris en charge : " + dto.getClass().getSimpleName()
            );
        }
    }

    private UtilisateurDTO toDTO(Utilisateur entity) {
        if (entity instanceof Emprunteur) {
            Emprunteur emp = (Emprunteur) entity;
            EmprunteurDTO eDto = new EmprunteurDTO();
            eDto.setUserID(emp.getUserID());
            eDto.setNom(emp.getNom());
            eDto.setEmail(emp.getEmail());
            eDto.setPhoneNumber(emp.getPhoneNumber());
            return eDto;

        } else if (entity instanceof Prepose) {
            Prepose prepose = (Prepose) entity;
            PreposeDTO pDto = new PreposeDTO();
            pDto.setUserID(prepose.getUserID());
            pDto.setNom(prepose.getNom());
            pDto.setEmail(prepose.getEmail());
            pDto.setPhoneNumber(prepose.getPhoneNumber());
            return pDto;

        } else {
            throw new IllegalArgumentException(
                    "Type de Utilisateur non pris en charge : " + entity.getClass().getSimpleName()
            );
        }
    }


    public UtilisateurDTO createUtilisateur(UtilisateurDTO dto) {
        Utilisateur u = fromDTO(dto);
        utilisateurDAO.save(u);
        return toDTO(u);
    }

    public UtilisateurDTO findUtilisateurById(int id) {
        Utilisateur u = utilisateurDAO.findById(id);
        return (u != null) ? toDTO(u) : null;
    }

    public List<UtilisateurDTO> findAllUtilisateurs() {
        return utilisateurDAO.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public UtilisateurDTO findByEmail(String email) {
        Utilisateur u = utilisateurDAO.findByEmail(email);
        return (u != null) ? toDTO(u) : null;
    }

    public UtilisateurDTO updateUtilisateur(UtilisateurDTO dto) {
        Utilisateur u = fromDTO(dto);
        utilisateurDAO.update(u);
        return toDTO(u);
    }

    public void deleteUtilisateur(UtilisateurDTO dto) {
        Utilisateur u = fromDTO(dto);
        utilisateurDAO.delete(u);
    }

    public List<EmprunteurDTO> findAllEmprunteurs() {
        return utilisateurDAO.findAllEmprunteurs().stream()
                .map(emp -> {
                    EmprunteurDTO eDto = new EmprunteurDTO();
                    eDto.setUserID(emp.getUserID());
                    eDto.setNom(emp.getNom());
                    eDto.setEmail(emp.getEmail());
                    eDto.setPhoneNumber(emp.getPhoneNumber());
                    return eDto;
                })
                .collect(Collectors.toList());
    }
}
