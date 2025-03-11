package ca.cal.tp2.service;

import ca.cal.tp2.persistance.DocumentDAO;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Livre;

import java.util.List;

public class DocumentService {

    private final DocumentDAO documentDAO;

    public DocumentService(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }


    public void createDocument(Document document) {
        documentDAO.save(document);
    }


    public void updateDocument(Document document) {
        documentDAO.update(document);
    }


    public void deleteDocument(Document document) {
        documentDAO.delete(document);
    }


    public Document findDocumentById(int id) {
        return documentDAO.findById(id);
    }


    public List<Document> listAllDocuments() {
        return documentDAO.findAll();
    }


    public List<Document> findDocumentsByTitre(String motCle) {
        return documentDAO.findByTitre(motCle);
    }


    public List<Livre> findLivresByAuteur(String motCle) {
        return documentDAO.findLivreByAuteur(motCle);
    }
}
