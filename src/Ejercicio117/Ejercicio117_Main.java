// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #117                                                    ║
// ║ Prompt:                                                                     ║
// ║ "Registros: Crear registro Persona, calcular IMC, diagnóstico, copiar datos  ║
// ║ a otra persona y mostrar tabla comparativa."                                ║
// ║ Fecha: 2025-11-06                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio117 | 2025-11-06

package Ejercicio117;

public class Ejercicio117_Main {

    public static void main(String[] args) {

        Ejercicio117_Menus.seleccionarIdioma(); // Selección de idioma

        boolean continuar = true;

        while (continuar) {

            boolean ejecutar = Ejercicio117_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio117_Operaciones.registroOperacion();
            } else {
                continuar = false;
            }
        }
    }
}
