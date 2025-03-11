package ca.cal.tp2.service;

import ca.cal.tp2.DTO.CdDTO;
import ca.cal.tp2.DTO.DocumentDTO;
import ca.cal.tp2.DTO.DvdDTO;
import ca.cal.tp2.DTO.LivreDTO;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Livre;

import ca.cal.tp2.persistance.DocumentDAO;

import java.util.List;
import java.util.stream.Collectors;

public class DocumentService {

    private final DocumentDAO documentDAO;

    public DocumentService(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }


    private Document fromDTO(DocumentDTO dto) {
        if (dto instanceof LivreDTO) {
            LivreDTO lDto = (LivreDTO) dto;
            Livre livre = new Livre();
            livre.setDocumentID(lDto.getDocumentID()); // Pour l'update
            livre.setTitre(lDto.getTitre());
            livre.setNbExemplaires(lDto.getNbExemplaires());
            livre.setISBN(lDto.getISBN());
            livre.setAuteur(lDto.getAuteur());
            livre.setEditeur(lDto.getEditeur());
            livre.setNbPages(lDto.getNbPages());
            return livre;

        } else if (dto instanceof CdDTO) {
            CdDTO cDto = (CdDTO) dto;
            CD cd = new CD();
            cd.setDocumentID(cDto.getDocumentID());
            cd.setTitre(cDto.getTitre());
            cd.setNbExemplaires(cDto.getNbExemplaires());
            cd.setArtiste(cDto.getArtiste());
            cd.setDuree(cDto.getDuree());
            cd.setGenre(cDto.getGenre());
            return cd;

        } else if (dto instanceof DvdDTO) {
            DvdDTO dDto = (DvdDTO) dto;
            DVD dvd = new DVD();
            dvd.setDocumentID(dDto.getDocumentID());
            dvd.setTitre(dDto.getTitre());
            dvd.setNbExemplaires(dDto.getNbExemplaires());
            dvd.setDirecteur(dDto.getDirecteur());
            dvd.setDuree(dDto.getDuree());
            dvd.setNote(dDto.getNote());
            return dvd;

        } else {
            throw new IllegalArgumentException(
                    "Type de DocumentDTO non pris en charge : " + dto.getClass().getSimpleName()
            );
        }
    }

    private DocumentDTO toDTO(Document entity) {
        if (entity instanceof Livre) {
            Livre livre = (Livre) entity;
            LivreDTO lDto = new LivreDTO();
            lDto.setDocumentID(livre.getDocumentID());
            lDto.setTitre(livre.getTitre());
            lDto.setNbExemplaires(livre.getNbExemplaires());
            lDto.setISBN(livre.getISBN());
            lDto.setAuteur(livre.getAuteur());
            lDto.setEditeur(livre.getEditeur());
            lDto.setNbPages(livre.getNbPages());
            return lDto;

        } else if (entity instanceof CD) {
            CD cd = (CD) entity;
            CdDTO cDto = new CdDTO();
            cDto.setDocumentID(cd.getDocumentID());
            cDto.setTitre(cd.getTitre());
            cDto.setNbExemplaires(cd.getNbExemplaires());
            cDto.setArtiste(cd.getArtiste());
            cDto.setDuree(cd.getDuree());
            cDto.setGenre(cd.getGenre());
            return cDto;

        } else if (entity instanceof DVD) {
            DVD dvd = (DVD) entity;
            DvdDTO dDto = new DvdDTO();
            dDto.setDocumentID(dvd.getDocumentID());
            dDto.setTitre(dvd.getTitre());
            dDto.setNbExemplaires(dvd.getNbExemplaires());
            dDto.setDirecteur(dvd.getDirecteur());
            dDto.setDuree(dvd.getDuree());
            dDto.setNote(dvd.getNote());
            return dDto;

        } else {
            throw new IllegalArgumentException(
                    "Type de Document non pris en charge : " + entity.getClass().getSimpleName()
            );
        }
    }


    public DocumentDTO createDocument(DocumentDTO dto) {
        Document entity = fromDTO(dto);
        documentDAO.save(entity);
        return toDTO(entity); // Retourne le DTO avec l'ID généré
    }

    public DocumentDTO updateDocument(DocumentDTO dto) {
        Document entity = fromDTO(dto);
        documentDAO.update(entity);
        return toDTO(entity);
    }

    public void deleteDocument(DocumentDTO dto) {
        Document entity = fromDTO(dto);
        documentDAO.delete(entity);
    }

    public DocumentDTO findDocumentById(int id) {
        Document entity = documentDAO.findById(id);
        return (entity != null) ? toDTO(entity) : null;
    }

    public List<DocumentDTO> listAllDocuments() {
        return documentDAO.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<DocumentDTO> findDocumentsByTitre(String motCle) {
        return documentDAO.findByTitre(motCle)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }


    public List<LivreDTO> findLivresByAuteur(String motCle) {
        return documentDAO.findLivreByAuteur(motCle)
                .stream()
                .map(l -> (LivreDTO) toDTO(l))
                .collect(Collectors.toList());
    }
}
