package clases;

public class Algoritmos {

    // Método para saber si un número es par.
    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    // Método para saber si un número es primo.
    public static boolean esPrimo(int numero) {
        if (numero < 2) {
            return false;
        }
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Método para invertir una cadena de texto.
    public static String stringEnReversa(String texto) {
        String textoEnReversa = "";
        for (int i = texto.length() - 1; i >= 0; i--) {
            textoEnReversa = textoEnReversa + texto.charAt(i);
        }
        return textoEnReversa;
    }

    // Método para saber si una cadena de texto es un palíndromo.
    public static boolean esPalindromo(String texto) {
        String reversa = stringEnReversa(texto);
        if (texto.equalsIgnoreCase(reversa)) {
            return true;
        } else {
            return false;
        }
    }

    // Método para imprimir la secuencia FizzBuzz.
    public static void secuenciaFizzBuzz(int numero) {
        for (int i = 1; i <= numero; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

}
