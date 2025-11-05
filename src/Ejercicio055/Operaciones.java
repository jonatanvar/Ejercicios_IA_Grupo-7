/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 055 | 2025-10-27
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que simula un juego de dados (apuesta sobre la suma de dos dados) con crédito inicial de L. 1000.00, funciones obligatorias (lanzar, sumar, dibujar, ganancia), control de crédito y opción de retiro tras 5 turnos.
 */

package Ejercicio_055;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Módulo Operaciones: Implementa la lógica del juego de dados, incluyendo las
 * funciones obligatorias para lanzar, sumar, dibujar y calcular la ganancia.
 */
public class Operaciones {

    private final String idioma; // Almacena el idioma seleccionado
    private static final double CREDITO_INICIAL = 1000.00;
    private static final int MIN_RONDAS_RETIRO = 5;
    
    // Objeto Random para la simulación del dado
    private final Random random = new Random();

    /**
     * Constructor para inicializar la clase con el idioma actual.
     * @param idioma La clave del idioma ("ES" o "EN").
     */
    public Operaciones(String idioma) {
        this.idioma = idioma;
    }

    /**
     * Inicia y controla el ciclo principal del juego de dados.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    public void iniciarJuego(Scanner scanner) {
        double creditoActual = CREDITO_INICIAL;
        int rondasJugadas = 0;
        boolean continuarJugando = true;
        Menus menus = new Menus();

        System.out.println("\n--- " + Utilidades.getTexto(idioma, "TITULO_OPERACIONES") + " ---");
        System.out.printf(Utilidades.getTexto(idioma, "MSG_BIENVENIDA"), CREDITO_INICIAL);
        System.out.println(Utilidades.getTexto(idioma, "MSG_REGLAS"));

        // Ciclo principal del juego
        while (creditoActual > 0 && continuarJugando) {
            rondasJugadas++;
            System.out.println("\n" + Utilidades.getTexto(idioma, "MSG_RONDA") + " " + rondasJugadas);
            System.out.printf(Utilidades.getTexto(idioma, "MSG_CREDITO_ACTUAL"), creditoActual);

            // 1. Pedir apuesta
            double apuesta = pedirApuesta(scanner, creditoActual);
            if (apuesta <= 0) {
                // Si la apuesta es 0 o inválida, se detiene el juego para prevenir ciclo infinito
                System.out.println(Utilidades.getTexto(idioma, "MSG_APUESTA_CANCELADA"));
                break;
            }

            // 2. Pedir predicción
            int prediccion = pedirPrediccion(scanner);
            if (prediccion == -1) {
                System.out.println(Utilidades.getTexto(idioma, "MSG_PREDICCION_CANCELADA"));
                break;
            }

            // 3. Lanzar dados (Función obligatoria)
            int dado1 = lanzarDado();
            int dado2 = lanzarDado();
            int suma = sumarDados(dado1, dado2); // Función obligatoria

            // 4. Mostrar dados (Función obligatoria)
            System.out.println(Utilidades.getTexto(idioma, "MSG_TIRADA_RESULTADO"));
            dibujarDados(dado1, dado2, suma);

            // 5. Determinar resultado y actualizar crédito
            boolean gano = (suma == prediccion);
            double ganancia = calcularGanancia(apuesta, gano); // Función obligatoria

            if (gano) {
                creditoActual += ganancia;
                System.out.printf(Utilidades.getTexto(idioma, "MSG_GANADOR"), prediccion, suma, ganancia);
            } else {
                creditoActual -= apuesta;
                System.out.printf(Utilidades.getTexto(idioma, "MSG_PERDEDOR"), prediccion, suma);
            }
            
            // 6. Revisar condiciones de salida
            if (creditoActual <= 0) {
                System.out.println(Utilidades.getTexto(idioma, "MSG_SIN_DINERO"));
                break;
            }
            
            if (rondasJugadas >= MIN_RONDAS_RETIRO) {
                continuarJugando = menus.preguntarRetiro(scanner, idioma);
                if (!continuarJugando) {
                    System.out.printf(Utilidades.getTexto(idioma, "MSG_RETIRO_VOLUNTARIO"), creditoActual);
                    break;
                }
            }
        }
        
        System.out.println("\n--- " + Utilidades.getTexto(idioma, "MSG_FIN_JUEGO") + " ---");
        System.out.printf(Utilidades.getTexto(idioma, "MSG_CREDITO_FINAL"), creditoActual);
    }
    
    // --- FUNCIONES OBLIGATORIAS ---
    
    /**
     * Simula el lanzamiento de un dado de 6 caras.
     * @return Un entero aleatorio entre 1 y 6.
     */
    private int lanzarDado() {
        // nextInt(6) genera 0 a 5. Sumando 1 se obtiene 1 a 6.
        return random.nextInt(6) + 1;
    }

    /**
     * Suma los valores de las caras superiores de dos dados.
     * @param dado1 Valor del primer dado (1-6).
     * @param dado2 Valor del segundo dado (1-6).
     * @return La suma de los dos valores (2-12).
     */
    private int sumarDados(int dado1, int dado2) {
        return dado1 + dado2;
    }

    /**
     * Dibuja los dos dados uno al lado del otro usando caracteres ASCII.
     * @param d1 Valor del primer dado.
     * @param d2 Valor del segundo dado.
     */
    private void dibujarDados(int d1, int d2, int suma) {
        // La matriz representa las posiciones de los puntos en el dado 3x3 (centro, esquinas)
        String[][] puntos = {
            {"", "", ""}, // 0: No se usa
            {"", " ", ""}, // 1: Solo centro
            {"*", " ", " *"}, // 2: Esquinas opuestas (superior izquierda, inferior derecha)
            {"*", "*", " *"}, // 3: Esquinas y centro
            {"*", "*", "*"}, // 4: Las cuatro esquinas
            {"*", "*", "*"}, // 5: Las cuatro esquinas y centro
            {"*", "*", "*"}  // 6: Seis lados
        };
        
        // El formato de cada punto: (sup-izq, centro-centro, inf-der)
        String[] formatoPuntos = new String[7];
        formatoPuntos[1] = puntos[1][1]; // 1:  
        formatoPuntos[2] = puntos[2][0] + " " + puntos[2][2]; // 2: * *
        formatoPuntos[3] = puntos[3][0] + " " + puntos[3][1] + " " + puntos[3][2]; // 3: * * *
        
        // Definición de puntos para las 5 filas del dibujo del dado (3x3 en el centro)
        // [i][j] donde i=dado, j=fila del dibujo (1 a 5)
        String[][] dibujo = new String[7][5];
        
        // Dado 1
        dibujo[1][0] = "|       |"; // 1. Fila 1 (arriba)
        dibujo[1][1] = "|   * |"; // 2. Fila 2 (centro)
        dibujo[1][2] = "|       |"; // 3. Fila 3 (abajo)
        
        // Dado 2
        dibujo[2][0] = "| * |"; // 1. Fila 1
        dibujo[2][1] = "|       |"; // 2. Fila 2
        dibujo[2][2] = "|     * |"; // 3. Fila 3
        
        // Dado 3
        dibujo[3][0] = "| * |"; 
        dibujo[3][1] = "|   * |"; 
        dibujo[3][2] = "|     * |"; 
        
        // Dado 4
        dibujo[4][0] = "| * * |"; 
        dibujo[4][1] = "|       |"; 
        dibujo[4][2] = "| * * |"; 
        
        // Dado 5
        dibujo[5][0] = "| * * |"; 
        dibujo[5][1] = "|   * |"; 
        dibujo[5][2] = "| * * |"; 
        
        // Dado 6
        dibujo[6][0] = "| * * * |"; 
        dibujo[6][1] = "|       |"; 
        dibujo[6][2] = "| * * * |"; 

        // Dado 1: Relleno de las filas
        // Filas que no tienen puntos (2 y 4)
        dibujo[1][3] = dibujo[1][1]; // Fila 4 igual a fila 2
        dibujo[2][3] = dibujo[2][1];
        dibujo[3][3] = dibujo[3][1];
        dibujo[4][3] = dibujo[4][1];
        dibujo[5][3] = dibujo[5][1];
        dibujo[6][3] = dibujo[6][1];

        // Se usa un formato estándar de dado 5x5
        String lineaHorizontal = "+-------+";
        
        // Imprimir los dos dados lado a lado (5 filas)
        System.out.println(lineaHorizontal + " " + lineaHorizontal);
        
        // Fila 1: Superior Izquierda
        System.out.println("| " + obtenerPuntos(d1, 1) + " | " + "| " + obtenerPuntos(d2, 1) + " |");
        
        // Fila 2: Centro Izquierda
        System.out.println("| " + obtenerPuntos(d1, 2) + " | " + "| " + obtenerPuntos(d2, 2) + " |");
        
        // Fila 3: Centro (punto central)
        System.out.println("| " + obtenerPuntos(d1, 3) + " | " + "| " + obtenerPuntos(d2, 3) + " |");
        
        // Fila 4: Centro Derecha
        System.out.println("| " + obtenerPuntos(d1, 4) + " | " + "| " + obtenerPuntos(d2, 4) + " |");
        
        // Fila 5: Inferior Derecha
        System.out.println("| " + obtenerPuntos(d1, 5) + " | " + "| " + obtenerPuntos(d2, 5) + " |");
        
        System.out.println(lineaHorizontal + " " + lineaHorizontal);
        System.out.printf(Utilidades.getTexto(idioma, "MSG_DADOS_VALOR"), d1, d2, suma);
    }
    
    /**
     * Determina qué caracteres de punto deben ir en una fila específica del dado.
     * @param valor El valor del dado (1 a 6).
     * @param fila La fila del dibujo (1 a 5).
     * @return Cadena de 5 caracteres que representan los puntos o espacios.
     */
    private String obtenerPuntos(int valor, int fila) {
        String p = "*";
        String s = " ";
        // Patrones simplificados (5x5)
        switch (valor) {
            case 1:
                if (fila == 3) return s + s + p + s + s;
                return s + s + s + s + s;
            case 2:
                if (fila == 1 || fila == 5) return s + p + s + p + s;
                return s + s + s + s + s;
            case 3:
                if (fila == 1) return s + p + s + s + s;
                if (fila == 3) return s + s + p + s + s;
                if (fila == 5) return s + s + s + p + s;
                return s + s + s + s + s;
            case 4:
                if (fila == 1 || fila == 5) return p + s + s + s + p;
                return s + s + s + s + s;
            case 5:
                if (fila == 1 || fila == 5) return p + s + s + s + p;
                if (fila == 3) return s + s + p + s + s;
                return s + s + s + s + s;
            case 6:
                if (fila == 1 || fila == 3 || fila == 5) return p + s + p + s + p;
                return s + s + s + s + s;
            default:
                return s + s + s + s + s;
        }
    }

    /**
     * Calcula la ganancia basada en la apuesta.
     * Si gana: retorna Apuesta + (Apuesta / 2).
     * Si pierde: retorna 0.
     * @param apuesta El monto apostado.
     * @param gano true si el usuario ganó, false si perdió.
     * @return La cantidad de dinero a sumar al crédito (0 si perdió).
     */
    private double calcularGanancia(double apuesta, boolean gano) {
        if (gano) {
            // Regresa la apuesta más la mitad
            return apuesta + (apuesta / 2.0);
        }
        return 0;
    }
    
    // --- FUNCIONES AUXILIARES DE ENTRADA ---
    
    /**
     * Solicita al usuario la apuesta y valida que sea entre 1 y el crédito.
     * @param scanner El objeto Scanner.
     * @param creditoActual El saldo actual del usuario.
     * @return El monto apostado, o 0 si hay error.
     */
    private double pedirApuesta(Scanner scanner, double creditoActual) {
        double apuesta = 0;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            System.out.printf(Utilidades.getTexto(idioma, "PROMPT_APUESTA"), creditoActual);
            try {
                if (scanner.hasNextDouble()) {
                    apuesta = scanner.nextDouble();
                    scanner.nextLine(); 
                    
                    if (apuesta > 0 && apuesta <= creditoActual) {
                        entradaValida = true;
                    } else if (apuesta > creditoActual) {
                        System.out.printf(Utilidades.getTexto(idioma, "ERR_APUESTA_MAYOR_CREDITO"), creditoActual);
                    } else {
                        System.out.println(Utilidades.getTexto(idioma, "ERR_APUESTA_MINIMA"));
                    }
                } else {
                    System.out.println(Utilidades.getTexto(idioma, "ERR_ENTRADA_INVALIDA_DOUBLE"));
                    scanner.nextLine(); 
                }
            } catch (InputMismatchException e) {
                // Ya manejado por el else
            }
        }
        return apuesta;
    }

    /**
     * Solicita al usuario la predicción y valida que sea entre 2 y 12.
     * @param scanner El objeto Scanner.
     * @return La predicción del usuario (2-12), o -1 si hay error.
     */
    private int pedirPrediccion(Scanner scanner) {
        int prediccion = -1;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            System.out.print(Utilidades.getTexto(idioma, "PROMPT_PREDICCION"));
            try {
                if (scanner.hasNextInt()) {
                    prediccion = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    if (prediccion >= 2 && prediccion <= 12) {
                        entradaValida = true;
                    } else {
                        System.out.println(Utilidades.getTexto(idioma, "ERR_PREDICCION_RANGO"));
                    }
                } else {
                    System.out.println(Utilidades.getTexto(idioma, "ERR_ENTRADA_INVALIDA_INT"));
                    scanner.nextLine(); 
                }
            } catch (InputMismatchException e) {
                // Ya manejado por el else
            }
        }
        return prediccion;
    }
}
