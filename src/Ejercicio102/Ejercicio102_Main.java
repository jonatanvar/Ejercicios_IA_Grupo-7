// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #102                                                   ║
// ║ Prompt:                                                                    ║
// ║ "Una dimensión: Use un arreglo unidimensional para resolver el siguiente   ║
// ║ problema. Recibir como entrada 20 números entre 10 y 100. Validarlos y     ║
// ║ almacenarlos solo si no es un duplicado. Al final, mostrar únicamente los  ║
// ║ números únicos ingresados, usando el arreglo más pequeño posible."         ║
// ║ Fecha: 2025-11-06                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio102 | 2025-11-06

package Ejercicio102;

public class Ejercicio102_Main {

    public static void main(String[] args) {

        Ejercicio102_Menus.seleccionarIdioma(); // Selección de idioma

        boolean continuar = true;

        while (continuar) {

            boolean ejecutar = Ejercicio102_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio102_Operaciones.procesarNumeros();
            } else {
                continuar = false;
            }
        }
    }
}