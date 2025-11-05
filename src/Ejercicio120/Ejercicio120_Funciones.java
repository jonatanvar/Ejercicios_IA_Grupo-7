package Ejercicio120;

public class Ejercicio120_Funciones {

    public static Paciente[] inicializarPacientes() { return new Paciente[200]; }
    public static ExpedientePago[] inicializarExpedientes() { return new ExpedientePago[200]; }

    public static int buscarPaciente(Paciente[] pacientes, int exp, int numPac) {
        for (int i = 0; i < numPac; i++)
            if (pacientes[i].expediente == exp) return i;
        return -1;
    }

    public static int obtenerIndiceExpediente(ExpedientePago[] expPag, int exp, int numExp) {
        for (int i = 0; i < numExp; i++)
            if (expPag[i].expediente == exp) return i;
        expPag[numExp] = new ExpedientePago(exp);
        return numExp;
    }

    public static void registrarConsulta(ExpedientePago ep, int año, int mes, int día, double valor, double pago) {
        if (ep.numConsultas >= 100) return;
        ep.consultas[ep.numConsultas] = new Consulta(año, mes, día, valor, pago);
        ep.numConsultas++;
        ep.pagado += pago;
        ep.pendiente += (valor - pago);
    }

    public static void abonarDeuda(ExpedientePago ep, double monto) {
        if (monto <= 0) return;
        double resto = ep.pendiente - monto;
        ep.pendiente = Math.max(0, resto);
        ep.pagado += Math.min(monto, ep.pendiente + monto);
    }

    public static void ordenarDeudores(ExpedientePago[] expPag, int numExp) {
        for (int i = 0; i < numExp - 1; i++) {
            for (int j = i + 1; j < numExp; j++) {
                if (expPag[i].pendiente < expPag[j].pendiente) {
                    ExpedientePago tmp = expPag[i];
                    expPag[i] = expPag[j];
                    expPag[j] = tmp;
                }
            }
        }
    }
}