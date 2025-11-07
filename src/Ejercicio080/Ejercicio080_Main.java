// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #80                                                    ║
// ║ Prompt:                                                                    ║
// ║ "Modificar el programa 'Tabla' para implementar librería propia. Luego de  ║
// ║ dar la bienvenida al usuario, mostrar tabla y pedir un número entre 1 y 15,║
// ║ validar entrada y crear tabla hasta el número ingresado usando ciclos y    ║
// ║ funciones propias."                                                        ║
// ║ Fecha: 2025-11-10                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio080 | 2025-11-10

package Ejercicio080;

public class Ejercicio080_Main {

    public static void main(String[] args) {

        Ejercicio080_Menus.seleccionarIdioma();  // Selección de idioma

        boolean continuar = true;

        while (continuar) {

            boolean ejecutar = Ejercicio080_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio080_Operaciones.generarTabla();
            } else {
                continuar = false;
            }
        }
    }
}