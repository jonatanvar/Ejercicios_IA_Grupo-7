// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #117                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio117 | 2025-11-06

package Ejercicio117;

import java.util.Scanner;

public class Ejercicio117_Operaciones {

    public static void registroOperacion() {

        Scanner sc = new Scanner(System.in);
        String idioma = Ejercicio117_Menus.obtenerIdioma();

        Ejercicio117_Utilidades.mostrarEncabezado(idioma.equals("ES") ? "REGISTRO DE PERSONAS" : "PERSON REGISTRATION");

        Persona persona1 = new Persona();
        Persona persona2 = new Persona();

        // Lectura de datos persona1
        System.out.print("Primer nombre: ");
        persona1.primerNombre = sc.nextLine();

        System.out.print("Primer apellido: ");
        persona1.primerApellido = sc.nextLine();

        System.out.print("Celular: ");
        persona1.celular = sc.nextLine();

        do {
            System.out.print("Sexo (0=M, 1=F): ");
            persona1.sexo = sc.nextInt();
        } while (persona1.sexo != 0 && persona1.sexo != 1);

        System.out.print("Peso (libras): ");
        persona1.peso = sc.nextDouble();

        System.out.print("Estatura (cm): ");
        persona1.estatura = sc.nextDouble();

        // Conversion y cálculo
        persona1.peso = librasAKg(persona1.peso);
        persona1.estatura = cmAMetros(persona1.estatura);
        persona1.IMC = calcularIMC(persona1.peso, persona1.estatura);

        asignarDx(persona1);

        // Copiar persona1 a persona2 y ajustar si no es Normopeso
        copiarPersona(persona1, persona2);

        // Mostrar información
        System.out.println("\nInformación Persona 1:");
        Ejercicio117_Utilidades.imprimirPersona(persona1);

        System.out.println("\nComparativa Persona 1 vs Persona 2:");
        Ejercicio117_Utilidades.imprimirComparativa(persona1, persona2);

        Ejercicio117_Utilidades.mostrarSelloCorto();
        Ejercicio117_Utilidades.mostrarPie("Proceso finalizado con éxito.");

        sc.close();
    }

    public static double librasAKg(double lb) {
        return lb * 0.453592;
    }

    public static double cmAMetros(double cm) {
        return cm / 100.0;
    }

    public static double calcularIMC(double kg, double m) {
        return kg / (m * m);
    }

    public static void asignarDx(Persona p) {
        if (p.IMC < 18.5) p.dx = 'B';
        else if (p.IMC < 25) p.dx = 'N';
        else if (p.IMC < 30) p.dx = 'S';
        else p.dx = 'O';
    }

    public static void copiarPersona(Persona fuente, Persona destino) {
        destino.primerNombre = "-";
        destino.primerApellido = "-";
        destino.celular = fuente.celular;
        destino.sexo = fuente.sexo;

        if (fuente.dx != 'N') {
            destino.IMC = 22.9;
            destino.estatura = fuente.estatura;
            destino.peso = destino.IMC * (destino.estatura * destino.estatura);
            asignarDx(destino);
        } else {
            destino.IMC = fuente.IMC;
            destino.estatura = fuente.estatura;
            destino.peso = fuente.peso;
            destino.dx = fuente.dx;
        }
    }
}
