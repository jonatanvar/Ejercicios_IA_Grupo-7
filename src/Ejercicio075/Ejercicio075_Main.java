// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #75                                                    ║
// ║ Prompt:                                                                    ║
// ║ "Usando la librería Math.h haga un programa que en forma tabular muestre   ║
// ║ los grados desde 0 a 360 y a la par su seno, coseno y tangente.            ║
// ║ Debe mostrar 50 filas por pausa y repetir encabezados tras cada pausa."    ║
// ║ Fecha: 2025-11-08                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio075 | 2025-11-08

package Ejercicio075;

public class Ejercicio075_Main {

    public static void main(String[] args) {

        // Selección de idioma
        Ejercicio075_Menus.seleccionarIdioma();

        boolean continuar = true;

        // Bucle principal: permite iniciar o finalizar el programa
        while (continuar) {
            boolean ejecutar = Ejercicio075_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio075_Operaciones.mostrarTablaTrigonometria();
            } else {
                continuar = false;
            }
        }
    }
}