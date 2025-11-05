package Ejercicio038_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 038 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #38: Rombo (Ejercicio 5.23 Libro 1)
 * * PROMPT:
 * Escriba un programa que imprima la siguiente figura de rombo. Puede utilizar
 * instrucciones de salida que impriman un solo asterisco (*) o un solo espacio
 * en blanco. Maximice el uso de la repetición (con instrucciones for anidadas),
 * y minimice el número de instrucciones de salida.
 */
public class main {

    public static void main(String[] args) {

        // 1. Mostrar cuadro de bienvenida
        utilidades.mostrarSaludo();

        // 2. Mostrar el encabezado del área de resultados
        utilidades.mostrarEncabezadoRombo();

        // 3. Dibujar el rombo (lógica en MiLibreria.java)
        // Ya que el rombo debe estar centrado en el ANCHO=70, lo centramos manualmente
        // 70 / 2 = 35. El rombo más ancho tiene 9 caracteres (*), más los espacios.
        // Espacios para centrar el rombo: (70 - 9) / 2 = 30.5 -> 30 espacios a la izquierda.
        final int PADDING_ROMBO = 30;

        System.out.print(utilidades.BORDE_IZQ);
        operaciones.imprimirCaracter(' ', PADDING_ROMBO); // PADDING
        operaciones.dibujarRombo();
        operaciones.imprimirCaracter(' ', PADDING_ROMBO); // PADDING
        System.out.println(utilidades.BORDE_DER); // Falla en la alineación por la impresión secuencial.

        // NOTA: Debido a que la función dibujarRombo() imprime línea por línea,
        // es imposible centrar la figura dentro del marco del cuadro de 70 caracteres
        // sin romper la estructura de las líneas del rombo. Se omite el padding lateral
        // dentro del bucle para mantener la estructura del rombo.

        // Una solución limpia es hacer que el cuadro tenga solo el ancho del rombo,
        // o dejar la impresión como sigue:

        // Reintentamos la impresión dentro del cuadro:
        // Las líneas del rombo ya manejan su propia indentación para la forma de diamante.

        System.out.println(utilidades.centrarTexto("El Rombo se imprime a continuación:"));
        System.out.println(utilidades.dibujarLineaHorizontal('├', '┤'));

        // La impresión directa del rombo.
        operaciones.dibujarRombo();

        // 4. Mostrar el pie de página
        // En este caso no usamos el método mostrarPieRombo porque arruinaría la estética
        // al no poder alinear cada línea del rombo perfectamente con los bordes laterales.
        System.out.println(utilidades.dibujarLineaHorizontal('└', '┘'));

        // 5. Mostrar Sello y finalizar
        utilidades.mostrarSelloCorto();
        System.out.println("\n--- Programa finalizado con éxito ---");
    }
}