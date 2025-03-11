package ca.cal.tp2.service;

import ca.cal.tp2.DTO.EmpruntDTO;
import ca.cal.tp2.DTO.EmprunteurDTO;

import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.Emprunteur;

import ca.cal.tp2.persistance.EmpruntDAO;

import java.util.List;
import java.util.stream.Collectors;

public class EmpruntService {

    private final EmpruntDAO empruntDAO;

    public EmpruntService(EmpruntDAO empruntDAO) {
        this.empruntDAO = empruntDAO;
    }

    private Emprunt fromDTO(EmpruntDTO dto) {
        Emprunt e = new Emprunt();
        e.setEmpruntID(dto.getEmpruntID());
        e.setDateEmprunt(dto.getDateEmprunt());
        e.setStatus(dto.getStatus());
        // Associer l'emprunteur si présent
        if (dto.getEmprunteur() != null) {
            Emprunteur emp = new Emprunteur();
            emp.setUserID(dto.getEmprunteur().getUserID());
            emp.setNom(dto.getEmprunteur().getNom());
            emp.setEmail(dto.getEmprunteur().getEmail());
            emp.setPhoneNumber(dto.getEmprunteur().getPhoneNumber());
            e.setEmprunteur(emp);
        }
        return e;
    }

    private EmpruntDTO toDTO(Emprunt e) {
        EmpruntDTO dto = new EmpruntDTO();
        dto.setEmpruntID(e.getEmpruntID());
        dto.setDateEmprunt(e.getDateEmprunt());
        dto.setStatus(e.getStatus());
        // Convertir l'emprunteur
        if (e.getEmprunteur() != null) {
            EmprunteurDTO empDto = new EmprunteurDTO();
            empDto.setUserID(e.getEmprunteur().getUserID());
            empDto.setNom(e.getEmprunteur().getNom());
            empDto.setEmail(e.getEmprunteur().getEmail());
            empDto.setPhoneNumber(e.getEmprunteur().getPhoneNumber());
            dto.setEmprunteur(empDto);
        }
        return dto;
    }


    public EmpruntDTO createEmprunt(EmpruntDTO dto) {
        Emprunt e = fromDTO(dto);
        empruntDAO.save(e);
        return toDTO(e);
    }

    public EmpruntDTO findEmpruntById(int id) {
        Emprunt e = empruntDAO.findById(id);
        return (e != null) ? toDTO(e) : null;
    }

    public List<EmpruntDTO> findAllEmprunts() {
        return empruntDAO.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<EmpruntDTO> findEmpruntsByEmprunteur(EmprunteurDTO emprunteurDTO) {
        // Convertir le DTO en Emprunteur
        Emprunteur emp = new Emprunteur();
        emp.setUserID(emprunteurDTO.getUserID());
        emp.setNom(emprunteurDTO.getNom());
        emp.setEmail(emprunteurDTO.getEmail());
        emp.setPhoneNumber(emprunteurDTO.getPhoneNumber());

        return empruntDAO.findByEmprunteur(emp)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public EmpruntDTO updateEmprunt(EmpruntDTO dto) {
        Emprunt e = fromDTO(dto);
        empruntDAO.update(e);
        return toDTO(e);
    }

    public void deleteEmprunt(EmpruntDTO dto) {
        Emprunt e = fromDTO(dto);
        empruntDAO.delete(e);
    }
}
