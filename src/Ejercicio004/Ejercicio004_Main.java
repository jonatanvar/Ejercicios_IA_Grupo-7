package Ejercicio004; // PAQUETE CORRECTO

public class Ejercicio004_Main {
    public static void main(String[] args) {
        /*
         * Cristina Cruz | Lis10 | cristinacruz@unah.hn | 004 | 2025-10-10
         */

        // ELIMINAR O COMENTAR LA LÍNEA INVÁLIDA:
        // package Ejercicio_2_Lis

        Ejercicio004_Utilidades.mostrarSelloCorto("004", "2025-10-10");

        double numero1 = Ejercicio004_Utilidades.leerNumero("Ingrese el primer número: ");
        double numero2 = Ejercicio004_Utilidades.leerNumero("Ingrese el segundo número: ");

        double suma = Ejercicio004_Operaciones.calcularSuma(numero1, numero2);
        double producto = Ejercicio004_Operaciones.calcularProducto(numero1, numero2);
        double diferencia = Ejercicio004_Operaciones.calcularDiferencia(numero1, numero2);
        double cociente = Ejercicio004_Operaciones.calcularCociente(numero1, numero2);

        Ejercicio004_Utilidades.mostrarResultados(numero1, numero2, suma, producto, diferencia, cociente);
    } // Cierre del método main
} // Cierre de la clase Ejercicio004_Main