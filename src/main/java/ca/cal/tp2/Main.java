package ca.cal.tp2;

import ca.cal.tp2.DTO.*;
import ca.cal.tp2.persistance.DocumentDAO;
import ca.cal.tp2.persistance.EmpruntDAO;
import ca.cal.tp2.persistance.UtilisateurDAO;
import ca.cal.tp2.service.DocumentService;
import ca.cal.tp2.service.EmpruntService;
import ca.cal.tp2.service.UtilisateurService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate2.ex1");
        EntityManager em = emf.createEntityManager();


        DocumentDAO documentDAO = new DocumentDAO(em);
        EmpruntDAO empruntDAO   = new EmpruntDAO(em);
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(em);



        DocumentService documentService   = new DocumentService(documentDAO);
        EmpruntService empruntService     = new EmpruntService(empruntDAO);
        UtilisateurService utilisateurService = new UtilisateurService(utilisateurDAO);

        try {

            EmprunteurDTO newEmp = new EmprunteurDTO();
            newEmp.setNom("Jean Dupont");
            newEmp.setEmail("jean@dupont.com");
            newEmp.setPhoneNumber("555-1234");

            EmprunteurDTO savedEmp = (EmprunteurDTO) utilisateurService.createUtilisateur(newEmp);
            System.out.println(">>> Emprunteur créé : " + savedEmp);

            System.out.println();


            LivreDTO livreDTO = new LivreDTO();
            livreDTO.setTitre("Je suis un livre");
            livreDTO.setAuteur("Jean Pluie");
            livreDTO.setISBN("123-456-789");
            livreDTO.setEditeur("Éditions du Temps");
            livreDTO.setNbPages(300);
            livreDTO.setNbExemplaires(3);

            LivreDTO savedLivre = (LivreDTO) documentService.createDocument(livreDTO);
            System.out.println(">>> Livre créé : " + savedLivre);
            System.out.println();

            // -- CD
            CdDTO cdDTO = new CdDTO();
            cdDTO.setTitre("Greatest Hits of The Rain");
            cdDTO.setArtiste("Rain Band");
            cdDTO.setDuree(55);
            cdDTO.setGenre("Rock");
            cdDTO.setNbExemplaires(2);

            CdDTO savedCd = (CdDTO) documentService.createDocument(cdDTO);
            System.out.println(">>> CD créé : " + savedCd);
            System.out.println();

            // -- DVD
            DvdDTO dvdDTO = new DvdDTO();
            dvdDTO.setTitre("Dance in the Rain");
            dvdDTO.setDirecteur("Sam Pluvieux");
            dvdDTO.setDuree(90);
            dvdDTO.setNote("Génial!");
            dvdDTO.setNbExemplaires(1);

            DvdDTO savedDvd = (DvdDTO) documentService.createDocument(dvdDTO);
            System.out.println(">>> DVD créé : " + savedDvd);
            System.out.println();


            System.out.println(">>> Recherche de documents contenant 'suis' :");
            List<DocumentDTO> foundDocs = documentService.findDocumentsByTitre("suis");
            for (DocumentDTO d : foundDocs) {
                System.out.println(" - " + d);
            }
            System.out.println();


            System.out.println(">>> Recherche de livres par auteur 'Jean':");
            List<LivreDTO> foundLivres = documentService.findLivresByAuteur("Jean");
            for (LivreDTO l : foundLivres) {
                System.out.println(" - " + l);
            }
            System.out.println();


            EmpruntDTO empruntDTO = new EmpruntDTO();
            empruntDTO.setDateEmprunt(LocalDate.now());
            empruntDTO.setStatus("EN_COURS");
            empruntDTO.setEmprunteur(savedEmp);  // l'emprunteur qu'on a créé

            // Ex. de logique minimaliste : vérifier si on peut emprunter un livre
            if (savedLivre.getNbExemplaires() > 0) {
                // On décrémente avant l'emprunt
                savedLivre.setNbExemplaires(savedLivre.getNbExemplaires() - 1);
                documentService.updateDocument(savedLivre);

                EmpruntDTO createdEmprunt = empruntService.createEmprunt(empruntDTO);
                System.out.println(">>> Emprunt créé : " + createdEmprunt);
            } else {
                System.out.println(">>> Plus d'exemplaires disponibles pour " + savedLivre.getTitre() + " !");
            }
            System.out.println();

            // =====================================================
            // (E) Afficher les emprunts d’un emprunteur
            // =====================================================
            System.out.println(">>> Liste des emprunts de " + savedEmp.getNom() + ":");
            List<EmpruntDTO> empruntsDeJean = empruntService.findEmpruntsByEmprunteur(savedEmp);
            for (EmpruntDTO eDto : empruntsDeJean) {
                System.out.println(" - " + eDto);
            }
            System.out.println();

            // =====================================================
            // (F) Afficher tous les documents restants
            // =====================================================
            System.out.println(">>> Liste de tous les documents :");
            List<DocumentDTO> allDocs = documentService.listAllDocuments();
            for (DocumentDTO d : allDocs) {
                System.out.println(" - " + d);
            }
            System.out.println();

        } finally {
            // Fermer les ressources
            em.close();
            emf.close();
        }
    }
}
