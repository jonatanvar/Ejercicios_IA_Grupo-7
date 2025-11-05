package Ejercicio118_KevinLainez;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 118 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #118: Sistema de Clínica Nutricional
 * * PROMPT:
 * Sistema para una clínica de nutrición (50 pacientes) con menú: Agregar, Ver (ordenado),
 * Modificar (Celular, Peso, Estatura), Estadísticas (gráficas H/M y por Dx).
 */
public class main {

    private static final int MAX_PACIENTES = 50;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Paciente[] pacientes = new Paciente[MAX_PACIENTES];
        int opcion;

        // EJEMPLO INICIAL para pruebas rápidas
        // Expedientes deben ser únicos
        operaciones.agregarPaciente(pacientes, new Paciente(
                27, "Erlinda", "Paola", 'M', "31772939", 110.0, 160.0));
        operaciones.agregarPaciente(pacientes, new Paciente(
                31, "Marvin", "Aguilar", 'H', "31772979", 170.0, 175.0));
        operaciones.agregarPaciente(pacientes, new Paciente(
                15, "Laura", "Varela", 'M', "98765432", 130.0, 165.0));
        operaciones.agregarPaciente(pacientes, new Paciente(
                45, "Juan", "Perez", 'H', "55554444", 250.0, 180.0));



        // 2. Bucle principal del menú
        do {
            opcion = utilidades.mostrarMenuPrincipal(sc);

            switch (opcion) {
                case 1:
                    agregarPaciente(sc, pacientes);
                    break;
                case 2:
                    verPacientes(pacientes);
                    break;
                case 3:
                    modificarPaciente(sc, pacientes);
                    break;
                case 4:
                    mostrarEstadisticas(pacientes);
                    break;
                case 0:
                    System.out.println(utilidades.centrarTexto("Saliendo del sistema..."));
                    break;
                default:
                    System.out.println(utilidades.centrarTexto("Opción no válida. Intente de nuevo."));
                    break;
            }
            if (opcion != 0) {
                System.out.println(utilidades.dibujarLineaHorizontal('─', '─'));
            }
        } while (opcion != 0);

        // 3. Finalización
        utilidades.mostrarSelloCorto();
        System.out.println("\n--- Programa finalizado con éxito ---");
        sc.close();
    }

    // --- LÓGICA DE OPCIONES DEL MENÚ ---

    private static void agregarPaciente(Scanner sc, Paciente[] pacientes) {
        if (operaciones.getContadorPacientes() >= MAX_PACIENTES) {
            System.out.println(utilidades.centrarTexto("ERROR: La clínica ha alcanzado el límite de 50 pacientes."));
            return;
        }

        System.out.println("\n" + utilidades.dibujarLineaHorizontal('┌', '┐'));
        System.out.println(utilidades.centrarTexto("--- AGREGAR NUEVO PACIENTE ---"));

        int exp = utilidades.solicitarExpediente(sc, pacientes, false); // Expediente debe ser único
        String nom = utilidades.solicitarString(sc, ">> Nombre: ");
        String ape = utilidades.solicitarString(sc, ">> Apellido: ");
        char sex = utilidades.solicitarSexo(sc);
        String cel = utilidades.solicitarString(sc, ">> Celular: ");
        double peso = utilidades.solicitarDouble(sc, ">> Peso (Lb): ", 1.0);
        double est = utilidades.solicitarDouble(sc, ">> Estatura (cm): ", 50.0);

        Paciente nuevo = new Paciente(exp, nom, ape, sex, cel, peso, est);

        if (operaciones.agregarPaciente(pacientes, nuevo)) {
            System.out.println(utilidades.centrarTexto("Paciente agregado con EXP " + exp + ". Dx: " + nuevo.diagnostico));
        }
    }

    private static void verPacientes(Paciente[] pacientes) {
        if (operaciones.getContadorPacientes() == 0) {
            System.out.println(utilidades.centrarTexto("No hay pacientes registrados."));
            return;
        }

        // Obtenemos el arreglo ordenado
        Paciente[] ordenados = operaciones.obtenerPacientesOrdenados(pacientes);
        utilidades.mostrarTablaPacientes(ordenados);
    }

    private static void modificarPaciente(Scanner sc, Paciente[] pacientes) {
        if (operaciones.getContadorPacientes() == 0) {
            System.out.println(utilidades.centrarTexto("No hay pacientes para modificar."));
            return;
        }

        System.out.println("\n" + utilidades.dibujarLineaHorizontal('┌', '┐'));
        System.out.println(utilidades.centrarTexto("--- MODIFICAR PACIENTE ---"));

        // 1. Buscar paciente
        int exp = utilidades.solicitarExpediente(sc, pacientes, true); // Expediente debe existir
        int indice = operaciones.buscarPacientePorExpediente(pacientes, exp);

        if (indice == -1) return; // Ya fue manejado por solicitarExpediente

        Paciente p = pacientes[indice];

        // 2. Mostrar menú de modificación
        System.out.println(utilidades.dibujarLineaHorizontal('├', '┤'));
        System.out.println(utilidades.centrarTexto(String.format("Paciente %d (%s %s) encontrado.", p.expediente, p.nombre, p.apellido)));
        System.out.println(utilidades.centrarTexto("¿Qué desea modificar? (1: Celular, 2: Peso (Lb), 3: Estatura (cm)): "));

        int opcionMod = -1;
        try {
            opcionMod = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            sc.nextLine();
        }

        // 3. Aplicar modificación
        switch (opcionMod) {
            case 1:
                p.celular = utilidades.solicitarString(sc, ">> Nuevo Celular: ");
                System.out.println(utilidades.centrarTexto("Celular actualizado."));
                break;
            case 2:
                p.pesoLb = utilidades.solicitarDouble(sc, ">> Nuevo Peso (Lb): ", 1.0);
                p.calcularIMC_y_Dx(); // Recalcular Dx
                System.out.println(utilidades.centrarTexto("Peso actualizado y diagnóstico recalculado."));
                break;
            case 3:
                p.estaturaCm = utilidades.solicitarDouble(sc, ">> Nueva Estatura (cm): ", 50.0);
                p.calcularIMC_y_Dx(); // Recalcular Dx
                System.out.println(utilidades.centrarTexto("Estatura actualizada y diagnóstico recalculado."));
                break;
            default:
                System.out.println(utilidades.centrarTexto("Opción de modificación no válida."));
                break;
        }

        // 4. Mostrar información actualizada
        System.out.println(utilidades.dibujarLineaHorizontal('├', '┤'));
        System.out.println(utilidades.centrarTexto("--- INFORMACIÓN ACTUALIZADA ---"));
        System.out.println(utilidades.centrarTexto(String.format("IMC: %.2f | Dx: %s", p.imc, p.diagnostico)));
        System.out.println(utilidades.dibujarLineaHorizontal('└', '┘'));
    }

    private static void mostrarEstadisticas(Paciente[] pacientes) {
        int total = operaciones.getContadorPacientes();
        if (total == 0) {
            System.out.println(utilidades.centrarTexto("No hay datos para generar estadísticas."));
            return;
        }

        // 1. Estadísticas por Sexo (Hombres/Mujeres)
        int[] conteoSexo = operaciones.contarPorSexo(pacientes);
        utilidades.mostrarEstadisticasSexo(conteoSexo);

        // 2. Estadísticas por Diagnóstico (Dx)
        String[] conteoDiagnostico = operaciones.contarPorDiagnostico(pacientes);
        utilidades.mostrarEstadisticasDiagnostico(conteoDiagnostico, total);
    }
}