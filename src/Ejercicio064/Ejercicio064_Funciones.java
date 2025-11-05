package Ejercicio064;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 064 | 2025-10-16
 */
public class Ejercicio064_Funciones {

    /**
     * Recibe un valor entero y devuelve el número con sus dígitos invertidos.
     * Ejemplo: 7631 -> 1367
     * @param numero El número entero a invertir.
     * @return El número invertido.
     */
    public static int invertirDigitos(int numero) {
        int numeroInvertido = 0;
        int restante = numero;

        // Ciclo while para procesar cada dígito
        while (restante != 0) {
            // 1. Obtener el último dígito (residuo de la división por 10)
            int digito = restante % 10;

            // 2. Construir el número invertido:
            // Multiplica el número invertido actual por 10 (mueve los dígitos a la izquierda)
            // y suma el nuevo dígito.
            numeroInvertido = numeroInvertido * 10 + digito;

            // 3. Eliminar el último dígito (división entera por 10)
            restante = restante / 10;
        }

        return numeroInvertido;
    }
}