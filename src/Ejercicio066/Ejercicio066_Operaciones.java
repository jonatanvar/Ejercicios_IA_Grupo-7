// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #66                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio066 | 2025-11-06

package Ejercicio066;

import java.util.Scanner;

public class Ejercicio066_Operaciones {

    public static void evaluarPromedioEstudiante() {
        Scanner sc = new Scanner(System.in);
        String idioma = Ejercicio066_Menus.obtenerIdioma();

        Ejercicio066_Utilidades.mostrarEncabezado(
                idioma.equals("ES") ? "EVALUACIÓN DEL PROMEDIO" : "GRADE EVALUATION"
        );

        double promedio;

        do {
            System.out.print(idioma.equals("ES") ?
                    "Ingrese el promedio del estudiante (0 - 100): " :
                    "Enter student average (0 - 100): ");
            promedio = sc.nextDouble();
        } while (promedio < 0 || promedio > 100);

        int puntos = puntosCalidad(promedio);

        System.out.println("\n────────── RESULTADO ──────────\n");
        System.out.println((idioma.equals("ES") ?
                "Puntos de calidad asignados: " :
                "Assigned quality points: ") + puntos);

        Ejercicio066_Utilidades.mostrarSelloCorto();
        Ejercicio066_Utilidades.mostrarPie(
                idioma.equals("ES") ? "Proceso finalizado con éxito." :
                        "Process completed successfully."
        );
    }

    // ═════════════ FUNCIÓN OBLIGATORIA ═════════════
    public static int puntosCalidad(double promedio) {

        if (promedio >= 90 && promedio <= 100) return 4;
        if (promedio >= 80 && promedio <= 89) return 3;
        if (promedio >= 70 && promedio <= 79) return 2;
        if (promedio >= 60 && promedio <= 69) return 1;
        return 0;
    }
}