package clases;
import java.util.ArrayList;

public class CuentaBancaria {
    private double saldo;
    private Persona titular;
    private int numeroCuenta;

    // Atributo de la clase, no de la instancia. Crea una única lista global en la memoria que guardará la referencia de cada cuenta que se genere.
    private static ArrayList<CuentaBancaria> listaDeCuentasBancarias = new ArrayList<>();

    // Método constructor.
    public CuentaBancaria(double saldo, Persona titular) {
        this.saldo = saldo;
        this.titular = titular;
        // Generaun número random de 6 dígitos.
        this.numeroCuenta = (int)(Math.random() * 900000) + 100000;

        // Inserta la cuenta recién creada (objeto) a la lista de cuentas bancarias.
        // Se pasa a sí mismo (this) como el elemento a guardar.
        listaDeCuentasBancarias.add(this);
    }

    // GETTERS Y SETTERS PARA TODOS LOS ATRIBUTOS DE LA INSTANCIA
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public Persona getTitular() {
        return titular;
    }
    public void setTitular(Persona titular) {
        this.titular = titular;
    }
    public int getNumeroCuenta() {
        return numeroCuenta;
    }
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    // Método de comportamiento que realiza un depósito en el saldo de la cuenta.
    public void depositar(double monto) {
        this.saldo += monto;
        System.out.println("Depósito de: $" + monto + " realizado con éxito.");
    }

    // Método de comportamiento que realiza un retiro en el saldo de la cuenta.
    public void retirar(double monto) {
        // Evalúa si el dinero guardado en la cuenta es suficiente.
        if(monto > 0 && this.saldo >= monto) {
            // Ejecuta el retiro si la condición es verdadera.
            this.saldo -= monto;
            System.out.println("Retiro de: $" + monto + " realizado con éxito.");
        } else {
            System.out.println("Saldo insuficiente. El retiro de: $" + monto + " no se ha realizado.");
        }
    }

    // Método de comportamiento que despliega la información de la cuenta bancaria.
    public void despliegaInformacion() {
        System.out.println("\n=== Información de la cuenta ===");
        System.out.println("Número de cuenta: " + this.numeroCuenta);
        System.out.println("Saldo: $" + this.saldo);
        // print en lugar de println, para no saltar de línea y que los datos del titular aparezcan a la derecha.
        System.out.print("Titular: ");

        // El objeto Persona guardado en la variable titular ejecuta su propio método para mostrar información.
        this.titular.despliegaInformacion();
    }

    // Método de comportamiento.
    public static void imprimeInformacionDeTodasLasCuentas() {
        System.out.println("\nInformación de todas la cuentas bancarias:");
        // Recorre la colección de cuentas bancarias.
        for (CuentaBancaria cuenta : listaDeCuentasBancarias) {
            // Imprime la información de cada cuenta.
            cuenta.despliegaInformacion();
        }
    }

}