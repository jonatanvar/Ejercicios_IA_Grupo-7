// ╔═══════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                        ║
// ║ Proyecto: Ejercicio #106                                                  ║
// ║ Prompt:                                                                    ║
// ║ "Como el que vende pollos que está en todos lados:                        ║
// ║  Hay una tienda con cinco sucursales, se requiere un programa que imple-  ║
// ║  mente un arreglo para lo siguiente:                                      ║
// ║  a) Leer ventas por día (lunes a sábado) de cada sucursal.               ║
// ║  b) Usar función para imprimir matriz.                                    ║
// ║  c) Crear matriz con ventas semanales y totales diarios.                  ║
// ║  d) La función del inciso b debe poder imprimir esta nueva matriz.        ║
// ║ Fecha: 2025-11-06                                                         ║
// ╚═══════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio106 | 2025-11-06

package Ejercicio106;

public class Ejercicio106_Main {
    public static void main(String[] args) {

        Ejercicio106_Menus.seleccionarIdioma();

        boolean continuar = true;

        while (continuar) {
            boolean ejecutar = Ejercicio106_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio106_Operaciones.procesarVentas();
            } else {
                continuar = false;
            }
        }
    }
}