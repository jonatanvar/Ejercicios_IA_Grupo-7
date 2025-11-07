// ╔════════════════════════════════════════════════════════════════════════════╗
// ║                          Metadatos del Desarrollador                       ║
// ║ Nombre: Dany Noguera                                                       ║
// ║ Correo Electrónico: dany.noguera@unah.hn                                   ║
// ║ Fecha: 2025-11-04                                                          ║
// ║                                                                            ║
// ║                          Identificación del Código                         ║
// ║ Código del Ejercicio: 012                                                  ║
// ║ Enunciado: Programa que lee cinco números, los ordena de menor a mayor y   ║
// ║ dice cuántos son pares y cuántos impares.                                  ║
// ║                                                                            ║
// ║                          PROMPT USADO                                      ║
// ║ Ejercicio #12: Haremos uso del conocimiento del ejercicio "Par o impar"    ║
// ║ para hacer un programa que lea cinco números, imprima los números          ║
// ║ ordenados de menor a mayor y diga cuántos son pares y cuántos impares.     ║
// ║ Te recuerdo que en todo deben de ir el sello corto anteriormente hecho, y  ║
// ║ nuestra distribución de 3 archivos: Main, Utilidades y Operaciones.        ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | dany.noguera@unah.hn | 012 | 2025-11-04

        package Ejercicio012;
import java.util.Scanner;

public class Ejercicio012_Main {
    private static final int ANCHO = 78;

    public static void main(String[] args) {

        Ejercicio012_Utilidades.mostrarEncabezado("EJERCICIO 012 - ORDENANDO Y CONTANDO PARES/IMPARES", ANCHO);

        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[5];

        System.out.println("Ingrese cinco números enteros:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
        }

        // Lógica realizada por Operaciones.java
        int[] ordenados = Ejercicio012_Operaciones.ordenarNumeros(numeros);
        int pares = Ejercicio012_Operaciones.contarPares(numeros);
        int impares = Ejercicio012_Operaciones.contarImpares(numeros);

        Ejercicio012_Utilidades.mostrarSeparador("RESULTADOS", ANCHO);
        Ejercicio012_Utilidades.centrarTexto("Números ordenados: " + Ejercicio012_Operaciones.convertirAString(ordenados), ANCHO);
        Ejercicio012_Utilidades.centrarTexto("Cantidad de pares:   " + pares, ANCHO);
        Ejercicio012_Utilidades.centrarTexto("Cantidad de impares: " + impares, ANCHO);

        Ejercicio012_Utilidades.mostrarVersionCorta("Dany Noguera | dany.noguera@unah.hn | 012 | 2025-11-04", ANCHO);
        Ejercicio012_Utilidades.mostrarPie("¡Ejercicio completado!");
    }
}
