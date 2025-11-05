/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 078 | 2025-10-28
* ---------------------------------------------------------
*
* PROMPT USADO: Modificación del programa "Simple venta" para implementar una librería propia (GestorVenta) que maneje la lógica compleja de descuentos e impuestos.
 */

package Ejercicio_078;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Módulo Operaciones: Se encarga de la interacción con el usuario (pedir
 * la cantidad, el precio y si es de tercera edad) y de orquestar la llamada
 * a la "librería" GestorVenta.java para realizar los cálculos.
 */
public class Operaciones {

    private final String idioma;

    /**
     * Constructor para inicializar la clase con el idioma actual.
     * @param idioma La clave del idioma ("ES" o "EN").
     */
    public Operaciones(String idioma) {
        this.idioma = idioma;
    }

    /**
     * Simula el proceso de venta: pide datos al usuario, llama al gestor
     * de venta para los cálculos y muestra el resultado.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    public void simularVenta(Scanner scanner) {
        
        System.out.println("\n--- " + Utilidades.getTexto(idioma, "TITULO_OPERACIONES") + " ---");

        // 1. Lectura de Datos de la Venta
        double cantidad = leerDatoNumerico(scanner, Utilidades.getTexto(idioma, "PROMPT_CANTIDAD"), true);
        double precioUnitario = leerDatoNumerico(scanner, Utilidades.getTexto(idioma, "PROMPT_PRECIO_UNITARIO"), true);
        boolean esTerceraEdad = leerTerceraEdad(scanner);

        if (cantidad <= 0 || precioUnitario <= 0) {
            System.out.println(Utilidades.getTexto(idioma, "MSG_VENTA_INVALIDA"));
            return;
        }

        // 2. Ejecutar Lógica de Negocio (Librería Propia: GestorVenta)
        // Usamos una instancia del gestor de venta para acceder a la lógica modularizada
        GestorVenta gestorVenta = new GestorVenta();
        
        // El método retorna un mapa con todos los resultados
        Map<String, Double> resultados = gestorVenta.calcularVenta(cantidad, precioUnitario, esTerceraEdad);

        // 3. Mostrar Resultados
        mostrarResultados(resultados, esTerceraEdad);
    }

    /**
     * Muestra la tabla de resultados de la venta.
     * @param resultados Mapa que contiene todos los valores calculados.
     * @param esTerceraEdad true si aplica el descuento de tercera edad.
     */
    private void mostrarResultados(Map<String, Double> resultados, boolean esTerceraEdad) {
        
        // Obtener valores del mapa
        double totalBruto = resultados.getOrDefault("totalBruto", 0.0);
        double descuentoMonto = resultados.getOrDefault("descuentoMonto", 0.0);
        double descuentoPorcentaje = resultados.getOrDefault("descuentoPorcentaje", 0.0);
        double impuestoMonto = resultados.getOrDefault("impuestoMonto", 0.0);
        double impuestoPorcentaje = resultados.getOrDefault("impuestoPorcentaje", 0.0);
        double totalNeto = resultados.getOrDefault("totalNeto", 0.0);

        // Imprimir tabla de resultados
        System.out.println("\n" + Utilidades.getTexto(idioma, "TITULO_RESULTADOS"));
        System.out.println("----------------------------------------");
        
        System.out.printf(Utilidades.getTexto(idioma, "FORMATO_RESULTADO"), 
            Utilidades.getTexto(idioma, "RES_TERCERA_EDAD"), 
            (esTerceraEdad ? Utilidades.getTexto(idioma, "RES_SI") : Utilidades.getTexto(idioma, "RES_NO"))
        );
        
        System.out.printf(Utilidades.getTexto(idioma, "FORMATO_RESULTADO_MONTO"), 
            Utilidades.getTexto(idioma, "RES_SUBTOTAL"), totalBruto
        );
        
        System.out.printf(Utilidades.getTexto(idioma, "FORMATO_RESULTADO_MONTO_PORCENTAJE"), 
            Utilidades.getTexto(idioma, "RES_DESCUENTO"), descuentoMonto, descuentoPorcentaje
        );
        
        System.out.printf(Utilidades.getTexto(idioma, "FORMATO_RESULTADO_MONTO_PORCENTAJE"), 
            Utilidades.getTexto(idioma, "RES_IMPUESTO"), impuestoMonto, impuestoPorcentaje
        );

        System.out.println("----------------------------------------");
        System.out.printf(Utilidades.getTexto(idioma, "FORMATO_RESULTADO_MONTO_FINAL"), 
            Utilidades.getTexto(idioma, "RES_TOTAL_NETO"), totalNeto
        );
        System.out.println("----------------------------------------");
    }

    // --- FUNCIONES AUXILIARES DE LECTURA ---
    
    /**
     * Lee y valida un valor de tipo numérico (double) para cantidad y precio.
     * @param scanner El objeto Scanner.
     * @param prompt El mensaje a mostrar al usuario.
     * @param debeSerPositivo Si el valor debe ser estrictamente mayor a cero.
     * @return El valor leído, o 0 si la entrada es inválida.
     */
    private double leerDatoNumerico(Scanner scanner, String prompt, boolean debeSerPositivo) {
        double valor = 0.0;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            System.out.print(prompt);
            try {
                if (scanner.hasNextDouble()) {
                    valor = scanner.nextDouble();
                    scanner.nextLine(); 
                    
                    if (!debeSerPositivo || valor > 0) {
                        entradaValida = true;
                    } else {
                        System.out.println(Utilidades.getTexto(idioma, "ERR_VALOR_CERO"));
                    }
                } else {
                    System.out.println(Utilidades.getTexto(idioma, "ERR_ENTRADA_INVALIDA_NUM"));
                    scanner.nextLine(); 
                }
            } catch (InputMismatchException e) {
                // Ya manejado por el else
            }
        }
        return valor;
    }

    /**
     * Pregunta si el cliente es de la tercera edad.
     * @param scanner El objeto Scanner.
     * @return true si es de la tercera edad, false en caso contrario.
     */
    private boolean leerTerceraEdad(Scanner scanner) {
        int opcion = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println("\n" + Utilidades.getTexto(idioma, "PROMPT_TERCERA_EDAD"));
            System.out.println(Utilidades.getTexto(idioma, "OPCION_SI"));
            System.out.println(Utilidades.getTexto(idioma, "OPCION_NO"));
            System.out.print(Utilidades.getTexto(idioma, "PROMPT_OPCION_NUM"));
            
            try {
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (opcion == 1 || opcion == 2) {
                        entradaValida = true;
                    } else {
                        System.out.println(Utilidades.getTexto(idioma, "ERR_OPCION_INVALIDA_TERCERA"));
                    }
                } else {
                    System.out.println(Utilidades.getTexto(idioma, "ERR_ENTRADA_INVALIDA_NUM"));
                    scanner.nextLine();
                }
            } catch (InputMismatchException e) {
                // Ya manejado por el else
            }
        }
        return opcion == 1; // 1 = Sí, es tercera edad
    }
}
