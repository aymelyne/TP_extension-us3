import java.sql.Connection;

public class TestEtudiant {
    public static void main(String[] args) {
        try {
            Connection conn = Database.connect();
            EtudiantDAO dao = new EtudiantDAO(conn);

            Etudiant e = new Etudiant("Martin", "Lucas");
            int id = dao.ajouterEtudiant(e);

            dao.ajouterNote(id, new Notation("Maths", 12));
            dao.ajouterNote(id, new Notation("Programmation", 15));
            dao.ajouterNote(id, new Notation("Anglais", 8));

            Etudiant etu = dao.chargerEtudiant(id);

            System.out.println("Nom : " + etu.getNom());
            System.out.println("Prenom : " + etu.getPrenom());

            for (Notation n : etu.getNotes()) {
                System.out.println(n.getMatiere() + " : " + n.getNote());
            }

            System.out.println("Moyenne = " + etu.calculerMoyenne());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
