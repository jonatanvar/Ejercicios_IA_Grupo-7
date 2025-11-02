/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 021 | 2025-10-11               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Agente ahora el ejercicio #21: Nomina simple: Desarrolle un programa en JAVA que utilice una instrucción while para determinar el sueldo bruto para cada uno de varios empleados (Máximo 5 empleados y mínimo 3), La empresa paga la cuota normal en las primeras 40 horas de trabajo de cada empleado, y paga cuota y media en todas las horas trabajadas que excedan de 40. Usted recibe una lista de los empleados de la empresa, el número de horas que trabajó cada empleado la semana pasada y la tarifa por horas de cada empleado, que el numero de pago de cuota que sea de 2,000 lempiras y muestras ese dato, Su programa debe recibir como entrada esta información para cada empleado, debe determinar y mostrar el sueldo bruto de cada empleado. Muestras una tabla con los datos ingresados por el usuario, que tenga que ingresar la cantidad e horas trabajadas, si pasa mas de 40 horas paga mas "y paga cuota y media en todas las horas trabajadas que excedan de 40". Usa nuestra nueva distribución de archivos: ejercicio0XX/ ├── Ejercicio0XX_Main.java (Flujo principal con ciclos) ├── Ejercicio0XX_Menus.java (Menús de idioma y principal) ├── Ejercicio0XX_Operaciones.java (Lógica del ejercicio) └── Ejercicio0XX_Utilidades.java (Diseño y formato). Las nuevas funciones anteriormente mencionada que solo te recuerdo: "contar con un menú de selección de idioma y luego con un segundo menú donde pueda elegirse entre ejecutarse o interrumpir la ejecución (finalizar el programa).
 */

package Ejercicio021;

import java.util.Scanner;

public class Ejercicio021_Main {
    private static final String LINEA = "═";
    private static final int ANCHO = 70;
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Ejercicio021_Utilidades.mostrarSello();
        idiomaActual = Ejercicio021_Menus.seleccionarIdioma(scanner);

        do {
            int opcion = Ejercicio021_Menus.mostrarMenuPrincipal(scanner, idiomaActual);
            if (opcion == 1) {
                ejecutarEjercicio(scanner, idiomaActual);
                continuar = Ejercicio021_Menus.preguntarRepetir(scanner, idiomaActual);
            } else {
                Ejercicio021_Menus.mostrarDespedida(idiomaActual);
                continuar = false;
            }
        } while (continuar);

        scanner.close();
    }

    private static void ejecutarEjercicio(Scanner scanner, String idioma) {
        int numEmpleados;
        do {
            numEmpleados = Ejercicio021_Utilidades.mostrarIngresoNumEmpleados(scanner, idioma);
        } while (numEmpleados < 3 || numEmpleados > 5);

        String[] nombres = new String[numEmpleados];
        double[] horas = new double[numEmpleados];
        double[] tarifas = new double[numEmpleados];
        double[] sueldos = new double[numEmpleados];

        int i = 0;
        while (i < numEmpleados) {
            Ejercicio021_Utilidades.mostrarIngresoDatosEmpleado(scanner, idioma, i + 1, nombres, horas, tarifas, i);
            sueldos[i] = Ejercicio021_Operaciones.calcularSueldoBruto(horas[i], tarifas[i]);
            i++;
        }

        Ejercicio021_Utilidades.mostrarTablaResultados(nombres, horas, tarifas, sueldos, idioma);
    }
}