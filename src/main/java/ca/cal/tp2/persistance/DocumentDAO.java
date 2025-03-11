package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class DocumentDAO {

    private final EntityManager entityManager;

    public DocumentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void save(Document document) {
        entityManager.getTransaction().begin();
        entityManager.persist(document);
        entityManager.getTransaction().commit();
    }


    public Document findById(int id) {
        return entityManager.find(Document.class, id);
    }


    public List<Document> findAll() {
        String jpql = "SELECT d FROM Document d";
        TypedQuery<Document> query = entityManager.createQuery(jpql, Document.class);
        return query.getResultList();
    }


    public List<Document> findByTitre(String motCle) {
        // Recherche par mot-clé (approximation) dans la colonne titre
        String jpql = "SELECT d FROM Document d WHERE d.titre LIKE :titre";
        TypedQuery<Document> query = entityManager.createQuery(jpql, Document.class);
        query.setParameter("titre", "%" + motCle + "%");
        return query.getResultList();
    }


    public List<Livre> findLivreByAuteur(String motCle) {
        String jpql = "SELECT l FROM Livre l WHERE l.auteur LIKE :auteur";
        TypedQuery<Livre> query = entityManager.createQuery(jpql, Livre.class);
        query.setParameter("auteur", "%" + motCle + "%");
        return query.getResultList();
    }


    public void update(Document document) {
        entityManager.getTransaction().begin();
        entityManager.merge(document);
        entityManager.getTransaction().commit();
    }


    public void delete(Document document) {
        entityManager.getTransaction().begin();

        Document managed = entityManager.contains(document) ? document : entityManager.merge(document);
        entityManager.remove(managed);
        entityManager.getTransaction().commit();
    }
}
