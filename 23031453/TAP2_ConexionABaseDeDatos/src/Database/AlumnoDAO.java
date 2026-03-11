package Database;

import Algoritmos.Alumno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {

    public void insertarAlumno(Alumno alumno) {

        String sql = "INSERT INTO alumnos(nombre,carrera,edad) VALUES (?,?,?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, alumno.getNombre());
            stmt.setString(2, alumno.getCarrera());
            stmt.setInt(3, alumno.getEdad());

            stmt.executeUpdate();
            System.out.println("Alumno insertado correctamente");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Alumno> obtenerAlumnos() {

        List<Alumno> lista = new ArrayList<>();

        String sql = "SELECT * FROM alumnos";

        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Alumno alumno = new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("carrera"),
                        rs.getInt("edad")
                );

                lista.add(alumno);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }

    public void eliminarAlumno(int id) {

        String sql = "DELETE FROM alumnos WHERE id=?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Alumno eliminado");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarAlumno(int id, String nombre) {

        String sql = "UPDATE alumnos SET nombre=? WHERE id=?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setInt(2, id);

            stmt.executeUpdate();

            System.out.println("Alumno actualizado");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}