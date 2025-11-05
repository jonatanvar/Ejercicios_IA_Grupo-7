package Ejercicio048_KevinLainez;

import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 048 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #48: Venta con Descuento e Impuesto Condicional
 * * PROMPT:
 * Un programa que tras la cantidad total de un artículo y su precio unitario
 * obtenga el total de esa venta y sobre éste calcule el impuesto, el descuento,
 * muestre el subtotal y el total considerando las condiciones de 3ra edad,
 * rangos de subtotal para descuento, e impuesto condicional.
 */
public class main {

    public static void main(String[] args) {
        // 1. Inicializar Scanner
        Scanner sc = new Scanner(System.in);

        // 2. Mostrar cuadro de bienvenida
        utilidades.mostrarSaludo();

        // --- ENTRADA DE DATOS ---
        System.out.println(utilidades.dibujarLineaHorizontal('┌', '┐'));
        System.out.println(utilidades.centrarTexto("INGRESO DE DATOS DE VENTA"));

        // Cantidad de artículos (tratada como double para usar solicitarValor)
        double cantDouble = utilidades.solicitarValor(sc, "Cantidad de artículos:");
        int cantidad = (int) Math.round(cantDouble); // Convertir a entero

        // Precio unitario
        double precioUnitario = utilidades.solicitarValor(sc, "Precio Unitario:");

        // Condición de 3ra edad
        boolean esTerceraEdad = utilidades.solicitarTerceraEdad(sc);

        System.out.println(utilidades.dibujarLineaHorizontal('└', '┘'));

        // --- CÁLCULOS ---

        // 1. Subtotal
        double subtotal = operaciones.calcularSubtotal(cantidad, precioUnitario);

        // 2. Porcentaje de Descuento
        double porcDescuento = operaciones.obtenerPorcentajeDescuento(subtotal, esTerceraEdad);

        // 3. Monto de Descuento
        double montoDescuento = operaciones.calcularMontoDescuento(subtotal, porcDescuento);

        // 4. Tasa de Impuesto (condicional)
        double tasaImpuesto = operaciones.obtenerTasaImpuesto(porcDescuento);

        // 5. Monto de Impuesto
        double montoImpuesto = operaciones.calcularMontoImpuesto(subtotal, montoDescuento, tasaImpuesto);

        // 6. Total Final
        double totalFinal = operaciones.calcularTotalFinal(subtotal, montoDescuento, montoImpuesto);

        // --- SALIDA DE RESULTADOS ---
        utilidades.mostrarFactura(subtotal, porcDescuento, montoDescuento, tasaImpuesto, montoImpuesto, totalFinal);

        // 7. Mostrar Sello y finalizar
        utilidades.mostrarSelloCorto();
        System.out.println("\n--- Programa finalizado con éxito ---");

        // 8. Cerrar Scanner
        sc.close();
    }
}