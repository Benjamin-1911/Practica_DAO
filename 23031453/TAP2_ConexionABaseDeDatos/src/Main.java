import Database.AlumnoDAO;
import Algoritmos.Alumno;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AlumnoDAO dao = new AlumnoDAO();

        int opcion;

        do {

            System.out.println("MENU CRUD ALUMNOS");
            System.out.println("1. Insertar alumno");
            System.out.println("2. Mostrar alumnos");
            System.out.println("3. Actualizar alumno");
            System.out.println("4. Eliminar alumno");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Carrera: ");
                    String carrera = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = sc.nextInt();

                    Alumno alumno = new Alumno(nombre, carrera, edad);
                    dao.insertarAlumno(alumno);

                    break;

                case 2:

                    List<Alumno> lista = dao.obtenerAlumnos();

                    System.out.println("\n--- LISTA DE ALUMNOS ---");

                    for (Alumno a : lista) {

                        System.out.println(
                                a.getId() + " | " +
                                a.getNombre() + " | " +
                                a.getCarrera() + " | " +
                                a.getEdad()
                        );
                    }

                    break;

                case 3:

                    System.out.print("ID del alumno a actualizar: ");
                    int idActualizar = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();

                    dao.actualizarAlumno(idActualizar, nuevoNombre);

                    break;

                case 4:

                    System.out.print("ID del alumno a eliminar: ");
                    int idEliminar = sc.nextInt();

                    dao.eliminarAlumno(idEliminar);

                    break;

                case 5:

                    System.out.println("Gracias por usar el sistema.");

                    break;

                default:

                    System.out.println("Opcion invalida.");

            }

        } while (opcion != 5);

        sc.close();
    }
}