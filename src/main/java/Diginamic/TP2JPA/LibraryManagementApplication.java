package Diginamic.TP2JPA;

import Diginamic.TP2JPA.Entities.Client;
import Diginamic.TP2JPA.Entities.Emprunt;
import Diginamic.TP2JPA.Entities.Livre;
import Diginamic.TP2JPA.Repositories.IClientRepository;
import Diginamic.TP2JPA.Repositories.IEmpruntRepository;
import Diginamic.TP2JPA.Repositories.ILivreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LibraryManagementApplication implements CommandLineRunner {

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private ILivreRepository livreRepository;

    @Autowired
    private IEmpruntRepository empruntRepository;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. List all clients");
            System.out.println("2. Add a client");
            System.out.println("3. Update a client");
            System.out.println("4. Delete a client");
            System.out.println("5. List all livres");
            System.out.println("6. Add a livre");
            System.out.println("7. Update a livre");
            System.out.println("8. Delete a livre");
            System.out.println("9. List all emprunts");
            System.out.println("10. Add an emprunt");
            System.out.println("11. Update an emprunt");
            System.out.println("12. Delete an emprunt");
            System.out.println("13. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    listClients();
                    break;
                case 2:
                    addClient(scanner);
                    break;
                case 3:
                    updateClient(scanner);
                    break;
                case 4:
                    deleteClient(scanner);
                    break;
                case 5:
                    listLivres();
                    break;
                case 6:
                    addLivre(scanner);
                    break;
                case 7:
                    updateLivre(scanner);
                    break;
                case 8:
                    deleteLivre(scanner);
                    break;
                case 9:
                    listEmprunts();
                    break;
                case 10:
                    addEmprunt(scanner);
                    break;
                case 11:
                    updateEmprunt(scanner);
                    break;
                case 12:
                    deleteEmprunt(scanner);
                    break;
                case 13:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void listClients() {
        List<Client> clients = clientRepository.findAll();
        clients.forEach(client -> System.out.println(client.getId() + ": " + client.getNom() + " " + client.getPrenom()));
    }

    private void addClient(Scanner scanner) {
        System.out.print("Enter client name: ");
        String nom = scanner.nextLine();
        System.out.print("Enter client surname: ");
        String prenom = scanner.nextLine();
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        clientRepository.save(client);
        System.out.println("Client added successfully.");
    }

    private void updateClient(Scanner scanner) {
        System.out.print("Enter client ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Client client = clientRepository.findById(id).orElse(null);
        if (client != null) {
            System.out.print("Enter new client name: ");
            String nom = scanner.nextLine();
            System.out.print("Enter new client surname: ");
            String prenom = scanner.nextLine();
            client.setNom(nom);
            client.setPrenom(prenom);
            clientRepository.save(client);
            System.out.println("Client updated successfully.");
        } else {
            System.out.println("Client not found.");
        }
    }

    private void deleteClient(Scanner scanner) {
        System.out.print("Enter client ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            System.out.println("Client deleted successfully.");
        } else {
            System.out.println("Client not found.");
        }
    }

    private void listLivres() {
        List<Livre> livres = livreRepository.findAll();
        livres.forEach(livre -> System.out.println(livre.getId() + ": " + livre.getTitre() + " by " + livre.getAuteur()));
    }

    private void addLivre(Scanner scanner) {
        System.out.print("Enter book title: ");
        String titre = scanner.nextLine();
        System.out.print("Enter book author: ");
        String auteur = scanner.nextLine();
        Livre livre = new Livre();
        livre.setTitre(titre);
        livre.setAuteur(auteur);
        livreRepository.save(livre);
        System.out.println("Book added successfully.");
    }

    private void updateLivre(Scanner scanner) {
        System.out.print("Enter book ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Livre livre = livreRepository.findById(id).orElse(null);
        if (livre != null) {
            System.out.print("Enter new book title: ");
            String titre = scanner.nextLine();
            System.out.print("Enter new book author: ");
            String auteur = scanner.nextLine();
            livre.setTitre(titre);
            livre.setAuteur(auteur);
            livreRepository.save(livre);
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private void deleteLivre(Scanner scanner) {
        System.out.print("Enter book ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (livreRepository.existsById(id)) {
            livreRepository.deleteById(id);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private void listEmprunts() {
        List<Emprunt> emprunts = empruntRepository.findAll();
        emprunts.forEach(emprunt -> System.out.println(emprunt.getId() + ": Start Date - " + emprunt.getDateDebut() +
                ", End Date - " + emprunt.getDateFin() + ", Client ID - " + emprunt.getClient().getId()));
    }

    private void addEmprunt(Scanner scanner) {
        System.out.print("Enter start date (YYYY-MM-DD HH:MM:SS): ");
        LocalDateTime dateDebut = LocalDateTime.now();
        System.out.print("Enter end date (YYYY-MM-DD HH:MM:SS, or leave empty): ");
        String endDateStr = scanner.nextLine();
        LocalDateTime dateFin = endDateStr.isEmpty() ? null : LocalDateTime.parse(endDateStr + " 00:00:00");
        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Client client = clientRepository.findById(clientId).orElse(null);
        if (client != null) {
            Emprunt emprunt = new Emprunt();
            emprunt.setDateDebut(dateDebut);
            emprunt.setDateFin(dateFin);
            emprunt.setClient(client);
            empruntRepository.save(emprunt);
            System.out.println("Emprunt added successfully.");
        } else {
            System.out.println("Client not found.");
        }
    }

    private void updateEmprunt(Scanner scanner) {
        System.out.print("Enter emprunt ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Emprunt emprunt = empruntRepository.findById(id).orElse(null);
        if (emprunt != null) {
            System.out.print("Enter new start date (YYYY-MM-DD HH:MM:SS): ");
            LocalDateTime dateDebut = LocalDateTime.parse(scanner.nextLine() + " 00:00:00");
            System.out.print("Enter new end date (YYYY-MM-DD HH:MM:SS, or leave empty): ");
            String endDateStr = scanner.nextLine();
            LocalDateTime dateFin = endDateStr.isEmpty() ? null : LocalDateTime.parse(endDateStr + " 00:00:00");
            System.out.print("Enter new client ID: ");
            int clientId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            Client client = clientRepository.findById(clientId).orElse(null);
            if (client != null) {
                emprunt.setDateDebut(dateDebut);
                emprunt.setDateFin(dateFin);
                emprunt.setClient(client);
                empruntRepository.save(emprunt);
                System.out.println("Emprunt updated successfully.");
            } else {
                System.out.println("Client not found.");
            }
        } else {
            System.out.println("Emprunt not found.");
        }
    }

    private void deleteEmprunt(Scanner scanner) {
        System.out.print("Enter emprunt ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (empruntRepository.existsById(id)) {
            empruntRepository.deleteById(id);
            System.out.println("Emprunt deleted successfully.");
        } else {
            System.out.println("Emprunt not found.");
        }
    }

      public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }
}
