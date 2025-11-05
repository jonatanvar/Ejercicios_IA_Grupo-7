/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 020 | 2025-10-22
* ---------------------------------------------------------
*
* PROMPT USADO:  Programa que calcula y muestra los ingresos semanales de múltiples vendedores (salario base + 9% de comisión), usando un ciclo while y dos niveles de menú (idioma y control).
 */

package Ejercicio_020;

import java.util.Scanner;

/**
 * Módulo Operaciones: Implementa la lógica principal del negocio, que es el cálculo
 * de los ingresos de los vendedores utilizando un ciclo while para procesar
 * múltiples entradas.
 */
public class Operaciones {

    // Constantes del problema
    private static final double SUELDO_BASE = 200.00;
    private static final double TASA_COMISION = 0.09;

    private final String idioma; // Almacena el idioma seleccionado

    /**
     * Constructor para inicializar la clase con el idioma actual.
     * @param idioma La clave del idioma ("ES" o "EN").
     */
    public Operaciones(String idioma) {
        this.idioma = idioma;
    }

    /**
     * Ejecuta el ciclo de procesamiento de vendedores (usando while) para calcular
     * y mostrar sus ingresos.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    public void procesarVendedores(Scanner scanner) {
        double ventasBrutas;
        
        // Muestra el encabezado del módulo de cálculo
        System.out.println("\n--- " + Utilidades.getTexto(idioma, "TITULO_OPERACIONES") + " ---");
        System.out.println(Utilidades.getTexto(idioma, "MSG_INGRESO_VENTAS"));
        
        // Ciclo while para procesar las ventas de múltiples vendedores
        // El ciclo termina cuando el usuario ingresa un valor de 0 o negativo (centinela)
        while (true) {
            
            System.out.print(Utilidades.getTexto(idioma, "PROMPT_VENTAS"));
            
            // Verifica si el siguiente token es un double
            if (scanner.hasNextDouble()) {
                ventasBrutas = scanner.nextDouble();
            } else {
                // Maneja la entrada no numérica
                System.out.println(Utilidades.getTexto(idioma, "ERR_ENTRADA_INVALIDA"));
                scanner.next(); // Limpia la entrada inválida
                continue; // Vuelve al inicio del ciclo
            }
            
            // Condición de terminación del ciclo (Centinela)
            if (ventasBrutas <= 0.0) {
                System.out.println(Utilidades.getTexto(idioma, "MSG_FIN_PROCESAMIENTO"));
                break; // Sale del ciclo while
            }

            // 1. Calcular Ingresos
            double ingresoTotal = calcularIngresos(ventasBrutas);
            
            // 2. Mostrar el resultado
            mostrarResultado(ventasBrutas, ingresoTotal);
        }
    }

    /**
     * Calcula el ingreso total de un vendedor para la semana.
     * Fórmula: Ingreso = Sueldo Base + (Ventas Brutas * 0.09)
     * @param ventasBrutas El total de ventas realizadas por el vendedor.
     * @return El ingreso total del vendedor.
     */
    private double calcularIngresos(double ventasBrutas) {
        double comision = ventasBrutas * TASA_COMISION;
        return SUELDO_BASE + comision;
    }

    /**
     * Muestra el ingreso total del vendedor en la consola con formato de moneda.
     * @param ventas Las ventas brutas utilizadas en el cálculo.
     * @param ingreso El ingreso total calculado.
     */
    private void mostrarResultado(double ventas, double ingreso) {
        
        System.out.printf(Utilidades.getTexto(idioma, "MSG_RESULTADO"), ventas, ingreso);
        System.out.println(); // Salto de línea para separar vendedores
    }
}
