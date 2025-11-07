// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #93                                                    ║
// ║ Prompt original:                                                           ║
// ║ "Por si te quedó duda: Al programa “No estas a mi nivel humano” permitir    ║
// ║ mostrar gráficas de barras horizontales de los totales, la impresión de    ║
// ║ cada barra se hará mediante función."                                       ║
// ║ Fecha: 2025-11-06                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio093 | 2025-11-06

package Ejercicio093;

public class Ejercicio093_Main {

    public static void main(String[] args) {

        Ejercicio093_Menus.seleccionarIdioma();  // Selección de idioma

        boolean continuar = true;

        while (continuar) {

            boolean ejecutar = Ejercicio093_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio093_Operaciones.teLeoNivelHumano();
            } else {
                continuar = false;
            }
        }
    }
}