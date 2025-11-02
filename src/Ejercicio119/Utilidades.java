/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 119 | 2025-10-27               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio119;

public class Utilidades {

    private static final int ANCHO = 70;

    public static String centrarTexto(String texto, int ancho) {
        int espacios = ancho - texto.length();
        int izq = espacios / 2;
        int der = espacios - izq;
        return " ".repeat(Math.max(0, izq)) + texto + " ".repeat(Math.max(0, der));
    }

    public static void mostrarSello() {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ Jonatan Varela | jivarelag@unah.hn | 119 | 2025-10-27                │");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarError(String mensaje, String idioma) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto(mensaje, ANCHO - 2) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static String formatearMoneda(double monto) {
        return String.format("$%.2f", monto);
    }

    public static String formatearFecha(int dia, int mes, int año) {
        return String.format("%02d/%02d/%04d", dia, mes, año);
    }

    public static String obtenerTexto(String clave, String idioma) {
        if (idioma.equals("ES")) {
            return switch (clave) {
                case "ENTERO_INVALIDO" -> "Debe ingresar un número entero válido.";
                case "MONTO_INVALIDO" -> "El monto debe ser mayor a 0.";
                case "FECHA_INVALIDA" -> "Fecha inválida.";
                case "EXPEDIENTE_DUPLICADO" -> "El expediente ya existe.";
                case "PACIENTE_NO_ENCONTRADO" -> "Paciente no encontrado.";
                case "LIMITE_PACIENTES" -> "Límite de pacientes alcanzado.";
                case "SIN_DEUDA" -> "El paciente no tiene deudas pendientes.";
                case "ABONO_EXCEDE" -> "El abono no puede exceder la deuda.";
                case "CONSULTA_LIMITE" -> "Límite de consultas alcanzado.";
                default -> clave;
            };
        } else {
            return switch (clave) {
                case "ENTERO_INVALIDO" -> "You must enter a valid integer.";
                case "MONTO_INVALIDO" -> "Amount must be greater than 0.";
                case "FECHA_INVALIDA" -> "Invalid date.";
                case "PACIENTE_NO_ENCONTRADO" -> "Patient not found.";
                default -> clave;
            };
        }
    }

    // CORREGIDO: Registros.Paciente
    public static void mostrarPacienteCreado(Registros.Paciente p) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("PACIENTE CREADO CON ÉXITO", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ Expediente: " + p.expediente + " ".repeat(ANCHO - 15 - String.valueOf(p.expediente).length()) + "│");
        String nombreCompleto = p.nombre + " " + p.apellido;
        System.out.println("│ " + nombreCompleto + " ".repeat(ANCHO - 3 - nombreCompleto.length()) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    // CORREGIDO: Registros.Fecha
    public static void mostrarConsultaRegistrada(Registros.Paciente p, int exp, Registros.Fecha f, double costo, double abono, double deuda) {
        System.out.println("\n╔" + "═".repeat(ANCHO - 2) + "╗");
        System.out.println("║" + centrarTexto("CONSULTA REGISTRADA", ANCHO - 2) + "║");
        System.out.println("╠" + "═".repeat(ANCHO - 2) + "╣");
        String nombreCompleto = p.nombre + " " + p.apellido;
        System.out.println("║ Paciente: " + nombreCompleto + " ".repeat(ANCHO - 13 - nombreCompleto.length()) + "║");
        System.out.println("║ Expediente: " + exp + " ".repeat(ANCHO - 15 - String.valueOf(exp).length()) + "║");
        System.out.println("║ Fecha consulta: " + formatearFecha(f.día, f.mes, f.año) + " ".repeat(ANCHO - 19) + "║");
        System.out.println("║ Costo: " + formatearMoneda(costo) + " ".repeat(ANCHO - 10 - formatearMoneda(costo).length()) + "║");
        System.out.println("║ Pagó: " + formatearMoneda(abono) + " ".repeat(ANCHO - 9 - formatearMoneda(abono).length()) + "║");
        System.out.println("║ Deuda actual: " + formatearMoneda(deuda) + " ".repeat(ANCHO - 17 - formatearMoneda(deuda).length()) + "║");
        System.out.println("╚" + "═".repeat(ANCHO - 2) + "╝");
    }

    public static void mostrarSinDeuda() {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("SIN DEUDA PENDIENTE", ANCHO - 2) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    // CORREGIDO: Registros.Paciente
    public static void mostrarPagoRegistrado(Registros.Paciente p, double abono, double totalPagado, double deudaRestante) {
        System.out.println("\n╔" + "═".repeat(ANCHO - 2) + "╗");
        System.out.println("║" + centrarTexto("PAGO REGISTRADO", ANCHO - 2) + "║");
        System.out.println("╠" + "═".repeat(ANCHO - 2) + "╣");
        String nombreCompleto = p.nombre + " " + p.apellido;
        System.out.println("║ Paciente: " + nombreCompleto + " ".repeat(ANCHO - 13 - nombreCompleto.length()) + "║");
        System.out.println("║ Abono realizado: " + formatearMoneda(abono) + " ".repeat(ANCHO - 20 - formatearMoneda(abono).length()) + "║");
        System.out.println("║ Total pagado: " + formatearMoneda(totalPagado) + " ".repeat(ANCHO - 17 - formatearMoneda(totalPagado).length()) + "║");
        System.out.println("║ Deuda restante: " + formatearMoneda(deudaRestante) + " ".repeat(ANCHO - 19 - formatearMoneda(deudaRestante).length()) + "║");
        System.out.println("╚" + "═".repeat(ANCHO - 2) + "╝");
    }

    // CORREGIDO: Registros.Paciente y Registros.Exped
    public static void mostrarPaciente(Registros.Paciente p, Registros.Exped ep) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("DETALLE DEL PACIENTE", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ Expediente: " + p.expediente + " ".repeat(ANCHO - 15 - String.valueOf(p.expediente).length()) + "│");
        String nombreCompleto = p.nombre + " " + p.apellido;
        System.out.println("│ Nombre: " + nombreCompleto + " ".repeat(ANCHO - 10 - nombreCompleto.length()) + "│");
        System.out.println("│ Edad: " + p.edad + " años" + " ".repeat(ANCHO - 12 - String.valueOf(p.edad).length()) + "│");
        System.out.println("│ Sexo: " + p.sexo + " ".repeat(ANCHO - 10) + "│");
        String diag = p.diagnostico.length() > 50 ? p.diagnostico.substring(0, 47) + "..." : p.diagnostico;
        System.out.println("│ Diagnóstico: " + diag + " ".repeat(ANCHO - 15 - diag.length()) + "│");
        System.out.println("│ Deuda: " + formatearMoneda(ep.pendiente) + " ".repeat(ANCHO - 11 - formatearMoneda(ep.pendiente).length()) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarListaDeudores(Registros.Paciente[] pacientes, Registros.Exped[] pagos, int numPacientes) {
        System.out.println("\nFunción de deudores en desarrollo...");
    }
}