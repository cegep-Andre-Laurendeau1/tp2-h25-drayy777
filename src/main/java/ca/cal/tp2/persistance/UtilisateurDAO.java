package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Utilisateur;
import ca.cal.tp2.modele.Emprunteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class UtilisateurDAO {

    private final EntityManager entityManager;

    public UtilisateurDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Utilisateur utilisateur) {
        entityManager.getTransaction().begin();
        entityManager.persist(utilisateur);
        entityManager.getTransaction().commit();
    }

    public Utilisateur findById(int id) {
        return entityManager.find(Utilisateur.class, id);
    }

    public List<Utilisateur> findAll() {
        String jpql = "SELECT u FROM Utilisateur u";
        TypedQuery<Utilisateur> query = entityManager.createQuery(jpql, Utilisateur.class);
        return query.getResultList();
    }

    /**
     * Exemple pour trouver un utilisateur par son e-mail (champ unique).
     */
    public Utilisateur findByEmail(String email) {
        String jpql = "SELECT u FROM Utilisateur u WHERE u.email = :email";
        TypedQuery<Utilisateur> query = entityManager.createQuery(jpql, Utilisateur.class);
        query.setParameter("email", email);
        List<Utilisateur> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    public void update(Utilisateur utilisateur) {
        entityManager.getTransaction().begin();
        entityManager.merge(utilisateur);
        entityManager.getTransaction().commit();
    }

    public void delete(Utilisateur utilisateur) {
        entityManager.getTransaction().begin();
        Utilisateur managed = entityManager.contains(utilisateur)
                ? utilisateur
                : entityManager.merge(utilisateur);
        entityManager.remove(managed);
        entityManager.getTransaction().commit();
    }


    public List<Emprunteur> findAllEmprunteurs() {
        String jpql = "SELECT e FROM Emprunteur e";
        TypedQuery<Emprunteur> query = entityManager.createQuery(jpql, Emprunteur.class);
        return query.getResultList();
    }
}
