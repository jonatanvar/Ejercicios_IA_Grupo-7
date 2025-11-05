package Ejercicio034;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 034 | 2025-10-15
 */
public class Ejercicio034_Operaciones {

    /**
     * Usa una instrucción switch para determinar el precio de venta de un producto.
     * @param numeroProducto El número de identificación del producto (1-5).
     * @return El precio de venta del producto, o 0.0 si el número es inválido.
     */
    public static double obtenerPrecio(int numeroProducto) {
        double precio = 0.0;

        switch (numeroProducto) {
            case 1:
                precio = 2.98;
                break;
            case 2:
                precio = 4.50;
                break;
            case 3:
                precio = 9.98;
                break;
            case 4:
                precio = 4.49;
                break;
            case 5:
                precio = 6.87;
                break;
            default:
                precio = 0.0;
                break;
        }
        return precio;
    }
}