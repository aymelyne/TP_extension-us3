import java.util.ArrayList;

public class Etudiant {

    private int id;
    private String nom;
    private String prenom;
    private ArrayList<Notation> notes = new ArrayList<>();

    public Etudiant(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Etudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public void ajouterNote(Notation n) {
        notes.add(n);
    }

    public ArrayList<Notation> getNotes() {
        return notes;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public double calculerMoyenne() {
        if (notes.size() == 0) {
            return 0;
        }
        double total = 0;
        for (Notation n : notes) {
            total += n.getNote();
        }
        return total / notes.size();
    }
}
