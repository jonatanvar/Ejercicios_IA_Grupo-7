package Ejercicio118_KevinLainez;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 118 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase de utilidades para formato, menús, entrada/salida y presentación de resultados.
 */
public class utilidades {

    // Constantes de estilo
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';
    private static final int ANCHO_TABLA = 100; // Ancho extendido para la tabla de pacientes
    private static final char BARRA_GRAFICA = '█';

    public static String centrarTexto(String texto) {
        int espaciosTotales = ANCHO - 2 - texto.length();
        int espaciosIzquierda = espaciosTotales / 2;
        int espaciosDerecha = espaciosTotales - espaciosIzquierda;

        if (espaciosTotales < 0) {
            return String.valueOf(BORDE_IZQ) + " " + texto.substring(0, ANCHO - 4) + " " + String.valueOf(BORDE_DER);
        }
        return String.valueOf(BORDE_IZQ) + " ".repeat(espaciosIzquierda) + texto + " ".repeat(espaciosDerecha) + String.valueOf(BORDE_DER);
    }

    public static String dibujarLineaHorizontal(char inicio, char fin) {
        return String.valueOf(inicio) + String.valueOf(LINEA_H).repeat(ANCHO - 2) + String.valueOf(fin);
    }

    public static void mostrarSelloCorto() {
        String sello = "Kevin Lainez | klainezs@unah.hn | 118 | 2025-11-03";
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    // --- MENÚ PRINCIPAL ---

    public static int mostrarMenuPrincipal(Scanner sc) {
        int opcion = -1;

        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("--- SISTEMA DE CLÍNICA NUTRICIONAL ---"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto("1. Agregar Paciente"));
        System.out.println(centrarTexto("2. Ver Pacientes (Tabla Ordenada)"));
        System.out.println(centrarTexto("3. Modificar Paciente"));
        System.out.println(centrarTexto("4. Estadísticas y Gráficas"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto("0. Salir"));
        System.out.println(dibujarLineaHorizontal('└', '┘'));

        try {
            System.out.print(">> Ingrese su opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            sc.nextLine();
            opcion = -1;
        }
        return opcion;
    }

    // --- ENTRADA DE DATOS ---

    public static String solicitarString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    public static int solicitarExpediente(Scanner sc, Paciente[] pacientes, boolean debeExistir) {
        int exp = 0;
        do {
            try {
                System.out.print(">> Ingrese Expediente (1-99): ");
                exp = sc.nextInt();
                sc.nextLine();

                if (exp < 1 || exp > 99) {
                    System.out.println("ERROR: El expediente debe ser entre 1 y 99.");
                } else {
                    int indice = operaciones.buscarPacientePorExpediente(pacientes, exp);
                    if (debeExistir && indice == -1) {
                        System.out.println("ERROR: Expediente " + exp + " no encontrado.");
                        exp = 0;
                    } else if (!debeExistir && indice != -1) {
                        System.out.println("ERROR: Expediente " + exp + " ya existe. Debe ser único.");
                        exp = 0;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Entrada inválida. Ingrese un número entero.");
                sc.nextLine();
                exp = 0;
            }
        } while (exp < 1 || exp > 99);
        return exp;
    }

    public static double solicitarDouble(Scanner sc, String prompt, double min) {
        double val = min - 1;
        do {
            try {
                System.out.print(prompt);
                val = sc.nextDouble();
                sc.nextLine();
                if (val < min) {
                    System.out.println("ERROR: El valor debe ser mayor o igual a " + min + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Entrada inválida. Ingrese un número.");
                sc.nextLine();
                val = min - 1;
            }
        } while (val < min);
        return val;
    }

    public static char solicitarSexo(Scanner sc) {
        String s = "";
        do {
            System.out.print(">> Ingrese Sexo (H/M): ");
            s = sc.nextLine().trim().toUpperCase();
        } while (!s.equals("H") && !s.equals("M"));
        return s.charAt(0);
    }

    // --- SALIDA DE DATOS Y TABLA ---

    /**
     * Muestra la tabla de pacientes ordenada.
     */
    public static void mostrarTablaPacientes(Paciente[] pacientesOrdenados) {

        System.out.println("\n" + "-".repeat(ANCHO_TABLA));
        System.out.printf("| %-10s | %-15s | %-15s | %-4s | %-10s | %-13s | %-8s | %-6s | %-18s |\n",
                "EXP", "NOMBRE", "APELLIDO", "SEXO", "CELULAR", "PESO (Lb/Kg)", "ESTATURA", "IMC", "DIAGNÓSTICO");
        System.out.println("-".repeat(ANCHO_TABLA));

        for (Paciente p : pacientesOrdenados) {
            if (p != null) {
                String pesoStr = String.format("%.0f / %.2f", p.pesoLb, p.getPesoKg()); // Lb/Kg

                System.out.printf("| %-10d | %-15s | %-15s | %-4c | %-10s | %-13s | %-8.0f | %-6.2f | %-18s |\n",
                        p.expediente, p.nombre, p.apellido, p.sexo, p.celular,
                        pesoStr, p.estaturaCm, p.imc, p.diagnostico);
            }
        }
        System.out.println("-".repeat(ANCHO_TABLA));
    }

    // --- ESTADÍSTICAS Y GRÁFICAS ---

    /**
     * Dibuja una gráfica horizontal simple.
     * @param etiqueta Etiqueta de la barra (ej: Hombres).
     * @param valor El valor a graficar.
     * @param total El valor total (para calcular el porcentaje).
     * @param escala Factor de escalado de la barra.
     */
    private static void dibujarBarra(String etiqueta, int valor, int total, int escala) {
        double porcentaje = (total > 0) ? ((double) valor / total) * 100 : 0;
        int numBarras = valor * escala;

        System.out.printf("  %-15s | %s %-4d (%5.2f%%)\n",
                etiqueta, String.valueOf(BARRA_GRAFICA).repeat(numBarras), valor, porcentaje);
    }

    /**
     * Gráfica por sexo.
     */
    public static void mostrarEstadisticasSexo(int[] conteoSexo) {
        int total = conteoSexo[0] + conteoSexo[1];
        int escala = (total > 0) ? (30 / total) + 1 : 1; // Escala máxima de 30 barras

        System.out.println("\n" + dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("--- ESTADÍSTICAS POR SEXO ---"));
        System.out.println(centrarTexto(String.format("Total de Pacientes: %d", total)));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        dibujarBarra("Hombres", conteoSexo[0], total, escala);
        dibujarBarra("Mujeres", conteoSexo[1], total, escala);

        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Gráfica por diagnóstico.
     * @param conteoDiagnostico Arreglo de strings con formato "Dx:Conteo".
     */
    public static void mostrarEstadisticasDiagnostico(String[] conteoDiagnostico, int total) {
        int escala = (total > 0) ? (30 / total) + 1 : 1;

        System.out.println("\n" + dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("--- ESTADÍSTICAS POR DIAGNÓSTICO ---"));
        System.out.println(centrarTexto(String.format("Total de Pacientes: %d", total)));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        // Iterar sobre el arreglo de strings
        for (String item : conteoDiagnostico) {
            String[] partes = item.split(":");
            String dx = partes[0];
            int valor = Integer.parseInt(partes[1]);

            dibujarBarra(dx, valor, total, escala);
        }

        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }


}