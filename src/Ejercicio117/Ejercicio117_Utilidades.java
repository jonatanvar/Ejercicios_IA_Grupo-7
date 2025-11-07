// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Utilidades gráficas y estética visual                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio117 | 2025-11-06

package Ejercicio117;

public class Ejercicio117_Utilidades {

    public static void mostrarEncabezado(String titulo) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ %-60s ║\n", titulo);
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }

    public static void mostrarPie(String msg) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ %-60s ║\n", msg);
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }

    public static void mostrarSelloCorto() {
        System.out.println("\n[Dany Noguera | Ejercicio117]\n");
    }

    public static void imprimirPersona(Persona p) {
        System.out.printf("%-15s %-15s %-10s %-5s %-10.2f %-10.2f %-6.2f %-12s\n",
                p.primerNombre, p.primerApellido, p.celular,
                (p.sexo == 0 ? "M" : "F"), p.peso, p.estatura, p.IMC, diagnosticoTexto(p.dx));
    }

    public static void imprimirComparativa(Persona fuente, Persona destino) {
        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║ Persona 1                  | Persona 2                                                ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════╝");
        System.out.printf("%-15s %-15s %-10s %-5s %-10.2f %-10.2f %-6.2f %-12s | %-10s %-10s %-6.2f %-12s\n",
                fuente.primerNombre, fuente.primerApellido, fuente.celular,
                (fuente.sexo == 0 ? "M" : "F"), fuente.peso, fuente.estatura, fuente.IMC, diagnosticoTexto(fuente.dx),
                "-", "-", destino.peso, diagnosticoTexto(destino.dx));
    }

    public static String diagnosticoTexto(char dx) {
        switch (dx) {
            case 'B': return "Bajo peso";
            case 'N': return "Normopeso";
            case 'S': return "Sobrepeso";
            case 'O': return "Obesidad";
            default: return "Desconocido";
        }
    }
}
