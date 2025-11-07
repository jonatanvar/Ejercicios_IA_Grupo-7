// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #121                                     ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio121 | 2025-11-06

package Ejercicio121;

import java.util.Scanner;

public class Ejercicio121_Operaciones {

    public static void registroOperacion() {
        Scanner sc = new Scanner(System.in);
        String idioma = Ejercicio121_Menus.obtenerIdioma();

        Ejercicio121_Utilidades.mostrarEncabezado(idioma.equals("ES") ?
                "REGISTRO DE PACIENTES" : "PATIENT REGISTRATION");

        Paciente paciente = new Paciente();
        leerDatosPaciente(paciente);

        paciente.peso = librasAKg(paciente.peso);
        paciente.estatura = cmAMetros(paciente.estatura);
        paciente.IMC = calcularIMC(paciente.peso, paciente.estatura);
        asignarDx(paciente);

        // Gestión de internamiento
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n1. Dar de alta");
            System.out.println("2. Internar");
            System.out.println("3. Salir");
            System.out.print("Seleccione opción: ");
            int op = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (op) {
                case 1:
                    darDeAlta(paciente);
                    break;
                case 2:
                    internar(paciente);
                    break;
                case 3:
                    continuar = false;
                    break;
            }
        }

        Ejercicio121_Utilidades.imprimirPaciente(paciente);
        Ejercicio121_Utilidades.mostrarSelloCorto();
        Ejercicio121_Utilidades.mostrarPie(
                idioma.equals("ES") ? "Proceso finalizado con éxito." : "Process completed successfully."
        );
    }

    public static void leerDatosPaciente(Paciente p) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese primer nombre: ");
        p.primerNombre = sc.nextLine();
        System.out.print("Ingrese primer apellido: ");
        p.primerApellido = sc.nextLine();
        System.out.print("Ingrese celular: ");
        p.celular = sc.nextLine();
        System.out.print("Ingrese sexo (0-M,1-F): ");
        p.sexo = sc.nextInt();
        System.out.print("Ingrese peso en libras: ");
        p.peso = sc.nextDouble();
        System.out.print("Ingrese estatura en cm: ");
        p.estatura = sc.nextDouble();
        p.interno = false; // Por defecto
    }

    public static double librasAKg(double libras) {
        return libras * 0.453592;
    }

    public static double cmAMetros(double cm) {
        return cm / 100.0;
    }

    public static double calcularIMC(double kg, double metros) {
        return kg / (metros * metros);
    }

    public static void asignarDx(Paciente p) {
        if (p.IMC < 18.5) p.dx = 'B'; // Bajo peso
        else if (p.IMC < 25) p.dx = 'N'; // Normopeso
        else if (p.IMC < 30) p.dx = 'S'; // Sobrepeso
        else p.dx = 'O'; // Obesidad
    }

    public static void darDeAlta(Paciente p) {
        if (p.interno) {
            p.interno = false;
            p.especialidad = "";
            p.piso = 0;
            p.habitacion = 0;
            p.cama = 0;
            System.out.println("Paciente dado de alta.");
        } else {
            System.out.println("El paciente no está internado.");
        }
    }

    public static void internar(Paciente p) {
        if (!p.interno) {
            Scanner sc = new Scanner(System.in);
            p.interno = true;
            System.out.print("Ingrese especialidad: ");
            p.especialidad = sc.nextLine();
            System.out.print("Ingrese piso: ");
            p.piso = sc.nextInt();
            System.out.print("Ingrese habitación: ");
            p.habitacion = sc.nextInt();
            System.out.print("Ingrese cama: ");
            p.cama = sc.nextInt();
            System.out.println("Paciente internado correctamente.");
        } else {
            System.out.println("El paciente ya está internado.");
        }
    }
}
