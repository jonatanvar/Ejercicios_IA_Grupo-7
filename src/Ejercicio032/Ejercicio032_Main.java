// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #32                                                    ║
// ║ Prompt:                                                                    ║
// ║ "Función factorial: La función factorial se utiliza frecuentemente en los  ║
// ║ problemas de probabilidad. Utilizando la definición de factorial, escriba  ║
// ║ un programa que utilice una función for para evaluar los factoriales de    ║
// ║ los enteros del 1 al 5. Muestre los resultados en formato tabular."        ║
// ║ Fecha: 2025-11-05                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio032 | 2025-11-05

package Ejercicio032;

public class Ejercicio032_Main {

    public static void main(String[] args) {

        // Selección de idioma
        Ejercicio032_Menus.seleccionarIdioma();

        boolean continuar = true;

        // Bucle principal: permite iniciar o finalizar el programa
        while (continuar) {
            boolean ejecutar = Ejercicio032_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio032_Operaciones.calcularFactoriales();
            } else {
                continuar = false;
            }
        }
    }
}
