// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #57                                                    ║
// ║ Prompt original:                                                           ║
// ║ "Haciendo uso de la librería Math y su función sqrt, escriba un programa   ║
// ║ que pida la longitud de ambos lados de un triángulo rectángulo y calcule   ║
// ║ la hipotenusa. Elevar números al cuadrado y obtener la hipotenusa deben    ║
// ║ ser funciones programadas por el agente."                                  ║
// ║ Fecha: 2025-11-06                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio057 | 2025-11-06

package Ejercicio057;

public class Ejercicio057_Main {

    public static void main(String[] args) {

        Ejercicio057_Menus.seleccionarIdioma();  // Selección de idioma

        boolean continuar = true;

        while (continuar) {

            boolean ejecutar = Ejercicio057_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio057_Operaciones.calcularHipotenusaTriangulo();
            } else {
                continuar = false;
            }
        }
    }
}
