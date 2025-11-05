package Ejercicio120;

import java.util.Scanner;

public class Ejercicio120_Main {

    private static final int MSG_OPCION = 4;
    private static final int MSG_EXPEDIENTE = 20;
    private static final int MSG_AÑO = 21;
    private static final int MSG_MES = 22;
    private static final int MSG_DIA = 23;
    private static final int MSG_VALOR = 24;
    private static final int MSG_PAGO = 25;
    private static final int MSG_ABONO = 26;
    private static final int MSG_FINALIZACION = 30;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ejercicio120_Utilidades.mostrarSelloCorto();
        Ejercicio120_Utilidades.seleccionarIdioma(sc);

        Paciente[] pacientes = Ejercicio120_Funciones.inicializarPacientes();
        ExpedientePago[] expPag = Ejercicio120_Funciones.inicializarExpedientes();
        int numPac = 0, numExp = 0;

        pacientes[numPac++] = new Paciente(101, "Ana López", 'F', "Obesidad");
        pacientes[numPac++] = new Paciente(102, "Carlos Méndez", 'M', "Diabetes");
        pacientes[numPac++] = new Paciente(103, "María Rivera", 'F', "Hipertensión");

        for (int i = 0; i < numPac; i++) {
            int idx = Ejercicio120_Funciones.obtenerIndiceExpediente(expPag, pacientes[i].expediente, numExp);
            if (idx == numExp) numExp++;
        }

        boolean ejecutar = true;
        while (ejecutar) {
            if (!Ejercicio120_Utilidades.mostrarMenuEjecucion(sc)) {
                ejecutar = false;
                continue;
            }
            Ejercicio120_Utilidades.mostrarEncabezado();

            boolean enMenu = true;
            while (enMenu) {
                Ejercicio120_Utilidades.mostrarMenuPrincipal();
                int op = Ejercicio120_Utilidades.leerEnteroRango(sc,
                        Ejercicio120_Utilidades.obtenerTexto(MSG_OPCION), 1, 4);

                switch (op) {
                    case 1 -> {
                        int exp = Ejercicio120_Utilidades.leerEnteroRango(sc,
                                Ejercicio120_Utilidades.obtenerTexto(MSG_EXPEDIENTE), 1, 999);
                        int idxPac = Ejercicio120_Funciones.buscarPaciente(pacientes, exp, numPac);
                        if (idxPac == -1) {
                            System.out.println("Paciente no encontrado.");
                            break;
                        }
                        int idxExp = Ejercicio120_Funciones.obtenerIndiceExpediente(expPag, exp, numExp);
                        if (idxExp == numExp) numExp++;

                        int año = Ejercicio120_Utilidades.leerEnteroRango(sc,
                                Ejercicio120_Utilidades.obtenerTexto(MSG_AÑO), 2000, 2100);
                        int mes = Ejercicio120_Utilidades.leerEnteroRango(sc,
                                Ejercicio120_Utilidades.obtenerTexto(MSG_MES), 1, 12);
                        int día = Ejercicio120_Utilidades.leerEnteroRango(sc,
                                Ejercicio120_Utilidades.obtenerTexto(MSG_DIA), 1, 31);
                        double valor = Ejercicio120_Utilidades.leerDoublePositivo(sc,
                                Ejercicio120_Utilidades.obtenerTexto(MSG_VALOR));
                        double pago = Ejercicio120_Utilidades.leerDoublePositivo(sc,
                                Ejercicio120_Utilidades.obtenerTexto(MSG_PAGO));

                        Ejercicio120_Funciones.registrarConsulta(expPag[idxExp], año, mes, día, valor, pago);
                        System.out.println("Consulta registrada exitosamente.");
                    }
                    case 2 -> {
                        int exp = Ejercicio120_Utilidades.leerEnteroRango(sc,
                                Ejercicio120_Utilidades.obtenerTexto(MSG_EXPEDIENTE), 1, 999);
                        int idxExp = Ejercicio120_Funciones.obtenerIndiceExpediente(expPag, exp, numExp);
                        if (idxExp == numExp) {
                            System.out.println("Paciente sin consultas.");
                            break;
                        }
                        double abono = Ejercicio120_Utilidades.leerDoublePositivo(sc,
                                Ejercicio120_Utilidades.obtenerTexto(MSG_ABONO));
                        Ejercicio120_Funciones.abonarDeuda(expPag[idxExp], abono);
                        System.out.println("Abono registrado.");
                    }
                    case 3 -> Ejercicio120_Utilidades.mostrarEstadisticas(pacientes, numPac, expPag, numExp);
                    case 4 -> enMenu = false;
                }
                System.out.println();
            }
        }

        sc.close();
        System.out.println(Ejercicio120_Utilidades.obtenerTexto(MSG_FINALIZACION));
    }
}