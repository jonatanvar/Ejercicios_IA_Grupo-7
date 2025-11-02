/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 101 | 2025-10-26               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Agente el ejercicio #101 nos corresponde hacer, siempre usa los parametros de los ejercicos hechos anteriormente, solo que este ejercicio es la modificacion de otro, te daré el contexto necesario para realizarlo y lo analizas y despues lo haces.
 *
 * Convirtiendo a burbuja en Bellota: El programa “ordenamiento de burbuja”  que es este ejercicio {: En el ordenamiento de burbuja, los valores más pequeños van
 * “subiendo como burbujas” gradualmente, hasta llegar a la parte superior del arreglo (es decir, hacia el primer elemento) como las burbujas de aire que se elevan en el agua, mientras que los valores más grandes se hunden en el fondo. Esta técnica realiza varias pasadas a través del arreglo. En cada pasada compara pares sucesivos de elementos. Si un par se encuentra en orden ascendente (o los valores son idénticos), el ordenamiento de burbuja deja los valores como están. Si un par se encuentra en orden descendente, el ordenamiento de burbuja intercambia sus valores en el arreglo. Escriba un programa que ordene un arreglo de 10 enteros mediante el uso del uso del ordenamiento de burbuja. EL usuario ingresa los 10 elementos.}
 *
 * A ese ejercicio debes hacer la siguientes modificaciones:
 * En el ordenamiento de burbuja, los valores más pequeños van
 * “subiendo como burbujas” gradualmente, hasta llegar a la parte superior del arreglo (es decir, hacia el primer elemento) como las burbujas de aire que se elevan en el agua, mientras que los valores más grandes se hunden en el fondo. Esta técnica realiza varias pasadas a través del arreglo. En cada pasada compara pares sucesivos de elementos. Si un par se encuentra en orden ascendente (o los valores son idénticos), el ordenamiento de burbuja deja los valores como están. Si un par se encuentra en orden descendente, el ordenamiento de burbuja intercambia sus valores en el arreglo. Escriba un programa que ordene un arreglo de 10 enteros mediante el uso del ordenamiento de burbuja. EL usuario ingresa los 10 elementos.
 *
 * a. Después de la primera pasada, se garantiza que el número más grande estará en el
 * elemento con la numeración más alta del arreglo; después de la segunda pasada, los
 * dos números más altos estarán “acomodados”, y así en lo sucesivo. En lugar de
 * realizar nueve comparaciones en cada pasada, modifi que el ordenamiento de burbuja
 * para que realice ocho comparaciones en la segunda pasada, siete en la tercera, y así
 * en lo sucesivo.
 * b. Los datos en el arreglo tal vez se encuentren ya en el orden apropiado, o casi
 * apropiado, así que ¿para qué realizar nueve pasadas, si basta con menos? Modifique
 * el ordenamiento para comprobar al final de cada pasada si se han realizado
 * intercambios. Si no se ha realizado ninguno, los datos ya deben estar en el orden
 * apropiado, por lo que el programa debe terminar. Si se han realizado intercambios,
 * por lo menos se necesita una pasada más.
 * Para probarlo crear un vector de 50 posiciones que se llene de manera aleatoria obviamente mostrar el vector antes y después de aplicar el ordenamiento.
 *
 * Todo de manera ordenada, que des una explicación de las comparaciones que haces, siempre muestra la salida en un cuadro simétrico al usuario, usando siempre nuestro sistema de archivos.
 */

package Ejercicio101;

import java.util.Scanner;
import Ejercicio101.MiLibrería;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MiLibrería.iniciarPrograma(scanner);
        scanner.close();
    }
}