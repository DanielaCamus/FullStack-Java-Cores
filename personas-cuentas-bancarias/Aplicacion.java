import clases.Persona;
import clases.CuentaBancaria;

public class Aplicacion {
    public static void main(String[] args) {

        // 3 instancias de la clase Persona.
        Persona persona1 = new Persona("Roberto", 30);
        Persona persona2 = new Persona("Lucía", 25);
        Persona persona3 = new Persona("Antonio", 40);

        // 3 instancias de la clase CuentaBancaria asociadas a las personas creadas anteriormente.
        CuentaBancaria cuenta1 = new CuentaBancaria(5000, persona1);
        CuentaBancaria cuenta2 = new CuentaBancaria(2000, persona2);
        CuentaBancaria cuenta3 = new CuentaBancaria(3000, persona3);

        // Operaciones de depósito y retiro
        System.out.println("\nMovimientos de " + cuenta1.getTitular().getNombre());
        cuenta1.depositar(200);
        cuenta1.retirar(100);
        System.out.println("\nMovimientos de " + cuenta2.getTitular().getNombre());
        cuenta2.depositar(50);
        // Saldo insuficiente
        cuenta2.retirar(3000);
        System.out.println("\nMovimientos de " + cuenta3.getTitular().getNombre());
        cuenta3.retirar(500);

        // Imprime el saldo actual de cada cuenta
        System.out.println("\n=== Saldo actual de cada cuenta bancaria ===");
        System.out.println("Saldo actual de " + cuenta1.getTitular().getNombre() + " $" + cuenta1.getSaldo());
        System.out.println("Saldo actual de " + cuenta2.getTitular().getNombre() + " $" + cuenta2.getSaldo());
        System.out.println("Saldo actual de " + cuenta3.getTitular().getNombre() + " $" + cuenta3.getSaldo());

        // Ejecuta el método estático para imprimir toda la información.
        CuentaBancaria.imprimeInformacionDeTodasLasCuentas();

    }
}