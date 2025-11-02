/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 119 | 2025-10-27               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio119;

import java.util.Scanner;

public class MiLibrería {

    private static final int MAX_PACIENTES = 100;
    private static final int MAX_CONSULTAS = 100;
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    // === ESTRUCTURAS (usando Registros) ===
    private static Registros.Paciente[] pacientes = new Registros.Paciente[MAX_PACIENTES];
    private static Registros.Exped[] pagos = new Registros.Exped[MAX_PACIENTES];
    private static int numPacientes = 0;

    // === GETTER Y SETTER IDIOMA ===
    public static String getIdioma() {
        return idiomaActual;
    }

    public static void setIdioma(String idioma) {
        idiomaActual = idioma;
    }

    // === INICIALIZACIÓN ===
    public static void inicializarSistema() {
        for (int i = 0; i < MAX_PACIENTES; i++) {
            pacientes[i] = new Registros.Paciente();
            pagos[i] = new Registros.Exped();
        }
        numPacientes = 0;
    }

    // === VALIDACIONES ===
    public static boolean expedienteExiste(int exp) {
        for (int i = 0; i < numPacientes; i++) {
            if (pacientes[i].expediente == exp) return true;
        }
        return false;
    }

    public static int buscarIndicePaciente(int exp) {
        for (int i = 0; i < numPacientes; i++) {
            if (pacientes[i].expediente == exp) return i;
        }
        return -1;
    }

    // === CREAR PACIENTE ===
    public static void crearPaciente(Scanner sc) {
        if (numPacientes >= MAX_PACIENTES) {
            Utilidades.mostrarError(Utilidades.obtenerTexto("LIMITE_PACIENTES", idiomaActual), idiomaActual);
            return;
        }

        int exp;
        do {
            System.out.print("Expediente (único): ");
            exp = Operaciones.validarEnteroPositivo(sc);
            if (expedienteExiste(exp)) {
                Utilidades.mostrarError(Utilidades.obtenerTexto("EXPEDIENTE_DUPLICADO", idiomaActual), idiomaActual);
            }
        } while (expedienteExiste(exp));

        Registros.Paciente p = pacientes[numPacientes];
        p.expediente = exp;
        System.out.print("Nombre: "); p.nombre = sc.nextLine();
        System.out.print("Apellido: "); p.apellido = sc.nextLine();
        System.out.print("Edad: "); p.edad = Operaciones.validarEnteroPositivo(sc);
        System.out.print("Sexo (M/F): "); p.sexo = sc.nextLine().toUpperCase().charAt(0);
        System.out.print("Diagnóstico: "); p.diagnostico = sc.nextLine();

        Registros.Exped ep = pagos[numPacientes];
        ep.expediente = exp;
        ep.numConsultas = 0;
        ep.pagado = 0.0;
        ep.pendiente = 0.0;

        numPacientes++;
        Utilidades.mostrarPacienteCreado(p);
    }

    // === BUSCAR PACIENTE ===
    public static void buscarPaciente(Scanner sc) {
        System.out.print("Expediente a buscar: ");
        int exp = Operaciones.validarEnteroPositivo(sc);
        int idx = buscarIndicePaciente(exp);
        if (idx == -1) {
            Utilidades.mostrarError(Utilidades.obtenerTexto("PACIENTE_NO_ENCONTRADO", idiomaActual), idiomaActual);
            return;
        }
        Utilidades.mostrarPaciente(pacientes[idx], pagos[idx]);
    }

    // === MODIFICAR PACIENTE ===
    public static void modificarPaciente(Scanner sc) {
        System.out.print("Expediente a modificar: ");
        int exp = Operaciones.validarEnteroPositivo(sc);
        int idx = buscarIndicePaciente(exp);
        if (idx == -1) {
            Utilidades.mostrarError(Utilidades.obtenerTexto("PACIENTE_NO_ENCONTRADO", idiomaActual), idiomaActual);
            return;
        }

        System.out.println("Datos actuales:");
        Utilidades.mostrarPaciente(pacientes[idx], pagos[idx]);

        System.out.print("Nuevo nombre [" + pacientes[idx].nombre + "]: ");
        String nuevo = sc.nextLine();
        if (!nuevo.isEmpty()) pacientes[idx].nombre = nuevo;

        System.out.print("Nuevo apellido [" + pacientes[idx].apellido + "]: ");
        nuevo = sc.nextLine();
        if (!nuevo.isEmpty()) pacientes[idx].apellido = nuevo;

        System.out.print("Nueva edad [" + pacientes[idx].edad + "]: ");
        if (sc.hasNextInt()) {
            pacientes[idx].edad = sc.nextInt(); sc.nextLine();
        } else {
            sc.nextLine();
        }

        System.out.print("Nuevo sexo (M/F) [" + pacientes[idx].sexo + "]: ");
        nuevo = sc.nextLine().toUpperCase();
        if (nuevo.length() > 0) pacientes[idx].sexo = nuevo.charAt(0);

        System.out.print("Nuevo diagnóstico [" + pacientes[idx].diagnostico + "]: ");
        nuevo = sc.nextLine();
        if (!nuevo.isEmpty()) pacientes[idx].diagnostico = nuevo;

        System.out.println("Paciente modificado con éxito.");
    }

    // === LISTAR PACIENTES ===
    public static void listarPacientes() {
        if (numPacientes == 0) {
            Utilidades.mostrarError("No hay pacientes registrados.", idiomaActual);
            return;
        }

        System.out.println("\n╔" + "═".repeat(68) + "╗");
        System.out.println("║" + Utilidades.centrarTexto("LISTA DE PACIENTES", 68) + "║");
        System.out.println("╠" + "═".repeat(68) + "╣");
        System.out.println("║ Exp │ Nombre Completo        │ Edad │ Sexo │ Diagnóstico         ║");
        System.out.println("╠" + "═".repeat(68) + "╣");

        for (int i = 0; i < numPacientes; i++) {
            String nombreCompleto = (pacientes[i].nombre + " " + pacientes[i].apellido);
            nombreCompleto = nombreCompleto.length() > 22 ? nombreCompleto.substring(0, 22) : nombreCompleto;
            String diag = pacientes[i].diagnostico.length() > 19 ? pacientes[i].diagnostico.substring(0, 19) : pacientes[i].diagnostico;

            System.out.printf("║ %3d │ %-22s │ %4d │  %c   │ %-19s ║%n",
                    pacientes[i].expediente,
                    nombreCompleto,
                    pacientes[i].edad,
                    pacientes[i].sexo,
                    diag
            );
        }
        System.out.println("╚" + "═".repeat(68) + "╝");
    }

    // === REGISTRAR CONSULTA ===
    public static void registrarConsulta(Scanner sc) {
        System.out.print("Expediente del paciente: ");
        int exp = Operaciones.validarEnteroPositivo(sc);
        int idx = buscarIndicePaciente(exp);
        if (idx == -1) {
            Utilidades.mostrarError(Utilidades.obtenerTexto("PACIENTE_NO_ENCONTRADO", idiomaActual), idiomaActual);
            return;
        }

        if (pagos[idx].numConsultas >= MAX_CONSULTAS) {
            Utilidades.mostrarError(Utilidades.obtenerTexto("CONSULTA_LIMITE", idiomaActual), idiomaActual);
            return;
        }

        Registros.Fecha fecha = new Registros.Fecha();
        do {
            System.out.print("Día: "); fecha.día = Operaciones.validarEnteroPositivo(sc);
            System.out.print("Mes: "); fecha.mes = Operaciones.validarEnteroPositivo(sc);
            System.out.print("Año: "); fecha.año = Operaciones.validarEnteroPositivo(sc);
            if (!Operaciones.validarFecha(fecha.día, fecha.mes, fecha.año)) {
                Utilidades.mostrarError(Utilidades.obtenerTexto("FECHA_INVALIDA", idiomaActual), idiomaActual);
            }
        } while (!Operaciones.validarFecha(fecha.día, fecha.mes, fecha.año));

        double costo = Operaciones.validarMonto(sc, "Costo de la consulta: $");

        pagos[idx].consultas[pagos[idx].numConsultas] = fecha;
        pagos[idx].montos[pagos[idx].numConsultas] = costo;

        System.out.print("¿El paciente paga ahora? (S/N): ");
        char paga = sc.nextLine().toUpperCase().charAt(0);

        double abono = 0.0;
        if (paga == 'S') {
            abono = Operaciones.validarMonto(sc, "Monto a pagar: $");
            if (abono > costo) {
                Utilidades.mostrarError("El abono no puede exceder el costo.", idiomaActual);
                return;
            }
        }

        double nuevoPendiente = costo - abono;
        pagos[idx].pagado += abono;
        pagos[idx].pendiente += nuevoPendiente;
        pagos[idx].numConsultas++;

        Utilidades.mostrarConsultaRegistrada(pacientes[idx], exp, fecha, costo, abono, pagos[idx].pendiente);
    }

    // === REGISTRAR PAGO ===
    public static void registrarPago(Scanner sc) {
        System.out.print("Expediente del paciente: ");
        int exp = Operaciones.validarEnteroPositivo(sc);
        int idx = buscarIndicePaciente(exp);
        if (idx == -1) {
            Utilidades.mostrarError(Utilidades.obtenerTexto("PACIENTE_NO_ENCONTRADO", idiomaActual), idiomaActual);
            return;
        }

        if (pagos[idx].pendiente <= 0) {
            Utilidades.mostrarSinDeuda();
            return;
        }

        System.out.println("Deuda actual: " + Utilidades.formatearMoneda(pagos[idx].pendiente));
        double abono = Operaciones.validarMonto(sc, "Monto a abonar: $");
        if (abono > pagos[idx].pendiente) {
            Utilidades.mostrarError(Utilidades.obtenerTexto("ABONO_EXCEDE", idiomaActual), idiomaActual);
            return;
        }

        pagos[idx].pagado += abono;
        pagos[idx].pendiente -= abono;

        Utilidades.mostrarPagoRegistrado(pacientes[idx], abono, pagos[idx].pagado, pagos[idx].pendiente);
    }

    // === ESTADÍSTICAS ===
    public static void estadisticasPorSexo() {
        int m = 0, f = 0;
        for (int i = 0; i < numPacientes; i++) {
            if (pacientes[i].sexo == 'M') m++;
            else if (pacientes[i].sexo == 'F') f++;
        }
        System.out.println("\n┌" + "─".repeat(68) + "┐");
        System.out.println("│" + Utilidades.centrarTexto("ESTADÍSTICAS POR SEXO", 68) + "│");
        System.out.println("├" + "─".repeat(68) + "┤");
        System.out.println("│ Masculino: " + m + " pacientes" + " ".repeat(68 - 18 - String.valueOf(m).length()) + "│");
        System.out.println("│ Femenino: " + f + " pacientes" + " ".repeat(68 - 17 - String.valueOf(f).length()) + "│");
        System.out.println("└" + "─".repeat(68) + "┘");
    }

    public static void estadisticasPorDiagnostico() {
        System.out.println("Estadísticas por diagnóstico en desarrollo...");
    }

    public static void mostrarDeudores() {
        Utilidades.mostrarListaDeudores(pacientes, pagos, numPacientes);
    }

    // === PROGRAMA PRINCIPAL ===
    public static void iniciarPrograma(Scanner sc) {
        inicializarSistema();
        idiomaActual = Menús.seleccionarIdioma(sc);

        do {
            Menús.mostrarMenuPrincipal();
            int opcion = Operaciones.validarOpcionMenu(sc, 0, 4);
            switch (opcion) {
                case 1 -> Menús.gestionPacientes(sc);
                case 2 -> registrarConsulta(sc);
                case 3 -> registrarPago(sc);
                case 4 -> Menús.estadisticas(sc);
                case 0 -> continuar = false;
            }
        } while (continuar);
    }
}