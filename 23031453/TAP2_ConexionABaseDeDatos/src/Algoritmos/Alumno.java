package Algoritmos;

public class Alumno {

    private int id;
    private String nombre;
    private String carrera;
    private int edad;

    public Alumno(int id, String nombre, String carrera, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;
        this.edad = edad;
    }

    public Alumno(String nombre, String carrera, int edad) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.edad = edad;
    }

    public int getId() { return id; }

    public String getNombre() { return nombre; }

    public String getCarrera() { return carrera; }

    public int getEdad() { return edad; }
}