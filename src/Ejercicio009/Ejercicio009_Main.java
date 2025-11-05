package Ejercicio009;

import java.util.Scanner;

    /**
     * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 009 | 2025-10-15
     * Propósito: Flujo principal del programa. Solicita el radio de un círculo y
     * muestra su diámetro, circunferencia y área.
     */
    public class Ejercicio009_Main {

        public static void main(String[] args) {

            // 1. Mostrar Sello Personalizado
            Ejercicio009_Utilidades.mostrarSelloCorto();

            Scanner scanner = new Scanner(System.in);

            // 2. Entrada de datos (Radio)
            int radio = Ejercicio009_Utilidades.leerRadio(scanner);

            // 3. Procesamiento y Salida de Resultados
            // Los cálculos se realizan en la subrutina de salida, delegados a Ejercicio001_Operaciones
            Ejercicio009_Utilidades.mostrarResultados(radio);

            // 4. Cierre de recursos
            scanner.close();
            System.out.println("Programa finalizado.");
        }
    }

