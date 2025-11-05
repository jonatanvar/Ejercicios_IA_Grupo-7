/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 078 | 2025-10-28
* ---------------------------------------------------------
*
* PROMPT USADO: Implementar una librería propia (GestorVenta) para encapsular la lógica de cálculo de descuentos e impuestos del problema "Simple venta".
 */

package Ejercicio_078;

import java.util.HashMap;
import java.util.Map;

/**
 * Módulo GestorVenta (Librería Propia): Contiene toda la lógica de cálculo
 * de precios, descuentos e impuestos, según las reglas del ejercicio.
 */
public class GestorVenta {

    /**
     * Realiza el cálculo completo de la venta, aplicando descuentos e impuestos.
     * @param cantidad La cantidad de artículos vendidos.
     * @param precioUnitario El precio por unidad.
     * @param esTerceraEdad Indica si el cliente es de la tercera edad.
     * @return Un Map<String, Double> con todos los resultados de los cálculos.
     */
    public Map<String, Double> calcularVenta(double cantidad, double precioUnitario, boolean esTerceraEdad) {
        
        // 1. Calcular Total Bruto (Subtotal)
        double totalBruto = cantidad * precioUnitario;
        
        // 2. Determinar Porcentaje de Descuento
        double descuentoPorcentaje = calcularPorcentajeDescuento(totalBruto, esTerceraEdad);
        double descuentoMonto = totalBruto * (descuentoPorcentaje / 100.0);
        
        // 3. Determinar Porcentaje e Monto del Impuesto (IVA)
        double porcentajeImpuesto = calcularPorcentajeImpuesto(descuentoPorcentaje);
        double baseGravable = totalBruto - descuentoMonto;
        double impuestoMonto = baseGravable * (porcentajeImpuesto / 100.0);
        
        // 4. Calcular Total Neto
        double totalNeto = baseGravable + impuestoMonto;

        // Redondear todos los valores a dos decimales
        totalBruto = redondear(totalBruto);
        descuentoMonto = redondear(descuentoMonto);
        impuestoMonto = redondear(impuestoMonto);
        totalNeto = redondear(totalNeto);
        
        // 5. Devolver resultados en un Map
        Map<String, Double> resultados = new HashMap<>();
        resultados.put("totalBruto", totalBruto);
        resultados.put("descuentoPorcentaje", descuentoPorcentaje);
        resultados.put("descuentoMonto", descuentoMonto);
        resultados.put("impuestoPorcentaje", porcentajeImpuesto);
        resultados.put("impuestoMonto", impuestoMonto);
        resultados.put("totalNeto", totalNeto);
        
        return resultados;
    }

    /**
     * Determina el porcentaje de descuento a aplicar basado en la edad y el total bruto.
     * Reglas de Descuento (del enunciado):
     * a. Si es 3ra edad: 30%
     * b. Si NO es 3ra edad: 
     * i. 0 a 100: 10%
     * ii. 100 a 300: 15%
     * iii. 300 a 500: 20%
     * iv. > 500: 25%
     * @param totalBruto El subtotal de la venta.
     * @param esTerceraEdad Si el cliente es de la tercera edad.
     * @return El porcentaje de descuento (ej: 30.0, 10.0, etc.).
     */
    private double calcularPorcentajeDescuento(double totalBruto, boolean esTerceraEdad) {
        
        if (esTerceraEdad) {
            return 30.0; // 30% de descuento fijo
        } else {
            // Cliente NO es de la tercera edad
            if (totalBruto <= 100.0) {
                return 10.0;
            } else if (totalBruto <= 300.0) { // Mayor a 100.0 y menor o igual a 300.0
                return 15.0;
            } else if (totalBruto <= 500.0) { // Mayor a 300.0 y menor o igual a 500.0
                return 20.0;
            } else { // Mayor a 500.0
                return 25.0;
            }
        }
    }

    /**
     * Determina el porcentaje de impuesto a aplicar basado en el descuento ya calculado.
     * Reglas de Impuesto (del enunciado):
     * c. Si el descuento es <= 15%: 12% de Impuesto.
     * c. Si el descuento es > 15%: 15% de Impuesto.
     * @param porcentajeDescuento El porcentaje de descuento aplicado.
     * @return El porcentaje de impuesto (12.0 o 15.0).
     */
    private double calcularPorcentajeImpuesto(double porcentajeDescuento) {
        
        if (porcentajeDescuento <= 15.0) {
            return 12.0;
        } else {
            return 15.0;
        }
    }
    
    /**
     * Función auxiliar para redondear valores Double a dos decimales.
     * @param valor El valor a redondear.
     * @return El valor redondeado.
     */
    private double redondear(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
}
