public class Notation {

    private int id;
    private String matiere;
    private double note;

    public Notation(int id, String matiere, double note) {
        this.id = id;
        this.matiere = matiere;
        this.note = note;
    }

    public Notation(String matiere, double note) {
        this.matiere = matiere;
        this.note = note;
    }

    public String getMatiere() {
        return matiere;
    }

    public double getNote() {
        return note;
    }
}
