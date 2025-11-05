package Ejercicio009;

    /**
     * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 009 | 2025-10-15
     * Propósito: Contiene la lógica para calcular el diámetro, la circunferencia y el área de un círculo.
     */
    public class Ejercicio009_Operaciones {

        public static final double PI = 3.14159;

        /**
         * Calcula el diámetro de un círculo.
         * @param radio El radio del círculo.
         * @return El diámetro.
         */
        public static double calcularDiametro(int radio) {
            return 2 * radio;
        }

        /**
         * Calcula la circunferencia de un círculo.
         * @param radio El radio del círculo.
         * @return La circunferencia.
         */
        public static double calcularCircunferencia(int radio) {
            return 2 * PI * radio;
        }

        /**
         * Calcula el área de un círculo.
         * @param radio El radio del círculo.
         * @return El área.
         */
        public static double calcularArea(int radio) {
            return PI * radio * radio;
        }
    }

