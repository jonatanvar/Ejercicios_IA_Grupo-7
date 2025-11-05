package Ejercicio090_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 090 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase que contiene la función para determinar si un valor ya está presente
 * en una porción de un arreglo.
 */
public class operaciones {

    /**
     * FUNCIÓN CLAVE: No permite ingresar valores repetidos.
     * Busca un valor específico dentro de los elementos válidos ya almacenados en el arreglo.
     * * @param arreglo El arreglo donde se realiza la búsqueda.
     * @param nuevoValor El valor que se desea verificar.
     * @param limite El número de elementos ya válidos en el arreglo (hasta dónde buscar).
     * @return true si el nuevoValor ya existe en el arreglo[0] a arreglo[limite-1], false si es único.
     */
    public static boolean contieneRepetido(int[] arreglo, int nuevoValor, int limite) {
        // Itera solo sobre los elementos que ya han sido ingresados (hasta el límite)
        for (int i = 0; i < limite; i++) {
            if (arreglo[i] == nuevoValor) {
                return true; // ¡Valor repetido encontrado!
            }
        }
        return false; // El valor es único
    }
}