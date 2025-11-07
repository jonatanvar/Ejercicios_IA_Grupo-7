// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #121                                                    ║
// ║ Prompt:                                                                     ║
// ║ "Registro V2: Gestión de pacientes con internamiento, especialidad, cama,  ║
// ║ piso y habitación. Posibilidad de dar de alta, internar, modificar datos,  ║
// ║ y estadísticas de internos por especialidad."                               ║
// ║ Fecha: 2025-11-06                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio121 | 2025-11-06

package Ejercicio121;

public class Ejercicio121_Main {

    public static void main(String[] args) {

        Ejercicio121_Menus.seleccionarIdioma();

        boolean continuar = true;

        while (continuar) {

            boolean ejecutar = Ejercicio121_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio121_Operaciones.registroOperacion();
            } else {
                continuar = false;
            }
        }
    }
}