package Ejercicio018_KevinLainez;

import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 018 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #18: Consumo de Gasolina (Ejercicio 4.13 Libro 1)
 * * PROMPT:
 * Desarrolle un programa en JAVA que utilice una instrucción while para
 * recibir como entrada los kilómetros conducidos y los litros usados (ambos
 * como enteros) por cada reabastecimiento. El programa debe calcular y mostrar
 * los kilómetros por litro obtenidos en cada reabastecimiento, y debe imprimir
 * el total de kilómetros por litro obtenidos en todos los reabastecimientos
 * hasta este punto.
 */
public class main {

    public static void main(String[] args) {
        // 1. Inicializar Scanner y la clase de Operaciones
        Scanner sc = new Scanner(System.in);
        // Instanciamos operaciones para mantener el estado de los totales
        operaciones contadorConsumo = new operaciones();

        int kilometros = 0;
        int litros = 0;
        int reabastecimientoContador = 0;

        // 2. Mostrar cuadro de bienvenida e instrucciones
        utilidades.mostrarSaludo();

        // 3. Bucle de entrada y procesamiento
        System.out.println(utilidades.dibujarLineaHorizontal('┌', '┐'));
        System.out.println(utilidades.centrarTexto("INICIO DE REGISTRO DE REABASTECIMIENTOS"));

        // Primera solicitud de kilómetros antes del bucle while (Lógica centinela)
        System.out.println(utilidades.dibujarLineaHorizontal('├', '┤'));
        kilometros = utilidades.solicitarValor(sc, "Kilómetros recorridos (o -1 para terminar):");

        while (kilometros != -1) {
            // Verificar si el usuario ingresó -1 ya que se vuelve a pedir la entrada dentro del bucle.
            if (kilometros == -1) break;

            // Solicitar litros
            litros = utilidades.solicitarValor(sc, "Litros usados:");

            // 4. Procesamiento
            reabastecimientoContador++;

            // Calcular KPL actual
            double kplActual = operaciones.calcularKPLReabastecimiento(kilometros, litros);

            // Acumular totales
            contadorConsumo.agregarReabastecimiento(kilometros, litros);
            double kplTotalAcumulado = contadorConsumo.calcularKPLTotal();

            // 5. Mostrar resultados parciales
            utilidades.mostrarResultadosParciales(reabastecimientoContador, kplActual, kplTotalAcumulado);

            // 6. Solicitar la siguiente entrada para la condición del bucle
            System.out.println(utilidades.dibujarLineaHorizontal('├', '┤'));
            kilometros = utilidades.solicitarValor(sc, "Siguientes kilómetros (o -1 para terminar):");
        }

        // Cierre del cuadro de ingresos (ya que el bucle terminó)
        System.out.println(utilidades.dibujarLineaHorizontal('└', '┘'));

        // 7. Mostrar Resumen Final
        if (reabastecimientoContador > 0) {
            utilidades.mostrarResumenFinal(
                    contadorConsumo.calcularKPLTotal(),
                    contadorConsumo.getTotalKilometros(),
                    contadorConsumo.getTotalLitros()
            );
        } else {
            System.out.println(utilidades.dibujarLineaHorizontal('┌', '┐'));
            System.out.println(utilidades.centrarTexto("No se registraron reabastecimientos."));
            System.out.println(utilidades.dibujarLineaHorizontal('└', '┘'));
        }

        // 8. Mostrar Sello y finalizar
        utilidades.mostrarSelloCorto();
        System.out.println("\n--- Programa finalizado con éxito ---");
        sc.close();
    }
}