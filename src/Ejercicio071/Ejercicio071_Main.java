// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #71 — Torres de Hanoi                                  ║
// ║ Prompt original:                                                           ║
// ║ "Busque el problema de las torres de Hanoi y copie el código en JAVA,      ║
// ║ documente las líneas y haga una salida elegante."                          ║
// ║ Fecha: 2025-11-07                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio071 | 2025-11-07

package Ejercicio071;

public class Ejercicio071_Main {

    public static void main(String[] args) {

        Ejercicio071_Menus.seleccionarIdioma();

        boolean continuar = true;

        while (continuar) {

            boolean ejecutar = Ejercicio071_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio071_Operaciones.iniciarHanoi();
            } else {
                continuar = false;
            }
        }
    }
}