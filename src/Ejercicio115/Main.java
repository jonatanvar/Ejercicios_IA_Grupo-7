/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 115 | 2025-10-27               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT COMPLETO DEL EJERCICIO #115:
 * Sistema de salud de Latveria: El hospital general de Latveria cuenta con las siguientes 4
 * especialidades:
 * a. Cirugía general.
 * b. Ginecología y obstetricia.
 * c. Medicina interna y
 * d. Nefrología.
 * Estas especialidades comparten un edificio y cada una de ellas tiene asignado un tres pisos de esta
 * forma:
 * Especialidad                             Pisos Asignados
 * Cirugía general                            2, 3, 4
 * Ginecología y obstetricia                  5, 6, 7
 * Medicina interna                           8, 9, 10
 * Nefrología                                11, 12, 13
 * Además cada uno de los pisos posee diez habitaciones las cuales
 * pueden estar libres u ocupadas.
 * Se debe hacer un programa para gestionar estas habitaciones con
 * las siguientes opciones (un menú) que sea fácil de usar para cualquiera:
 * 1. Consultar habitaciones libres por especialidad: El encargado elige la especialidad
 * y el sistema muestra por cada piso las habitaciones indicando cuales están vacías y
 * cuáles están ocupadas (no dice quién la ocupa).
 *
 * 2. Consultar habitaciones por piso: Se puede no solo ver el resumen del inciso 1 sino
 * que se debe programar la opción de poder elegir especialidad seguido de uno de los
 * tres pisos y entonces mostrar una matriz donde se vea el piso y sus habitaciones,
 * donde las habitaciones libres estarán vacías pero las ocupadas mostrarán el número
 * del expediente del paciente que la ocupa.
 *
 * 3. Asignar habitación: Poder en cualquier habitación independiente del piso y la
 * especialidad asignar un paciente, esto se logra facilitando luego del habitación el
 * número de expediente del paciente, número conformado por a lo más tres cifras.
 * Obviamente solo pueden asignarse habitaciones vacías.
 *
 * 4. Liberar habitación: Una vez que el paciente se ha dado de alta es necesario indicar
 * que la habitación queda libre para poder asignarse.
 *
 * 5. Mostrar tabla de habitaciones ocupadas:
 * Especialidad | piso | Habitación | Paciente
 * Solo usar número para las habitaciones, las especialidades saldrán con nombre y los pisos son números ordinales por lo que deberá aparecer su respectivo cardinal (usar función para obtenerla)
 *
 * Nota: Debe usar una matriz de tres dimensiones para representar el hospital con sus
 * especialidades, piso y habitaciones.
 */

package Ejercicio115;

import java.util.Scanner;
import Ejercicio115.MiLibrería;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MiLibrería.iniciarPrograma(scanner);
        scanner.close();
    }
}