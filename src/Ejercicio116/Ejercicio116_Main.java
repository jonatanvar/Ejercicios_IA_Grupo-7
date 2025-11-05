package Ejercicio116;

import java.util.Scanner;

public class Ejercicio116_Main {

    private static final int MSG_FINALIZACION = 29;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][][][] hospital = UtilidadesHospital.inicializarHospital();

        Ejercicio116_Utilidades.mostrarSelloCorto();
        Ejercicio116_Utilidades.seleccionarIdioma(scanner);

        boolean ejecutar = true;
        while (ejecutar) {
            UtilidadesHospital.limpiarPantalla();
            Ejercicio116_Utilidades.mostrarEncabezado();

            int opcion = Ejercicio116_Utilidades.mostrarMenuEjecucion(scanner);

            int esp, piso, hab, cama, expediente;
            boolean resultado;

            switch (opcion) {
                case 1:
                    esp = Ejercicio116_Utilidades.leerEspecialidad(scanner) - 1;
                    Ejercicio116_Funciones.consultarCamasPorEspecialidad(hospital, esp);
                    break;

                case 2:
                    esp = Ejercicio116_Utilidades.leerEspecialidad(scanner) - 1;
                    piso = Ejercicio116_Utilidades.leerPiso(scanner) - 1;
                    Ejercicio116_Utilidades.mostrarMatrizPiso(hospital, esp, piso);
                    break;

                case 3:
                    System.out.println("\n--- ASIGNAR PACIENTE ---");
                    esp = Ejercicio116_Utilidades.leerEspecialidad(scanner) - 1;
                    piso = Ejercicio116_Utilidades.leerPiso(scanner) - 1;
                    hab = Ejercicio116_Utilidades.leerHabitacion(scanner) - 1;
                    cama = Ejercicio116_Utilidades.leerCama(scanner) - 1;
                    expediente = Ejercicio116_Utilidades.leerExpediente(scanner);

                    resultado = Ejercicio116_Funciones.asignarCama(hospital, esp, piso, hab, cama, expediente);

                    if (resultado) {
                        System.out.printf(Ejercicio116_Utilidades.obtenerTexto(26), expediente,
                                UtilidadesHospital.NOMBRES_ESPECIALIDADES[esp],
                                UtilidadesHospital.obtenerNombreCardinal(piso),
                                hab + 1, cama + 1);
                    } else {
                        System.out.printf(Ejercicio116_Utilidades.obtenerTexto(25), hospital[esp][piso][hab][cama]);
                    }
                    break;

                case 4:
                    System.out.println("\n--- LIBERAR CAMA ---");
                    esp = Ejercicio116_Utilidades.leerEspecialidad(scanner) - 1;
                    piso = Ejercicio116_Utilidades.leerPiso(scanner) - 1;
                    hab = Ejercicio116_Utilidades.leerHabitacion(scanner) - 1;
                    cama = Ejercicio116_Utilidades.leerCama(scanner) - 1;

                    resultado = Ejercicio116_Funciones.liberarCama(hospital, esp, piso, hab, cama);

                    if (resultado) {
                        System.out.printf(Ejercicio116_Utilidades.obtenerTexto(28),
                                UtilidadesHospital.NOMBRES_ESPECIALIDADES[esp],
                                UtilidadesHospital.obtenerNombreCardinal(piso),
                                hab + 1, cama + 1);
                    } else {
                        System.out.println(Ejercicio116_Utilidades.obtenerTexto(27));
                    }
                    break;

                case 5:
                    Ejercicio116_Funciones.mostrarTablaCamasOcupadas(hospital);
                    break;

                case 6:
                    ejecutar = false;
                    break;
            }

            if (opcion != 6) {
                System.out.print("\nPresione ENTER para continuar...");
                scanner.nextLine(); // Pausa y consume la entrada
            }
        }

        scanner.close();
        System.out.println(Ejercicio116_Utilidades.obtenerTexto(MSG_FINALIZACION));
    }
}