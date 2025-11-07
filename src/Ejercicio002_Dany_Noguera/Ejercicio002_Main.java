// ╔════════════════════════════════════════════════════════════════════════════╗
// ║                          Metadatos del Desarrollador                       ║
// ║ Nombre: Dany Noguera                                                       ║
// ║ Apodo: (opcional)                                                          ║
// ║ Correo Electrónico: dany.noguera@unah.hn                                  ║
// ║ Fecha: 2025-11-04                                                         ║
// ║                                                                            ║
// ║                          Identificación del Código                        ║
// ║ Código del Ejercicio: 002                                                  ║
// ║ Enunciado: Mostrando el sello: El programa anterior no posee salida       ║
// ║ visible al usuario es por ello que ahora vamos a tomar como base el       ║
// ║ programa “defina un sello personalizado para el código” y vamos a mostrar ║
// ║ al usuario dicho sello.                                                    ║
// ║                                                                            ║
// ║                          Análisis/Resumen                                  ║
// ║ Programa que imprime en consola el sello personalizado completo (versión   ║
// ║ larga) con bordes Unicode, texto centrado y separadores decorativos.      ║
// ║ Reutiliza las utilidades del ejercicio 001 para mantener consistencia.    ║
// ║                                                                            ║
// ║                          PROMPT USADO                                      ║
// ║ agente ahora el ejercicio#2 con el siguiente enunciado:                    ║
// ║ Mostrando el sello: El programa anterior no posee salida visible al       ║
// ║ usuario es por ello que ahora vamos a tomar como base el programa         ║
// ║ “defina un sello personalizado para el código” y vamos a mostrar al       ║
// ║ usuario dicho sello.                                                       ║
// ║ muestra un sello elegante como habíamos hecho en el #1, te cuerdo que     ║
// ║ tu ya tienes mis datos para ponerlo en el sello, y a ahora muestra el     ║
// ║ prompt solo en el archivo .Main                                            ║
// ╚════════════════════════════════════════════════════════════════════════════╝

package Ejercicio002_Dany_Noguera;

public class Ejercicio002_Main {
    private static final int ANCHO = 78;
    private static final char LINEA = '═';

    public static void main(String[] args) {
        imprimirEncabezado();
        imprimirSelloCompleto();
        imprimirVersionCorta();
        imprimirPie();
    }

    private static void imprimirEncabezado() {
        System.out.println("╔" + String.valueOf(LINEA).repeat(ANCHO - 2) + "╗");
        Ejercicio002_Utilidades.centrarTexto("EJERCICIO 002 - MOSTRANDO EL SELLO", ANCHO);
        Ejercicio002_Utilidades.centrarTexto("¡Tu sello personalizado ahora es visible!", ANCHO);
        System.out.println("╚" + String.valueOf(LINEA).repeat(ANCHO - 2) + "╝\n");
    }

    private static void imprimirSelloCompleto() {
        Ejercicio002_Utilidades.mostrarSeparador("METADATOS DEL DESARROLLADOR", ANCHO);
        Ejercicio002_Utilidades.centrarTexto("Nombre: Dany Noguera", ANCHO);
        Ejercicio002_Utilidades.centrarTexto("Correo: dany.noguera@unah.hn", ANCHO);
        Ejercicio002_Utilidades.centrarTexto("Fecha: 2025-11-04", ANCHO);

        Ejercicio002_Utilidades.mostrarSeparador("IDENTIFICACIÓN DEL CÓDIGO", ANCHO);
        Ejercicio002_Utilidades.centrarTexto("Ejercicio: 002", ANCHO);
        Ejercicio002_Utilidades.centrarTexto("Mostrando el sello al usuario", ANCHO);

        Ejercicio002_Utilidades.mostrarSeparador("ENUNCIADO COMPLETO", ANCHO);
        Ejercicio002_Utilidades.centrarTexto("El programa anterior no poseía salida visible al usuario.", ANCHO);
        Ejercicio002_Utilidades.centrarTexto("Ahora mostramos el sello elegante en pantalla.", ANCHO);
    }

    private static void imprimirVersionCorta() {
        System.out.println("\n╠" + String.valueOf(LINEA).repeat(ANCHO - 2) + "╣");
        Ejercicio002_Utilidades.centrarTexto("VERSIÓN CORTA (para módulos)", ANCHO);
        Ejercicio002_Utilidades.centrarTexto("Dany Noguera | dany.noguera@unah.hn | 002 | 2025-11-04", ANCHO);
        System.out.println("╚" + String.valueOf(LINEA).repeat(ANCHO - 2) + "╝");
    }

    private static void imprimirPie() {
        System.out.println("\n╔" + String.valueOf(LINEA).repeat(ANCHO - 2) + "╗");
        Ejercicio002_Utilidades.centrarTexto("¡SELLO MOSTRADO CON ÉXITO!", ANCHO);
        System.out.println("╚" + String.valueOf(LINEA).repeat(ANCHO - 2) + "╝");
    }
}