/**
 * Sello Personalizado - Versión Completa
 * Autor: Erinson Josue Alvarez Garcia
 * Correo: erinson.alvarez@unah.hn
 * Fecha: 2025-10-09
 * Código de Ejercicio: 002
 * * Clase: Utilidades.java
 * Análisis: Contiene constantes y métodos estáticos reutilizables para el formato
 * de la salida en consola, incluyendo centrado de texto y líneas decorativas, 
 * así como el método para dibujar el sello completo.
 */

 package Ejercicio_002_Erinson_Alvarez;

import java.util.Arrays;

public class Utilidades {

    // --- Constantes para Estética ---
    public static final int ANCHO_CONSOLA = 80;
    public static final char LINEA_HORIZONTAL = '═';
    public static final char BORDE_VERTICAL = '│';

    // --- Metadatos del Desarrollador (Para el Sello) ---
    private static final String AUTOR = "Erinson Josue Alvarez Garcia";
    private static final String CORREO = "erinson.alvarez@unah.hn";
    private static final String FECHA = "2025-10-09";
    private static final String CODIGO_EJERCICIO = "2";
    
    // --- Sello Personalizado - Versión Corta (Para Archivos Modulares) ---
    private static final String SELLO_CORTO = "Erinson Alvarez | erinson.alvarez@unah.hn | 002 | 2025-10-09";

    // ... (El método imprimirLineaCentrada permanece igual) ...

    // ... (El método mostrarSeparadorDecorado permanece igual) ...
    
    /**
     * Genera una cadena de texto centrada dentro del ancho de consola definido.
     * Utiliza un carácter de borde vertical en los extremos si no se especifica
     * un borde diferente.
     *
     * @param texto El texto a centrar.
     * @return El texto con el espaciado necesario para que aparezca centrado.
     */
    public static String imprimirLineaCentrada(String texto) {
        return imprimirLineaCentrada(texto, BORDE_VERTICAL, BORDE_VERTICAL);
    }
    
    /**
     * Genera una cadena de texto centrada, permitiendo especificar los caracteres
     * de borde izquierdo y derecho.
     *
     * @param texto El texto a centrar.
     * @param bordeIzquierdo Carácter de borde izquierdo.
     * @param bordeDerecho Carácter de borde derecho.
     * @return La línea completa con bordes y texto centrado.
     */
    public static String imprimirLineaCentrada(String texto, char bordeIzquierdo, char bordeDerecho) {
        if (texto == null) texto = "";
        
        int longitudInterna = ANCHO_CONSOLA - 2; // Espacio entre los bordes
        int longitudTexto = texto.length();
        
        if (longitudTexto > longitudInterna) {
            // Si es muy largo, cortarlo para que quepa entre los bordes
            texto = texto.substring(0, longitudInterna);
            longitudTexto = longitudInterna;
        }
        
        int espaciosTotales = longitudInterna - longitudTexto;
        int espaciosIzquierda = espaciosTotales / 2;
        int espaciosDerecha = espaciosTotales - espaciosIzquierda;
        
        // Construir la línea: [bordeIzq] + [espaciosIzq] + [texto] + [espaciosDer] + [bordeDer]
        StringBuilder sb = new StringBuilder();
        sb.append(bordeIzquierdo);
        for (int i = 0; i < espaciosIzquierda; i++) {
            sb.append(' ');
        }
        sb.append(texto);
        for (int i = 0; i < espaciosDerecha; i++) {
            sb.append(' ');
        }
        sb.append(bordeDerecho);
        
        return sb.toString();
    }

    /**
     * Imprime una línea decorativa completa que abarca el ancho de consola, 
     * utilizando el carácter de línea horizontal.
     */
    public static void mostrarSeparadorDecorado() {
        for (int i = 0; i < ANCHO_CONSOLA; i++) {
            System.out.print(LINEA_HORIZONTAL);
        }
        System.out.println();
    }
    
    /**
     * Muestra la información completa del sello de desarrollador de forma elegante.
     */
    public static void mostrarSelloElegante() {
        char[] relleno = new char[ANCHO_CONSOLA - 2];
        Arrays.fill(relleno, LINEA_HORIZONTAL);
        String lineaHorizontalInterna = new String(relleno);
        
        // Borde superior
        System.out.println("╔" + lineaHorizontalInterna + "╗");

        // Título
        System.out.println(imprimirLineaCentrada("** ENCABEZADO PERSONALIZADO - VERSIÓN COMPLETA **"));
                char[] rellenoSeparador = new char[ANCHO_CONSOLA - 2];
        Arrays.fill(rellenoSeparador, LINEA_HORIZONTAL);
        String separador = new String(rellenoSeparador);
        System.out.println('╠' + separador + '╣');

        // Metadatos
        System.out.println(imprimirLineaCentrada("Autor: " + AUTOR));
        System.out.println(imprimirLineaCentrada("Correo: " + CORREO));
        System.out.println(imprimirLineaCentrada("Fecha: " + FECHA));
        System.out.println(imprimirLineaCentrada("Código de Ejercicio: " + CODIGO_EJERCICIO));
        
        // Separador para la versión corta
        // Reutilizamos el separador ya creado
        System.out.println('╠' + separador + '╣');
        
        // Versión Corta
        System.out.println(imprimirLineaCentrada("** SELLO PERSONALIZADO - VERSIÓN CORTA **"));
        System.out.println(imprimirLineaCentrada(SELLO_CORTO));

        // Borde inferior
        System.out.println("╚" + lineaHorizontalInterna + "╝");
    }
}