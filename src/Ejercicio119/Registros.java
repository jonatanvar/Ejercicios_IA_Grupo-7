/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 119 | 2025-10-27               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio119;

public class Registros {

    // === CONSTANTES GLOBALES ===
    public static final int MAX_PACIENTES = 100;
    public static final int MAX_CONSULTAS = 100;

    // === ESTRUCTURA FECHA ===
    public static class Fecha {
        public int año, mes, día;

        public Fecha() {
            this.año = 0;
            this.mes = 0;
            this.día = 0;
        }
    }

    // === ESTRUCTURA PACIENTE ===
    public static class Paciente {
        public int expediente;
        public String nombre, apellido, diagnostico;
        public int edad;
        public char sexo;

        public Paciente() {
            this.expediente = 0;
            this.nombre = "";
            this.apellido = "";
            this.diagnostico = "";
            this.edad = 0;
            this.sexo = ' ';
        }
    }

    // === ESTRUCTURA EXPEDIENTE DE PAGO ===
    public static class Exped {
        public int expediente;
        public Fecha[] consultas;
        public double[] montos;
        public int numConsultas;
        public double pagado;
        public double pendiente;

        public Exped() {
            this.expediente = 0;
            this.consultas = new Fecha[MAX_CONSULTAS];  // AHORA SÍ EXISTE
            this.montos = new double[MAX_CONSULTAS];
            this.numConsultas = 0;
            this.pagado = 0.0;
            this.pendiente = 0.0;

            // Inicializar arreglos de fechas
            for (int i = 0; i < MAX_CONSULTAS; i++) {
                this.consultas[i] = new Fecha();
            }
        }
    }
}