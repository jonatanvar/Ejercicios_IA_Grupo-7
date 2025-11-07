// ╔════════════════════════════════════════════════════════════════════════════╗
// ║                          Metadatos del Desarrollador                       ║
// ║ Nombre: Dany Noguera                                                       ║
// ║ Correo Electrónico: dany.noguera@unah.hn                                   ║
// ║ Fecha: 2025-11-04                                                          ║
// ║                                                                            ║
// ║                          Identificación del Código                         ║
// ║ Código del Ejercicio: 007                                                  ║
// ║ Enunciado: Jugando con tres números: Escriba un programa que reciba tres   ║
// ║ enteros del teclado e imprima la suma, promedio, producto, menor y mayor   ║
// ║ de esos números.                                                           ║
// ║                                                                            ║
// ║                          Análisis/Resumen                                  ║
// ║ Programa estructurado que solicita tres enteros, calcula operaciones       ║
// ║ básicas y las muestra con formato elegante usando bordes Unicode.          ║
// ║ Reutiliza Utilidades para estética y Operaciones para lógica matemática.   ║
// ║                                                                            ║
// ║                          PROMPT USADO                                      ║
// ║ Agente necesito que realicemos el ejercicio #7, te recuerdo que en todo    ║
// ║ deben de ir el sello anteriormente hecho, y nuestra distribución de 3      ║
// ║ archivos: Ejercicio###_Main.java (prompt), _Utilidades.java (cuadros) y    ║
// ║ _Operaciones.java (lógica matemática).                                     ║
// ╚════════════════════════════════════════════════════════════════════════════╝

package Ejercicio007;

import java.util.Scanner;

public class Ejercicio007_Main {
    private static final int ANCHO = 78;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Ejercicio007_Utilidades.mostrarEncabezado("EJERCICIO 007 - JUGANDO CON TRES NÚMEROS", ANCHO);

        System.out.println("Ingrese tres enteros:");
        System.out.print("primer entero: ");
        int n1 = sc.nextInt();
        System.out.print("segundo entero: ");
        int n2 = sc.nextInt();
        System.out.print("tercer entero: ");
        int n3 = sc.nextInt();

        // Lógica en archivo separado
        int suma = Ejercicio007_Operaciones.suma(n1, n2, n3);
        double promedio = Ejercicio007_Operaciones.promedio(n1, n2, n3);
        int producto = Ejercicio007_Operaciones.producto(n1, n2, n3);
        int menor = Ejercicio007_Operaciones.menor(n1, n2, n3);
        int mayor = Ejercicio007_Operaciones.mayor(n1, n2, n3);

        // Resultados con formato elegante
        Ejercicio007_Utilidades.mostrarSeparador("RESULTADOS", ANCHO);
        Ejercicio007_Utilidades.centrarTexto("Suma:        " + suma, ANCHO);
        Ejercicio007_Utilidades.centrarTexto("Promedio:    " + String.format("%.2f", promedio), ANCHO);
        Ejercicio007_Utilidades.centrarTexto("Producto:    " + producto, ANCHO);
        Ejercicio007_Utilidades.centrarTexto("Menor:       " + menor, ANCHO);
        Ejercicio007_Utilidades.centrarTexto("Mayor:       " + mayor, ANCHO);

        Ejercicio007_Utilidades.mostrarVersionCorta("Dany Noguera | dany.noguera@unah.hn | 007 | 2025-11-04", ANCHO);
    }
}