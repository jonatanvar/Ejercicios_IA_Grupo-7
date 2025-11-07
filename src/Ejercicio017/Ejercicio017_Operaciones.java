// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Metadatos: Dany Noguera | dany.noguera@unah.hn | 017 | 2025-11-04          ║
// ║ Resumen: Lógica matemática (pares e impresión de gráficas).                ║
// ╚════════════════════════════════════════════════════════════════════════════╝

package Ejercicio017;

public class Ejercicio017_Operaciones {

    /** Par o impar */
    public static String mensajeParidad(int n, int idioma) {
        return (idioma == 1)
                ? "El número " + n + (n % 2 == 0 ? " es PAR." : " es IMPAR.")
                : "Number " + n + (n % 2 == 0 ? " is EVEN." : " is ODD.");
    }

    /** Gráfico de 1 unidad por * */
    public static void graficaUno(int n, int idioma) {
        System.out.print("\n" + n + " | ");
        System.out.println("* ".repeat(n) + ((idioma == 1) ? "(valor 1)" : "(value 1)"));
    }

    /** Gráfico de 2 unidades por * */
    public static void graficaDos(int n, int idioma) {
        System.out.print(n + " | ");
        System.out.println("* ".repeat(n / 2) + ((idioma == 1) ? "(valor 2)" : "(value 2)"));
    }

    /** Gráfico de 5 unidades por * */
    public static void graficaCinco(int n, int idioma) {
        System.out.print(n + " | ");
        System.out.println("* ".repeat(n / 5) + ((idioma == 1) ? "(valor 5)" : "(value 5)"));
    }
}
