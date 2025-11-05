package Ejercicio118_KevinLainez;

import java.lang.Math;
import java.util.Arrays;
import java.util.Comparator;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 118 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que representa el registro de un Paciente con sus datos antropométricos y diagnóstico.
 */
class Paciente {
    // Requerimientos: expediente (hasta dos cifras), y datos personales/antropométricos
    public int expediente;
    public String nombre;
    public String apellido;
    public char sexo; // H o M
    public String celular;
    public double pesoLb;
    public double estaturaCm;

    // Campos calculados
    public double imc;
    public String diagnostico;

    // Constructor mínimo para inicialización
    public Paciente(int exp, String nom, String ape, char sex, String cel, double peso, double est) {
        this.expediente = exp;
        this.nombre = nom;
        this.apellido = ape;
        this.sexo = sex;
        this.celular = cel;
        this.pesoLb = peso;
        this.estaturaCm = est;
        // Calcular IMC y Dx inmediatamente
        calcularIMC_y_Dx();
    }

    // Método para calcular IMC y Dx
    public void calcularIMC_y_Dx() {
        // Conversión: Peso de Lb a Kg (1 Lb = 0.453592 Kg)
        double pesoKg = this.pesoLb * 0.453592;

        // Conversión: Estatura de Cm a Metros
        double estaturaM = this.estaturaCm / 100.0;

        // Fórmula IMC = peso (kg) / estatura² (m²)
        this.imc = pesoKg / Math.pow(estaturaM, 2);

        // Asignar Diagnóstico (OMS estándar)
        if (this.imc < 18.5) {
            this.diagnostico = "Bajo peso";
        } else if (this.imc < 25.0) {
            this.diagnostico = "Normopeso";
        } else if (this.imc < 30.0) {
            this.diagnostico = "Sobrepeso";
        } else if (this.imc < 35.0) {
            this.diagnostico = "Obesidad Grado I";
        } else if (this.imc < 40.0) {
            this.diagnostico = "Obesidad Grado II";
        } else {
            this.diagnostico = "Obesidad Grado III";
        }
    }

    // Métodos Getter para presentación
    public double getPesoKg() {
        return this.pesoLb * 0.453592;
    }
}


/**
 * Clase que contiene la lógica de negocio para gestionar la lista de pacientes.
 */
public class operaciones {

    // Total de pacientes registrados
    private static int contadorPacientes = 0;

    /**
     * Busca un paciente por su número de expediente.
     * @param pacientes El arreglo completo de pacientes.
     * @param expediente El número de expediente a buscar.
     * @return El índice del paciente en el arreglo, o -1 si no se encuentra.
     */
    public static int buscarPacientePorExpediente(Paciente[] pacientes, int expediente) {
        for (int i = 0; i < contadorPacientes; i++) {
            if (pacientes[i] != null && pacientes[i].expediente == expediente) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Agrega un paciente al arreglo y actualiza el contador.
     * @param pacientes El arreglo de pacientes.
     * @param nuevoPaciente El objeto Paciente a agregar.
     * @return true si se agregó con éxito, false si el arreglo está lleno.
     */
    public static boolean agregarPaciente(Paciente[] pacientes, Paciente nuevoPaciente) {
        if (contadorPacientes < pacientes.length) {
            pacientes[contadorPacientes] = nuevoPaciente;
            contadorPacientes++;
            return true;
        }
        return false;
    }

    /**
     * Ordena una copia del arreglo de pacientes por número de expediente.
     * @param pacientes El arreglo original.
     * @return Un nuevo arreglo ordenado con solo los pacientes no nulos.
     */
    public static Paciente[] obtenerPacientesOrdenados(Paciente[] pacientes) {
        // Copiamos solo los pacientes válidos (hasta contadorPacientes)
        Paciente[] subArreglo = new Paciente[contadorPacientes];
        System.arraycopy(pacientes, 0, subArreglo, 0, contadorPacientes);

        // Ordenamos la copia por el campo 'expediente'
        Arrays.sort(subArreglo, Comparator.comparingInt(p -> p.expediente));

        return subArreglo;
    }

    /**
     * Obtiene el número actual de pacientes registrados.
     */
    public static int getContadorPacientes() {
        return contadorPacientes;
    }

    /**
     * Incrementa y obtiene el siguiente expediente disponible de forma secuencial.
     * (Asumiendo que el main debe controlar la asignación de expedientes únicos)
     * En este caso, devolveremos el contador para fines de ejemplo.
     */
    public static int getSiguienteExpediente() {
        // Se asume que el expediente es igual a la posición, pero el requisito pide que sea hasta 2 cifras.
        // Lo dejamos simple aquí: el main pedirá el expediente y operaciones lo validará como único.
        // Si el main pide el expediente: la validación debe ser antes de agregar.
        return contadorPacientes + 1;
    }

    // --- LÓGICA DE ESTADÍSTICAS ---

    /**
     * Cuenta el total de hombres y mujeres.
     * @param pacientes El arreglo de pacientes.
     * @return Arreglo [Hombres, Mujeres].
     */
    public static int[] contarPorSexo(Paciente[] pacientes) {
        int hombres = 0;
        int mujeres = 0;
        for (int i = 0; i < contadorPacientes; i++) {
            if (pacientes[i] != null) {
                if (pacientes[i].sexo == 'H') {
                    hombres++;
                } else if (pacientes[i].sexo == 'M') {
                    mujeres++;
                }
            }
        }
        return new int[]{hombres, mujeres};
    }

    /**
     * Cuenta la frecuencia de cada diagnóstico.
     * @param pacientes El arreglo de pacientes.
     * @return Arreglo de strings con el formato "Diagnóstico:Conteo".
     */
    public static String[] contarPorDiagnostico(Paciente[] pacientes) {
        java.util.Map<String, Integer> conteo = new java.util.HashMap<>();

        for (int i = 0; i < contadorPacientes; i++) {
            if (pacientes[i] != null) {
                String dx = pacientes[i].diagnostico;
                conteo.put(dx, conteo.getOrDefault(dx, 0) + 1);
            }
        }

        // Convertir el mapa a un arreglo de String para su presentación
        String[] resultado = new String[conteo.size()];
        int k = 0;
        for (java.util.Map.Entry<String, Integer> entry : conteo.entrySet()) {
            resultado[k++] = entry.getKey() + ":" + entry.getValue();
        }
        return resultado;
    }
}