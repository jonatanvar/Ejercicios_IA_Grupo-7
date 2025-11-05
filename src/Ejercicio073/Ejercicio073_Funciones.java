package Ejercicio073;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 073 | 2025-10-16
 */
public class Ejercicio073_Funciones {

    /**
     * a. Triplica el valor pasado (una copia) y devuelve el nuevo resultado.
     * @param cuenta La copia del valor primitivo 'int'.
     * @return El valor triplicado.
     */
    public static int triplicarPorValor(int cuenta) {
        cuenta *= 3;
        return cuenta;
    }

    /**
     * b. Triplica el valor contenido en el objeto (simulación por referencia).
     * @param cuentaRef El alias (copia de la referencia) del ContenedorEntero.
     */
    public static void triplicarPorReferencia(ContenedorEntero cuentaRef) {
        // Modifica directamente el campo 'valor' del objeto original
        cuentaRef.valor *= 3;
    }
}