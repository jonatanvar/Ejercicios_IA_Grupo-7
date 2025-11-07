// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #37                                                    ║
// ║ Prompt:                                                                    ║
// ║ "Día de pago: Una empresa paga a sus empleados como gerentes (salario      ║
// ║ fijo semanal), trabajadores por horas (pago fijo por hora + tiempo y medio ║
// ║ en horas extra), empleados por comisión ($250 + 5.7% de ventas), y         ║
// ║ trabajadores por piezas (pago fijo por pieza producida). El programa debe  ║
// ║ calcular el sueldo semanal según el código de pago del empleado usando     ║
// ║ una instrucción switch."                                                   ║
// ║ Fecha: 2025-11-05                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio037 | 2025-11-05

package Ejercicio037;

public class Ejercicio037_Main {
    public static void main(String[] args) {

        // Selección de idioma
        Ejercicio037_Menus.seleccionarIdioma();

        boolean continuar = true;

        while (continuar) {
            boolean ejecutar = Ejercicio037_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio037_Operaciones.calcularSueldo();
            } else {
                continuar = false;
            }
        }
    }
}