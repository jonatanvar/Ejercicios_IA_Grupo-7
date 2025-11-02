/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 051 | 2025-10-14               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * SUPER PRO PROMPT MODULAR AVANZADO – EJERCICIO #51
 * OBJETIVO
 * Crear un programa modular en Java que cumpla con el siguiente enunciado:
 * Figuras v3: Hacer un programa que elija entre cualquiera de las siguientes figuras:
 * Esfera, Cubo, Pirámide, Cilindro y Paralelogramo.
 * Según la figura elegida, solicitar la información necesaria para calcular área, perímetro (o volumen, si aplica).
 * Mostrar la figura seleccionada (nombre + dibujo ASCII 2D), las entradas y los resultados obtenidos.
 * FÓRMULAS
 * Usa las siguientes fórmulas correctamente en las funciones de Operaciones:
 * | Figura                        | Área          | Perímetro | Volumen  |
 * | -----------------             | -----------   | --------- | -------- |
 * | **Esfera**                    | 4πr²          | —         | (4/3)πr³ |
 * | **Cubo**                      | 6a²           | 4a        | a³       |
 * | **Pirámide**                  | a² + 2a×ap    | 4a        | (1/3)a²h |
 * | **Cilindro**                  | 2πr² + 2πrh   | 2πr       | πr²h     |
 * | **Paralelogramo**             | b×h            | 2b + 2a  | —        |
 * DIBUJOS ASCII (una cara 2D por figura)
 * Debe imprimirse centrado y dentro de un cuadro Unicode (borde ┌─┐ │ └─┘).
 * Ejemplo de representaciones simples:
 * ESFERA:
 *    * * * * *
 *  *                *
 * *                    *
 *  *                 *
 *    * * * * *
 * CUBO:
 * ┌─────────┐
 * │         │
 * │         │
 * └─────────┘
 * PIRÁMIDE:
 *     /   \
 *    /     \
 *   /_______\
 * CILINDRO:
 * ┌─────────┐
 * │         │
 * │         │
 * └─────────┘
 * PARALELOGRAMO:
 *   ______
 *  /      /
 * /______/
 * VALIDACIONES
 * Todos los valores deben ser positivos y mayores que 0.
 * Si el usuario ingresa un valor inválido → mostrar error, pedir de nuevo.
 * El programa debe permitir repetir cálculos (preguntar si desea continuar o salir).
 * No usar arreglos ni POO; usar funciones estáticas.
 * Debe respetar el uso correcto de mayúsculas, tildes y formato uniforme.
 * Cada cuadro debe tener 70 caracteres de ancho y bordes simétricos Unicode.
 * EJEMPLO DE FLUJO ESPERADO
 * ┌──────────────────────────────────────────────────────────────┐
 * │        FIGURAS V3 - CÁLCULOS DE ÁREA Y PERÍMETRO             │
 * └──────────────────────────────────────────────────────────────┘
 * Seleccione una figura:
 * 1. Esfera
 * 2. Cubo
 * 3. Pirámide
 * 4. Cilindro
 * 5. Paralelogramo
 * Ingrese su opción: 2
 * ┌───────────────────────────────────────────────────────┐
 * │                         CUBO                                                                                                                           │
 * └───────────────────────────────────────────────────────┘
 * Ingrese la medida del lado: 5
 * ┌──────────────────────────────────────────────────────┐
 * │                     RESULTADOS DEL CUBO                                                                                        │
 * ├──────────────────────────────────────────────────────┤
 * │ Área total: 150.0                                                                                                                             │
 * │ Perímetro: 20.0                                                                                                                              │
 * │ Volumen: 125.0                                                                                                                               │
 * └──────────────────────────────────────────────────────┘
 * ¿Desea realizar otro cálculo? (S/N):
 */
package Ejercicio051;

import java.util.Scanner;

public class Main {
    private static final String LINEA = "═";
    private static final int ANCHO = 70;
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Utilidades.mostrarSello();
        idiomaActual = Menús.seleccionarIdioma(scanner);

        do {
            int opcion = Menús.mostrarMenuPrincipal(scanner, idiomaActual);
            if (opcion == 1) {
                ejecutarEjercicio(scanner, idiomaActual);
                continuar = Menús.preguntarContinuar(scanner, idiomaActual);
            } else {
                Menús.mostrarDespedida(idiomaActual);
                continuar = false;
            }
        } while (continuar);

        scanner.close();
    }

    private static void ejecutarEjercicio(Scanner scanner, String idioma) {
        int figura = Operaciones.leerYValidarFigura(scanner, idioma);
        double[] datos = Operaciones.leerDatosFigura(scanner, idioma, figura);
        double area = Operaciones.calcularArea(figura, datos);
        double perimetro = Operaciones.calcularPerimetro(figura, datos);
        double volumen = Operaciones.calcularVolumen(figura, datos);
        Utilidades.mostrarFigura(figura, idioma);
        Utilidades.mostrarResultados(area, perimetro, volumen, idioma, figura);
    }
}