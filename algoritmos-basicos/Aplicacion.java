import clases.Algoritmos;

public class Aplicacion {

    public static void main(String[] args) {

        // Imprime en la consola si un número es par o no.
        System.out.println("¿El número 8 es par? " + Algoritmos.esPar(8));
        System.out.println("¿El número 5 es par? " + Algoritmos.esPar(5));

        // Imprime si un número es primo o no.
        System.out.println("¿El número 11 es primo? " + Algoritmos.esPrimo(11));
        System.out.println("¿El número 20 es primo? " + Algoritmos.esPrimo(20));

        // Imprime el resultado del texto invertido.
        System.out.println("La palabra 'Daniela' en reversa es: " + Algoritmos.stringEnReversa("Daniela"));

        // Imprime si el texto es un palíndromo o no.
        System.out.println("¿La palabra 'solos' es un palíndromo? " + Algoritmos.esPalindromo("solos"));
        System.out.println("¿La palabra 'hola' es un palíndromo? " + Algoritmos.esPalindromo("hola"));
        System.out.println("¿La palabra 'Seres' es un palíndromo? " + Algoritmos.esPalindromo("Seres"));

        // Imprime la secuencia FizzBuzz.
        System.out.println("Secuencia FizzBuzz para 15:");
        Algoritmos.secuenciaFizzBuzz(15);

    }

}