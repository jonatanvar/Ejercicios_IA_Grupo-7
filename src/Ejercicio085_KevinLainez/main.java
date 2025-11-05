package Ejercicio085_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 085 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #85: Lectura de Ficheros a Arreglo
 * * PROMPT:
 * Cree una librería propia para implementar una función que reciba un arreglo
 * unidireccional y un archivo para que, almacene línea por línea del archivo
 * en cada una de las posiciones del vector. El vector debe ser del tipo string.
 */
public class main {

    private static final String ARCHIVO_PRUEBA = "datos_ejercicio85.txt";
    private static final int LINEAS_ARCHIVO = 5;

    public static void main(String[] args) {

        // 1. Mostrar cuadro de bienvenida (usando la librería)
        MiLibreria.mostrarSaludo("LECTURA DE ARCHIVO A ARREGLO (STRING)");

        // 2. Preparar el entorno de prueba: Crear el archivo
        MiLibreria.crearArchivoPrueba(ARCHIVO_PRUEBA, LINEAS_ARCHIVO);

        System.out.println(MiLibreria.dibujarLineaHorizontal('┌', '┐'));
        System.out.println(MiLibreria.centrarTexto("PREPARACIÓN: Archivo '" + ARCHIVO_PRUEBA + "' creado con " + LINEAS_ARCHIVO + " líneas."));

        // 3. Crear el arreglo String con el tamaño necesario
        String[] arregloDatos = new String[LINEAS_ARCHIVO];
        System.out.println(MiLibreria.centrarTexto("Vector creado con tamaño: " + arregloDatos.length));

        // 4. Llamar a la función de la librería para realizar la lectura
        System.out.println(MiLibreria.dibujarLineaHorizontal('├', '┤'));
        System.out.println(MiLibreria.centrarTexto("EJECUTANDO: MiLibreria.leerFicheroAVector()..."));

        boolean exito = MiLibreria.leerFicheroAVector(arregloDatos, ARCHIVO_PRUEBA);

        // 5. Mostrar resultados
        if (exito) {
            System.out.println(MiLibreria.dibujarLineaHorizontal('├', '┤'));
            System.out.println(MiLibreria.centrarTexto("RESULTADO: Datos leídos del fichero y almacenados en el vector."));
            System.out.println(MiLibreria.dibujarLineaHorizontal('├', '┤'));
            System.out.println(MiLibreria.centrarTexto("Contenido del Vector:"));

            // Imprimir el contenido del vector
            for (int i = 0; i < arregloDatos.length; i++) {
                String linea = String.format("Posición [%d]: %s", i, arregloDatos[i]);
                System.out.println(MiLibreria.centrarTexto(linea));
            }

        } else {
            System.out.println(MiLibreria.dibujarLineaHorizontal('├', '┤'));
            System.out.println(MiLibreria.centrarTexto("FALLO: La lectura del fichero no pudo completarse."));
        }

        System.out.println(MiLibreria.dibujarLineaHorizontal('└', '┘'));

        // 6. Mostrar Sello y finalizar
        MiLibreria.mostrarSelloCorto("085");

        System.out.println("\n--- Programa finalizado con éxito ---");
    }
}