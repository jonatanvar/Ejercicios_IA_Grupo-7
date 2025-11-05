package Ejercicio059;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 059 | 2025-10-16
 */
public class Ejercicio059_Funciones {

    /**
     * Muestra un cuadrado relleno de asteriscos ('*') en el margen izquierdo.
     * El lado del cuadrado está especificado por el parámetro 'lado'.
     * @param lado El número entero que especifica la longitud del lado del cuadrado.
     */
    public static void dibujarCuadradoRelleno(int lado) {
        // Ciclo for exterior: controla las filas (de 1 a 'lado')
        for (int i = 0; i < lado; i++) {

            // Ciclo for interior: controla las columnas (de 1 a 'lado')
            for (int j = 0; j < lado; j++) {
                System.out.print("* "); // Imprime el asterisco y un espacio para separación
            }

            System.out.println(); // Salto de línea para pasar a la siguiente fila
        }
    }
}