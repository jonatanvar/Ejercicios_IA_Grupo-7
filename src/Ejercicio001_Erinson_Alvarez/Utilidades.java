/**
 * Sello Personalizado - Versión Completa
 * Autor: Erinson Josue Alvarez Garcia (Erinson Alvarez)
 * Correo: erinson.alvarez@unah.hn
 * Fecha: 2025-10-09
 * Código de Ejercicio: 001
 * * Clase: Utilidades.java
 * Análisis: Contiene métodos estáticos para centrar texto y generar líneas decorativas,
 * esenciales para la presentación estética del código en la consola.
 */

 package Ejercicio_001_Erinson_Alvarez;

public class Utilidades {

    /**
     * Constante que define el ancho total de la consola para centrar el texto.
     */
    public static final int ANCHO_CONSOLA = 70;
    
    /**
     * Constante para el carácter de línea horizontal decorativa.
     */
    public static final char LINEA_HORIZONTAL = '═';

    /**
     * Genera una cadena de texto centrada dentro del ancho de consola definido.
     * Si el texto es más largo que el ancho, no se centra.
     *
     * @param texto El texto a centrar.
     * @return El texto con el espaciado necesario para que aparezca centrado.
     */
    public static String centrarTexto(String texto) {
        if (texto == null) {
            return "";
        }
        int longitudTexto = texto.length();
        if (longitudTexto >= ANCHO_CONSOLA) {
            return texto; // Si es muy largo, no se centra
        }
        
        int espaciosTotales = ANCHO_CONSOLA - longitudTexto;
        int espaciosIzquierda = espaciosTotales / 2;
        
        // Se construye el formato: [espacios] + texto + [espacios restantes]
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < espaciosIzquierda; i++) {
            sb.append(' ');
        }
        sb.append(texto);
        // Ajuste por si el número de espacios totales es impar
        while (sb.length() < ANCHO_CONSOLA) {
            sb.append(' ');
        }
        
        return sb.toString();
    }

    /**
     * Imprime una línea decorativa que abarca el ancho completo de la consola.
     * Utiliza el carácter definido por LINEA_HORIZONTAL.
     */
    public static void mostrarSeparadorDecorado() {
        for (int i = 0; i < ANCHO_CONSOLA; i++) {
            System.out.print(LINEA_HORIZONTAL);
        }
        System.out.println();
    }
}