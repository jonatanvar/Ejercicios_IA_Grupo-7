// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #37                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio037 | 2025-11-05

package Ejercicio037;

import java.util.Scanner;

public class Ejercicio037_Operaciones {

    public static void calcularSueldo() {
        Scanner sc = new Scanner(System.in);

        String idioma = Ejercicio037_Menus.obtenerIdioma();

        Ejercicio037_Utilidades.mostrarEncabezado(
                idioma.equals("ES") ?
                        "CÁLCULO DE SUELDO SEMANAL" :
                        "WEEKLY PAYROLL CALCULATION"
        );

        System.out.print(idioma.equals("ES") ? "Ingrese código de pago (1-4): " :
                "Enter pay code (1-4): ");
        int codigo = sc.nextInt();

        double sueldo = 0;

        switch (codigo) {
            case 1 -> { // GERENTE
                System.out.print(idioma.equals("ES") ? "Salario fijo semanal: " :
                        "Weekly fixed salary: ");
                sueldo = sc.nextDouble();
            }
            case 2 -> { // POR HORAS
                System.out.print(idioma.equals("ES") ? "Sueldo por hora: " :
                        "Hourly pay: ");
                double sueldoHora = sc.nextDouble();

                System.out.print(idioma.equals("ES") ? "Horas trabajadas: " :
                        "Hours worked: ");
                double horas = sc.nextDouble();

                if (horas > 40)
                    sueldo = 40 * sueldoHora + (horas - 40) * sueldoHora * 1.5;
                else
                    sueldo = horas * sueldoHora;
            }
            case 3 -> { // COMISIÓN
                System.out.print(idioma.equals("ES") ? "Ventas de la semana: " :
                        "Total weekly sales: ");
                double ventas = sc.nextDouble();
                sueldo = 250 + (ventas * 0.057);
            }
            case 4 -> { // POR PIEZAS
                System.out.print(idioma.equals("ES") ? "Pago por pieza: " :
                        "Pay per piece: ");
                double pagoPieza = sc.nextDouble();

                System.out.print(idioma.equals("ES") ? "Unidades producidas: " :
                        "Pieces produced: ");
                int piezas = sc.nextInt();

                sueldo = piezas * pagoPieza;
            }
            default -> {
                System.out.println(idioma.equals("ES") ?
                        "Código inválido." : "Invalid code.");
                return;
            }
        }

        System.out.printf(idioma.equals("ES") ?
                        "\nSueldo semanal calculado: %.2f\n" :
                        "\nCalculated weekly salary: %.2f\n",
                sueldo
        );

        // Sello corto antes del pie final
        Ejercicio037_Utilidades.mostrarSelloCorto();
        Ejercicio037_Utilidades.mostrarPie(
                idioma.equals("ES") ? "Proceso finalizado con éxito." :
                        "Process completed successfully."
        );
    }
}