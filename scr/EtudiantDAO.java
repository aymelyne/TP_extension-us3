import java.sql.*;

public class EtudiantDAO {

    private Connection conn;

    public EtudiantDAO(Connection conn) {
        this.conn = conn;
    }

    public int ajouterEtudiant(Etudiant e) throws SQLException {
        String sql = "INSERT INTO etudiants (nom, prenom) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, e.getNom());
        ps.setString(2, e.getPrenom());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    public void ajouterNote(int etuId, Notation n) throws SQLException {
        String sql = "INSERT INTO notations (etudiant_id, matiere, note) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, etuId);
        ps.setString(2, n.getMatiere());
        ps.setDouble(3, n.getNote());
        ps.executeUpdate();
    }

    public Etudiant chargerEtudiant(int id) throws SQLException {
        String sql = "SELECT * FROM etudiants WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            return null;
        }

        Etudiant etu = new Etudiant(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("prenom")
        );

        String sqlNotes = "SELECT * FROM notations WHERE etudiant_id = ?";
        PreparedStatement ps2 = conn.prepareStatement(sqlNotes);
        ps2.setInt(1, id);
        ResultSet rs2 = ps2.executeQuery();

        while (rs2.next()) {
            Notation n = new Notation(
                    rs2.getInt("id"),
                    rs2.getString("matiere"),
                    rs2.getDouble("note")
            );
            etu.ajouterNote(n);
        }

        return etu;
    }
}
