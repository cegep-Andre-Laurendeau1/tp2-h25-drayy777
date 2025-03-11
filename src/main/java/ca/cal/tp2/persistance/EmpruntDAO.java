package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.Emprunteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class EmpruntDAO {

    private final EntityManager entityManager;

    public EmpruntDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Emprunt emprunt) {
        entityManager.getTransaction().begin();
        entityManager.persist(emprunt);
        entityManager.getTransaction().commit();
    }

    public Emprunt findById(int id) {
        return entityManager.find(Emprunt.class, id);
    }


    public List<Emprunt> findAll() {
        String jpql = "SELECT e FROM Emprunt e";
        TypedQuery<Emprunt> query = entityManager.createQuery(jpql, Emprunt.class);
        return query.getResultList();
    }


    public List<Emprunt> findByEmprunteur(Emprunteur emprunteur) {
        String jpql = "SELECT e FROM Emprunt e WHERE e.emprunteur = :emprunteur";
        TypedQuery<Emprunt> query = entityManager.createQuery(jpql, Emprunt.class);
        query.setParameter("emprunteur", emprunteur);
        return query.getResultList();
    }

    public void update(Emprunt emprunt) {
        entityManager.getTransaction().begin();
        entityManager.merge(emprunt);
        entityManager.getTransaction().commit();
    }

    public void delete(Emprunt emprunt) {
        entityManager.getTransaction().begin();
        Emprunt managed = entityManager.contains(emprunt) ? emprunt : entityManager.merge(emprunt);
        entityManager.remove(managed);
        entityManager.getTransaction().commit();
    }
}
