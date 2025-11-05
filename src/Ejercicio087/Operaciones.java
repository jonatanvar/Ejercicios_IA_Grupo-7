/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 087 | 2025-10-28
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que gestiona un archivo de texto, permitiendo al usuario ver su contenido y agregar mensajes en nuevas líneas (Ejercicio 87).
 */

package Ejercicio_087;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Módulo Operaciones: Implementa la lógica de gestión de archivos.
 * Contiene los métodos para mostrar el contenido del archivo de mensajes
 * y agregar nuevos mensajes al final del mismo.
 */
public class Operaciones {

    private final String idioma;

    /**
     * Constructor para inicializar la clase con el idioma actual.
     * @param idioma La clave del idioma ("ES" o "EN").
     */
    public Operaciones(String idioma) {
        this.idioma = idioma;
    }

    /**
     * Muestra el contenido línea por línea del archivo de mensajes.
     */
    public void mostrarContenidoArchivo() {
        System.out.println("\n--- " + Utilidades.getTexto(idioma, "MSG_CONTENIDO_TITULO") + " ---");
        
        // Uso de try-with-resources asegura que el BufferedReader y FileReader se cierren automáticamente
        try (BufferedReader br = new BufferedReader(new FileReader(Utilidades.NOMBRE_ARCHIVO))) {
            
            String linea;
            boolean archivoVacio = true;
            
            // Leer y mostrar cada línea
            while ((linea = br.readLine()) != null) {
                System.out.println("> " + linea);
                archivoVacio = false;
            }
            
            if (archivoVacio) {
                System.out.println(Utilidades.getTexto(idioma, "MSG_ARCHIVO_VACIO"));
            }
            
        } catch (IOException e) {
            // Esto captura FileNotFoundException y otros errores de lectura
            System.out.println(Utilidades.getTexto(idioma, "ERR_LECTURA") + e.getMessage());
            System.out.println(Utilidades.getTexto(idioma, "MSG_ARCHIVO_NO_EXISTE"));
        }
        System.out.println("----------------------------------------");
    }

    /**
     * Pide un mensaje al usuario y lo anexa al archivo de texto.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    public void agregarMensaje(Scanner scanner) {
        
        System.out.print(Utilidades.getTexto(idioma, "PROMPT_MENSAJE"));
        String mensaje = scanner.nextLine().trim();
        
        if (mensaje.isEmpty()) {
            System.out.println(Utilidades.getTexto(idioma, "ERR_MENSAJE_VACIO"));
            return;
        }

        // Uso de try-with-resources. El 'true' en FileWriter indica modo de anexión (append)
        try (PrintWriter pw = new PrintWriter(
                 new BufferedWriter(
                     new FileWriter(Utilidades.NOMBRE_ARCHIVO, true)))) { 
                         
            // Escribir el mensaje seguido de un salto de línea
            pw.println(mensaje); 
            
            System.out.println(Utilidades.getTexto(idioma, "MSG_MENSAJE_AGREGADO"));
            
        } catch (IOException e) {
            // Captura errores de escritura
            System.out.println(Utilidades.getTexto(idioma, "ERR_ESCRITURA") + e.getMessage());
        }
    }
}
