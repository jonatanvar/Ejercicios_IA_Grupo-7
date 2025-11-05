package Ejercicio120;

public class ExpedientePago {
    public int expediente;
    public Consulta[] consultas;
    public int numConsultas;
    public double pagado;
    public double pendiente;

    public ExpedientePago(int exp) {
        expediente = exp;
        consultas = new Consulta[100];
        numConsultas = 0;
        pagado = 0.0;
        pendiente = 0.0;
    }
}
