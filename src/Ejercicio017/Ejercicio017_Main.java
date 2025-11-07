// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Metadatos del Desarrollador                                                ║
// ║ Nombre: Dany Noguera                                                       ║
// ║ Correo Electrónico: dany.noguera@unah.hn                                   ║
// ║ Fecha: 2025-11-04                                                          ║
// ║                                                                             ║
// ║ Identificación del Código                                                   ║
/* ║ Código del Ejercicio: 017                                                   ║
   ║ Enunciado: A partir de acá todos los ejercicios contenidos en esta guía     ║
   ║ deberán contar con un menú de selección de idioma y luego con un segundo    ║
   ║ menú donde pueda elegirse entre ejecutarse o interrumpir la ejecución       ║
   ║ (finalizar el programa). Tomando como base el ejercicio “Par o impar” ahora ║
   ║ usted lo que debe hacer es agarrar ese número y mostrar gráficas            ║
   ║ horizontales de la siguiente manera:                                        ║
   ║   1. tantos asteriscos como unidades posea el número.                       ║
   ║   2. Cada asterisco de la gráfica representa dos unidades.                  ║
   ║   3. Cada asterisco de la gráfica representa cinco unidades.                ║
   ║ Por ejemplo si se lee el 15:                                                ║
   ║ Número 15 es impar:                                                         ║
   ║   15 | * * * * * * * * * * * * * * *  (cada * = 1 unidad)                   ║
   ║   15 | * * * * * * * *               (cada * = 2 unidades)                  ║
   ║   15 | * * *                          (cada * = 5 unidades)                 ║
*/
// ║                                                                             ║
// ║ Distribución de Archivos:                                                   ║
// ║ 1. Ejercicio017_Main.java → Control del flujo y ejecución del programa      ║
// ║ 2. Ejercicio017_Menus.java → Menú de idioma y menú de ejecutar/salir        ║
// ║ 3. Ejercicio017_Utilidades.java → Bordes, encabezados, estética             ║
// ║ 4. Ejercicio017_Operaciones.java → Lógica (pares e impresión de gráficas)  ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | dany.noguera@unah.hn | 017 | 2025-11-04

package Ejercicio017;

import java.util.Scanner;

public class Ejercicio017_Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Ejercicio017_Utilidades.mostrarEncabezado("EJERCICIO 017 - GRÁFICAS HORIZONTALES", 78);

        int idioma = Ejercicio017_Menus.menuIdioma(sc);
        boolean ejecutar;

        do {
            ejecutar = Ejercicio017_Menus.menuAccion(sc, idioma);

            if (ejecutar) {
                System.out.print((idioma == 1)
                        ? "Ingrese un número entero: "
                        : "Enter an integer number: ");

                int num = sc.nextInt();

                Ejercicio017_Utilidades.mostrarSeparador(
                        (idioma == 1) ? "RESULTADOS" : "RESULTS", 78);

                System.out.println(Ejercicio017_Operaciones.mensajeParidad(num, idioma));
                Ejercicio017_Operaciones.graficaUno(num, idioma);
                Ejercicio017_Operaciones.graficaDos(num, idioma);
                Ejercicio017_Operaciones.graficaCinco(num, idioma);
            }

        } while (ejecutar);

        Ejercicio017_Utilidades.mostrarPie((idioma == 1)
                ? "Programa finalizado."
                : "Program terminated."
        );
    }
}
