package Ejercicio018_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 018 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que contiene la lógica para calcular el consumo de gasolina.
 */
public class operaciones {

    // Variables de instancia para llevar los totales
    private double totalKilometros = 0.0;
    private double totalLitros = 0.0;

    /**
     * Calcula los Kilómetros por Litro (KPL) para un reabastecimiento.
     * @param kilometros Los kilómetros recorridos (entero).
     * @param litros Los litros consumidos (entero).
     * @return Los Kilómetros por Litro (KPL) como double.
     */
    public static double calcularKPLReabastecimiento(int kilometros, int litros) {
        if (litros <= 0) {
            // Manejo simple para evitar división por cero o consumo inválido
            return 0.0;
        }
        return (double) kilometros / litros;
    }

    /**
     * Agrega un nuevo reabastecimiento a los totales.
     * @param kilometros Los kilómetros del reabastecimiento actual.
     * @param litros Los litros del reabastecimiento actual.
     */
    public void agregarReabastecimiento(int kilometros, int litros) {
        this.totalKilometros += kilometros;
        this.totalLitros += litros;
    }

    /**
     * Calcula los Kilómetros por Litro (KPL) acumulados en todos los reabastecimientos.
     * @return El KPL total acumulado.
     */
    public double calcularKPLTotal() {
        if (totalLitros <= 0.0) {
            return 0.0;
        }
        return this.totalKilometros / this.totalLitros;
    }

    // Métodos Getter para acceder a los totales desde main.java
    public double getTotalKilometros() {
        return totalKilometros;
    }

    public double getTotalLitros() {
        return totalLitros;
    }
}