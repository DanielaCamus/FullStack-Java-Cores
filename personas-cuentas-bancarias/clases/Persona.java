package clases;

public class Persona {
    private String nombre;
    private int edad;

    // Método Constructor.
    public Persona (String nombre, int edad) {
        // Asigna el valor del parámetro local (derecha) al atributo de instancia (izquierda).
        this.nombre = nombre;
        this.edad = edad;
    }

    // Métodos Getters y Setters para los atributos privados.
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método de comportamiento.
    public void despliegaInformacion() {
        System.out.println("Nombre: " + this.nombre + ", Edad: " + this.edad);
    }
    
}