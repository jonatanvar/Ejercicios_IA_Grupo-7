package Ejercicio028_KevinLainez;

import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 028 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #28: Criptografía de Cuatro Dígitos (Ejercicio 4.34 Libro 1)
 * * PROMPT:
 * Su programa debe leer un entero de cuatro dígitos introducido por el usuario
 * y cifrarlo de la siguiente manera: reemplace cada dígito con (el resultado de
 * sumar 7 al dígito) módulo 10. Luego intercambie el primer dígito con el
 * tercero, e intercambie el segundo dígito con el cuarto. Después imprima el
 * entero cifrado. Escriba un programa separado que reciba como entrada un
 * entero de cuatro dígitos cifrado, y que lo descifre para formar el número original.
 */
public class main {

    public static void main(String[] args) {
        // 1. Inicializar Scanner
        Scanner sc = new Scanner(System.in);

        // 2. Mostrar cuadro de bienvenida
        utilidades.mostrarSaludo();

        // 3. Captura y validación del número original
        int original = utilidades.solicitarEnteroCuatroDigitos(sc);

        // 4. Proceso de Cifrado
        int cifrado = operaciones.cifrar(original);

        // 5. Proceso de Descifrado (simulando que el cifrado se recibió)
        // Ya que el requerimiento pide un "programa separado" que reciba el cifrado,
        // tomamos el resultado del paso 4 como la entrada a este "segundo programa".
        int descifrado = operaciones.descifrar(cifrado);

        // 6. Mostrar Resultados
        utilidades.mostrarResultados(original, cifrado, descifrado);

        // 7. Mostrar Sello y finalizar
        utilidades.mostrarSelloCorto();
        System.out.println("\n--- Programa finalizado con éxito ---");
        sc.close();
    }
}