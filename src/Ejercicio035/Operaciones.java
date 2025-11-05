/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 035 | 2025-10-23
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que imprime una tabla de los equivalentes binario, octal y hexadecimal de los números decimales en el rango 1 al 256, utilizando un ciclo for. Incluye menús de idioma y control.
 */

package Ejercicio_035;

/**
 * Módulo Operaciones: Implementa la lógica principal del negocio, que es la
 * generación y la impresión de la tabla de conversión numérica
 * (Decimal, Binario, Octal, Hexadecimal) usando un ciclo for.
 */
public class Operaciones {

    private final String idioma; // Almacena el idioma seleccionado

    // Rango de conversión
    private static final int INICIO_RANGO = 1;
    private static final int FIN_RANGO = 256;

    /**
     * Constructor para inicializar la clase con el idioma actual.
     * @param idioma La clave del idioma ("ES" o "EN").
     */
    public Operaciones(String idioma) {
        this.idioma = idioma;
    }

    /**
     * Imprime la tabla de equivalentes de bases numéricas (1 a 256).
     * Utiliza un ciclo for para iterar sobre el rango definido.
     */
    public void imprimirTablaDeEquivalentes() {
        
        System.out.println("\n--- " + Utilidades.getTexto(idioma, "TITULO_OPERACIONES") + " ---");
        
        // 1. Imprimir encabezado de la tabla
        System.out.println(Utilidades.getTexto(idioma, "MSG_INSTRUCCION_TABLA"));
        System.out.println("-----------------------------------------------------");
        System.out.printf("| %-8s | %-10s | %-8s | %-10s |%n", 
                Utilidades.getTexto(idioma, "COL_DECIMAL"), 
                Utilidades.getTexto(idioma, "COL_BINARIO"),
                Utilidades.getTexto(idioma, "COL_OCTAL"),
                Utilidades.getTexto(idioma, "COL_HEXADECIMAL"));
        System.out.println("-----------------------------------------------------");

        // 2. Ciclo FOR para iterar sobre el rango 1 a 256
        for (int i = INICIO_RANGO; i <= FIN_RANGO; i++) {
            
            // Realizar las conversiones utilizando la clase Integer
            String binario = Integer.toBinaryString(i);
            String octal = Integer.toOctalString(i);
            String hexadecimal = Integer.toHexString(i).toUpperCase(); // Hexadecimal en mayúsculas
            
            // Imprimir la fila de la tabla
            System.out.printf("| %-8d | %-10s | %-8s | %-10s |%n", 
                    i, binario, octal, hexadecimal);
        }
        
        System.out.println("-----------------------------------------------------");
    }
}
