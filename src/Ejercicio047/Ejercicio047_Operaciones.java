// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #47                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio047 | 2025-11-05

        package Ejercicio047;

import java.util.Scanner;

public class Ejercicio047_Operaciones {

    public static void descomponerNumero() {
        Scanner sc = new Scanner(System.in);
        String idioma = Ejercicio047_Menus.obtenerIdioma();
        int numero = 0;

        Ejercicio047_Utilidades.mostrarEncabezado(
                idioma.equals("ES") ? "DESCOMPOSICIÓN DE NÚMERO" : "NUMBER DECOMPOSITION"
        );

        // Validación de entrada: número positivo, máximo 5 dígitos
        boolean valido = false;
        while (!valido) {
            System.out.print(idioma.equals("ES") ? "Ingrese un número (máx. 5 dígitos): " :
                    "Enter a number (max 5 digits): ");
            if (sc.hasNextInt()) {
                numero = sc.nextInt();
                if (numero >= 0 && numero <= 99999) {
                    valido = true;
                } else {
                    System.out.println(idioma.equals("ES") ? "Número fuera de rango, intente nuevamente." :
                            "Number out of range, try again.");
                }
            } else {
                System.out.println(idioma.equals("ES") ? "Entrada inválida, ingrese un número entero." :
                        "Invalid input, enter an integer.");
                sc.next(); // limpiar entrada
            }
        }

        // Descomponer el número y calcular suma
        int n = numero;
        int digito;
        int suma = 0;
        StringBuilder digitos = new StringBuilder();
        StringBuilder sumatoria = new StringBuilder();
        int contador = 0;

        while (n > 0) {
            digito = n % 10;
            suma += digito;
            digitos.insert(0, digito); // construir cadena de dígitos
            sumatoria.insert(0, digito);
            n /= 10;
            contador++;
            if (n > 0) {
                digitos.insert(1, ", "); // agregar coma
                sumatoria.insert(0, "+");
            }
        }

        // Ajustar formato de salida: última coma reemplazada por " y "
        String digitosStr = digitos.toString();
        int ultimaComa = digitosStr.lastIndexOf(",");
        if (ultimaComa != -1) {
            digitosStr = digitosStr.substring(0, ultimaComa) + " y" + digitosStr.substring(ultimaComa + 1);
        }

        System.out.println();
        System.out.println(numero + " = " + digitosStr + " su suma es " + sumatoria + " = " + suma);

        // Sello corto antes del pie final
        Ejercicio047_Utilidades.mostrarSelloCorto();
        Ejercicio047_Utilidades.mostrarPie(
                idioma.equals("ES") ? "Operación completada exitosamente." :
                        "Operation completed successfully."
        );
    }
}