/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 051 | 2025-10-14               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio051;

public class Utilidades {
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    public static void mostrarSello() {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + BORDE_DER);
        System.out.println(BORDE_IZQ + centrarTexto("Jonatan Varela | jivarelag@unah.hn | 051 | 2025-10-14", ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarFigura(int figura, String idioma) {
        String dibujo = obtenerDibujo(figura, idioma);
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("FIGURA", idioma) + obtenerTexto("FIGURA_NOMBRE" + figura, idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
        String[] lineas = dibujo.split("\n");
        for (String linea : lineas) {
            System.out.println(BORDE_IZQ + centrarTexto(linea, ANCHO - 2) + BORDE_DER);
        }
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarResultados(double area, double perimetro, double volumen, String idioma, int figura) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("RESULTADOS", idioma) + obtenerTexto("FIGURA_NOMBRE" + figura, idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("AREA", idioma) + String.format("%.2f", area), ANCHO - 2) + BORDE_DER);
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("PERIMETRO", idioma) + String.format("%.2f", perimetro), ANCHO - 2) + BORDE_DER);
        if (volumen > 0) {
            System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("VOLUMEN", idioma) + String.format("%.2f", volumen), ANCHO - 2) + BORDE_DER);
        }
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarErrorEntrada(String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("ERROR_ENTRADA", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarErrorPositivo(String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("ERROR_POSITIVO", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static String[] obtenerParametrosFigura(int figura, String idioma) {
        if (idioma.equals("ES")) {
            switch (figura) {
                case 1: return new String[]{"radio (r)"};
                case 2: return new String[]{"lado (a)"};
                case 3: return new String[]{"lado base (a)", "apotema (ap)", "altura (h)"};
                case 4: return new String[]{"radio (r)", "altura (h)"};
                case 5: return new String[]{"base (b)", "altura (h)", "lado (a)"};
            }
        } else {
            switch (figura) {
                case 1: return new String[]{"radius (r)"};
                case 2: return new String[]{"side (a)"};
                case 3: return new String[]{"base side (a)", "apothem (ap)", "height (h)"};
                case 4: return new String[]{"radius (r)", "height (h)"};
                case 5: return new String[]{"base (b)", "height (h)", "side (a)"};
            }
        }
        return new String[0];
    }

    public static String obtenerDibujo(int figura, String idioma) {
        if (idioma.equals("ES")) {
            switch (figura) {
                case 1: return "    * * * * * \n  *                * \n *                    * \n  *                 * \n    * * * * *";
                case 2: return "┌─────────┐ \n│         │ \n│         │ \n└─────────┘";
                case 3: return "    /   \\ \n   /     \\ \n  /_______\\";
                case 4: return "┌─────────┐ \n│         │ \n│         │ \n└─────────┘";
                case 5: return "  ______ \n /      / \n/______/";
            }
        } else {
            switch (figura) {
                case 1: return "    * * * * * \n  *                * \n *                    * \n  *                 * \n    * * * * *";
                case 2: return "┌─────────┐ \n│         │ \n│         │ \n└─────────┘";
                case 3: return "    /   \\ \n   /     \\ \n  /_______\\";
                case 4: return "┌─────────┐ \n│         │ \n│         │ \n└─────────┘";
                case 5: return "  ______ \n /      / \n/______/";
            }
        }
        return "";
    }

    public static String obtenerTexto(String clave, String idioma) {
        if (idioma.equals("ES")) {
            switch (clave) {
                case "SELECCIONE_FIGURA": return "Seleccione una figura:";
                case "INGRESE_OPCION": return "Ingrese su opción: ";
                case "INGRESE_VALOR": return "Ingrese el valor del ";
                case "FIGURA": return "Figura: ";
                case "FIGURA_NOMBRE1": return "Esfera";
                case "FIGURA_NOMBRE2": return "Cubo";
                case "FIGURA_NOMBRE3": return "Pirámide";
                case "FIGURA_NOMBRE4": return "Cilindro";
                case "FIGURA_NOMBRE5": return "Paralelogramo";
                case "RESULTADOS": return "RESULTADOS DEL ";
                case "AREA": return "Área total: ";
                case "PERIMETRO": return "Perímetro: ";
                case "VOLUMEN": return "Volumen: ";
                case "ERROR_ENTRADA": return "ERROR: Ingrese un valor válido";
                case "ERROR_POSITIVO": return "ERROR: El valor debe ser positivo y mayor a 0";
                case "MENU_TITULO": return "MENÚ PRINCIPAL";
                case "MENU_EJECUTAR": return "1. Ejecutar programa";
                case "MENU_SALIR": return "2. Salir";
                case "SELECCIONE": return "Seleccione una opción";
                case "CONTINUAR": return "¿Desea realizar otro cálculo? (S/N)";
                case "DESPEDIDA": return "¡Hasta pronto, gracias por usar el programa!";
                default: return "";
            }
        } else {
            switch (clave) {
                case "SELECCIONE_FIGURA": return "Select a figure:";
                case "INGRESE_OPCION": return "Enter your option: ";
                case "INGRESE_VALOR": return "Enter the value of ";
                case "FIGURA": return "Figure: ";
                case "FIGURA_NOMBRE1": return "Sphere";
                case "FIGURA_NOMBRE2": return "Cube";
                case "FIGURA_NOMBRE3": return "Pyramid";
                case "FIGURA_NOMBRE4": return "Cylinder";
                case "FIGURA_NOMBRE5": return "Parallelogram";
                case "RESULTADOS": return "RESULTS OF THE ";
                case "AREA": return "Total Area: ";
                case "PERIMETRO": return "Perimeter: ";
                case "VOLUMEN": return "Volume: ";
                case "ERROR_ENTRADA": return "ERROR: Enter a valid value";
                case "ERROR_POSITIVO": return "ERROR: Value must be positive and greater than 0";
                case "MENU_TITULO": return "MAIN MENU";
                case "MENU_EJECUTAR": return "1. Run program";
                case "MENU_SALIR": return "2. Exit";
                case "SELECCIONE": return "Select an option";
                case "CONTINUAR": return "Do you want to perform another calculation? (Y/N)";
                case "DESPEDIDA": return "See you soon, thank you for using the program!";
                default: return "";
            }
        }
    }

    private static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = espaciosTotal / 2;
        int espaciosDer = espaciosTotal - espaciosIzq;
        return " ".repeat(Math.max(0, espaciosIzq)) + texto + " ".repeat(Math.max(0, espaciosDer));
    }
}