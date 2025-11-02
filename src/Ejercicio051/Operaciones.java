/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 051 | 2025-10-14               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio051;

import java.util.Scanner;

public class Operaciones {
    public static int leerYValidarFigura(Scanner scanner, String idioma) {
        int figura = 0;
        boolean valido = false;
        do {
            System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
            System.out.println("│" + centrarTexto("FIGURAS V3 - CÁLCULOS DE ÁREA Y PERÍMETRO", ANCHO - 2) + "│");
            System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
            System.out.println(Utilidades.obtenerTexto("SELECCIONE_FIGURA", idioma));
            System.out.println("1. " + Utilidades.obtenerTexto("FIGURA_NOMBRE1", idioma));
            System.out.println("2. " + Utilidades.obtenerTexto("FIGURA_NOMBRE2", idioma));
            System.out.println("3. " + Utilidades.obtenerTexto("FIGURA_NOMBRE3", idioma));
            System.out.println("4. " + Utilidades.obtenerTexto("FIGURA_NOMBRE4", idioma));
            System.out.println("5. " + Utilidades.obtenerTexto("FIGURA_NOMBRE5", idioma));
            System.out.print(Utilidades.obtenerTexto("INGRESE_OPCION", idioma));

            if (scanner.hasNextInt()) {
                figura = scanner.nextInt();
                if (figura >= 1 && figura <= 5) {
                    valido = true;
                } else {
                    Utilidades.mostrarErrorEntrada(idioma);
                }
            } else {
                scanner.next();
                Utilidades.mostrarErrorEntrada(idioma);
            }
        } while (!valido);
        return figura;
    }

    public static double[] leerDatosFigura(Scanner scanner, String idioma, int figura) {
        double[] datos = new double[4]; // Máximo 4 valores (r, a, b, h, ap)
        String[] parametros = Utilidades.obtenerParametrosFigura(figura, idioma);
        for (int i = 0; i < parametros.length; i++) {
            boolean valido = false;
            do {
                System.out.print(Utilidades.obtenerTexto("INGRESE_VALOR", idioma) + parametros[i] + ": ");
                if (scanner.hasNextDouble()) {
                    datos[i] = scanner.nextDouble();
                    if (datos[i] > 0) {
                        valido = true;
                    } else {
                        Utilidades.mostrarErrorPositivo(idioma);
                    }
                } else {
                    scanner.next();
                    Utilidades.mostrarErrorEntrada(idioma);
                }
            } while (!valido);
        }
        return datos;
    }

    public static double calcularArea(int figura, double[] datos) {
        double area = 0.0;
        final double PI = Math.PI;
        switch (figura) {
            case 1: // Esfera
                double r = datos[0];
                area = 4 * PI * r * r;
                break;
            case 2: // Cubo
                double a = datos[0];
                area = 6 * a * a;
                break;
            case 3: // Pirámide
                double a_p = datos[0];
                double ap = datos[1];
                area = a_p * a_p + 2 * a_p * ap;
                break;
            case 4: // Cilindro
                double r_c = datos[0];
                double h_c = datos[1];
                area = 2 * PI * r_c * r_c + 2 * PI * r_c * h_c;
                break;
            case 5: // Paralelogramo
                double b = datos[0];
                double h_par = datos[1];
                area = b * h_par;
                break;
        }
        return area;
    }

    public static double calcularPerimetro(int figura, double[] datos) {
        double perimetro = 0.0;
        final double PI = Math.PI;
        switch (figura) {
            case 1: // Esfera (usar circunferencia como aproximación)
                double r = datos[0];
                perimetro = 2 * PI * r;
                break;
            case 2: // Cubo
                double a = datos[0];
                perimetro = 4 * a;
                break;
            case 3: // Pirámide
                double a_p = datos[0];
                perimetro = 4 * a_p;
                break;
            case 4: // Cilindro (perímetro de base)
                double r_c = datos[0];
                perimetro = 2 * PI * r_c;
                break;
            case 5: // Paralelogramo
                double b = datos[0];
                double a_par = datos[2];
                perimetro = 2 * b + 2 * a_par;
                break;
        }
        return perimetro;
    }

    public static double calcularVolumen(int figura, double[] datos) {
        double volumen = 0.0;
        final double PI = Math.PI;
        switch (figura) {
            case 1: // Esfera
                double r = datos[0];
                volumen = (4.0 / 3) * PI * r * r * r;
                break;
            case 2: // Cubo
                double a = datos[0];
                volumen = a * a * a;
                break;
            case 3: // Pirámide
                double a_p = datos[0];
                double h = datos[2];
                volumen = (1.0 / 3) * a_p * a_p * h;
                break;
            case 4: // Cilindro
                double r_c = datos[0];
                double h_c = datos[1];
                volumen = PI * r_c * r_c * h_c;
                break;
            case 5: // Paralelogramo (no aplica volumen en 2D)
                volumen = 0.0;
                break;
        }
        return volumen;
    }

    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    private static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = espaciosTotal / 2;
        int espaciosDer = espaciosTotal - espaciosIzq;
        return " ".repeat(Math.max(0, espaciosIzq)) + texto + " ".repeat(Math.max(0, espaciosDer));
    }
}