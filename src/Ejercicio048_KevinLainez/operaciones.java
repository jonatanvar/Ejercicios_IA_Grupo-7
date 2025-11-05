package Ejercicio048_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 048 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que contiene la lógica para calcular descuentos e impuestos condicionales de una venta.
 */
public class operaciones {

    // Constante para el impuesto base
    private static final double TASA_IMPUESTO_MENOR = 0.12; // 12%
    private static final double TASA_IMPUESTO_MAYOR = 0.15; // 15%

    /**
     * Calcula el subtotal (Total sin impuesto ni descuento).
     * @param cantidad Cantidad de artículos.
     * @param precioUnitario Precio por unidad.
     * @return El subtotal de la venta.
     */
    public static double calcularSubtotal(int cantidad, double precioUnitario) {
        return cantidad * precioUnitario;
    }

    /**
     * Determina el porcentaje de descuento aplicable.
     * @param subtotal El subtotal de la venta.
     * @param esTerceraEdad True si el cliente es de la tercera edad.
     * @return El porcentaje de descuento (ej: 0.30 para 30%).
     */
    public static double obtenerPorcentajeDescuento(double subtotal, boolean esTerceraEdad) {
        if (esTerceraEdad) {
            return 0.30; // 30% fijo
        } else {
            // Descuentos condicionales por rango de subtotal
            if (subtotal >= 0 && subtotal <= 100) {
                return 0.10; // 10%
            } else if (subtotal > 100 && subtotal <= 300) {
                return 0.15; // 15%
            } else if (subtotal > 300 && subtotal <= 500) {
                return 0.20; // 20%
            } else if (subtotal > 500) {
                return 0.25; // 25%
            }
        }
        return 0.0; // Sin descuento si no cae en ningún rango o condición
    }

    /**
     * Calcula la tasa de impuesto (IVA) basada en el porcentaje de descuento aplicado.
     * Tasa de Impuesto: 12% si Descuento <= 15%, 15% si Descuento > 15%.
     * @param porcentajeDescuento El porcentaje de descuento obtenido (ej: 0.10).
     * @return La tasa de impuesto (ej: 0.12 o 0.15).
     */
    public static double obtenerTasaImpuesto(double porcentajeDescuento) {
        // La comparación se hace con 0.15 (15%)
        if (porcentajeDescuento <= TASA_IMPUESTO_MAYOR) {
            return TASA_IMPUESTO_MENOR; // 12%
        } else {
            return TASA_IMPUESTO_MAYOR; // 15%
        }
    }

    /**
     * Calcula el monto del descuento.
     * @param subtotal Subtotal de la venta.
     * @param porcentajeDescuento Porcentaje de descuento (ej: 0.30).
     * @return El monto del descuento.
     */
    public static double calcularMontoDescuento(double subtotal, double porcentajeDescuento) {
        return subtotal * porcentajeDescuento;
    }

    /**
     * Calcula el monto del impuesto sobre el subtotal después del descuento.
     * @param subtotal Subtotal de la venta.
     * @param montoDescuento Monto del descuento aplicado.
     * @param tasaImpuesto Tasa de impuesto aplicable (ej: 0.12).
     * @return El monto del impuesto a aplicar.
     */
    public static double calcularMontoImpuesto(double subtotal, double montoDescuento, double tasaImpuesto) {
        double baseImponible = subtotal - montoDescuento;
        return baseImponible * tasaImpuesto;
    }

    /**
     * Calcula el total final de la venta.
     * @param subtotal Subtotal de la venta.
     * @param montoDescuento Monto del descuento.
     * @param montoImpuesto Monto del impuesto.
     * @return El total final a pagar.
     */
    public static double calcularTotalFinal(double subtotal, double montoDescuento, double montoImpuesto) {
        return subtotal - montoDescuento + montoImpuesto;
    }
}