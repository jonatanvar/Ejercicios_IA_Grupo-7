/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 079 | 2025-10-22               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Agente empecemos con la nueva sección de ejercicios, en lo que
 * hagamos ahora en adelante deberán de tener la nueva funciones
 * propias ciclos propios y librerías propias, junto con los parámetros
 *  anteriores ahora nuestro sistema de archivos se actualizara de esta forma:
 * Ejercicio ###
 * ├── Ejercicio###_Main.java
 * └── MiLibreria.java ← Contiene TODO (ciclos, funciones y librerías propias)
 * Un ejemplo de las funciones que hemos usado que deberán de ir
 * Funciones matemáticas
 * Funciones de procesamiento
 * Validaciones
 * Formato de texto
 * Procesamiento de datos
 * Selección de idioma de preferencia
 * Formato de salida elegante como en los demás
 * Y todas las que creas necesarias, ahora con esto vamos a nuestro ejercicio,
 *  que es curioso porque uno depende del otro y ese otro a la vez depende de
 * otro, a continuación desarrollo lo que te digo. Nuestro ejercicio el #79 Modifique
 *  el programa del ejercicio “Cripto-funciones” para implementar una librería propia.
 * Y el ejercicio “Cripto-funciones” es este: Cripto-funciones: Tomaremos como base el
 * ejercicio “Criptografía” de esta guía, vamos ahora a hacer que codificar y decodificar
 *  sean funciones.
 * Ese ejercicio como lo vez depende de otro, que es este:
 * Criptografía: Una compañía desea transmitir datos a través del teléfono,
 *  pero le preocupa que sus teléfonos puedan estar intervenidos. Todos los
 * datos se transmiten como enteros de cuatro dígitos. La compañía le ha pedido
 * a usted que escriba un programa que cifre sus datos, de manera que éstos puedan
 * transmitirse con más seguridad. Su programa debe leer un entero de cuatro dígitos
 * introducido por el usuario y cifrarlo de la siguiente manera: reemplace cada dígito con (el resultado
 * de sumar 7 al dígito) módulo 10. Luego intercambie el primer dígito con el
 * tercero, e intercambie el segundo dígito con el cuarto. Después imprima el
 * entero cifrado. Escriba un programa separado que reciba como entrada un entero
 * de cuatro dígitos cifrado, y que lo descifre para formar el número original.
 */

package Ejercicio079;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Librerias.MiLibrería.iniciarPrograma(scanner);
        scanner.close();
    }
}