package Ejercicio019;

import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 019 | 2025-10-15
 */
public class Ejercicio019_Main {

    private static final int MSG_CUENTA = 11;
    private static final int MSG_SALDO_INICIAL = 12;
    private static final int MSG_CARGOS = 13;
    private static final int MSG_CREDITOS = 14;
    private static final int MSG_LIMITE = 15;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Ejercicio019_Utilidades.mostrarSelloCorto();

        Ejercicio019_Utilidades.seleccionarIdioma(scanner);

        if (!Ejercicio019_Utilidades.mostrarMenuEjecucion(scanner)) {
            scanner.close();
            return;
        }

        Ejercicio019_Utilidades.mostrarEncabezado();

        int numeroCuenta = Ejercicio019_Utilidades.leerEntero(scanner, Ejercicio019_Utilidades.obtenerTexto(MSG_CUENTA, true));

        while (numeroCuenta != 0) {

            double saldoInicial = Ejercicio019_Utilidades.leerDouble(scanner, Ejercicio019_Utilidades.obtenerTexto(MSG_SALDO_INICIAL, true));
            double cargos = Ejercicio019_Utilidades.leerDouble(scanner, Ejercicio019_Utilidades.obtenerTexto(MSG_CARGOS, true));
            double creditos = Ejercicio019_Utilidades.leerDouble(scanner, Ejercicio019_Utilidades.obtenerTexto(MSG_CREDITOS, true));
            double limiteCredito = Ejercicio019_Utilidades.leerDouble(scanner, Ejercicio019_Utilidades.obtenerTexto(MSG_LIMITE, true));

            double nuevoSaldo = Ejercicio019_Operaciones.calcularNuevoSaldo(saldoInicial, cargos, creditos);

            if (Ejercicio019_Operaciones.excedioLimite(nuevoSaldo, limiteCredito)) {
                Ejercicio019_Utilidades.mostrarAdvertencia(numeroCuenta, limiteCredito, nuevoSaldo);
            } else {
                System.out.printf("Cuenta %d: Nuevo saldo $%.2f (Dentro del límite: $%.2f)%n", numeroCuenta, nuevoSaldo, limiteCredito);
            }

            System.out.println();
            numeroCuenta = Ejercicio019_Utilidades.leerEntero(scanner, Ejercicio019_Utilidades.obtenerTexto(MSG_CUENTA, true));
        }

        scanner.close();
        System.out.println("\nPrograma finalizado. Gracias por usar el sistema.");
    }
}