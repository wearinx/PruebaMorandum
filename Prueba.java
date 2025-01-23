import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prueba {
    public static void main(String[] args) {

        // Prueba 2.1.
        calculateImc(63, 1.73);

        // Prueba 2.2.
        System.out.println(sumaDigitos(12));
        System.out.println(sumaDigitosDeNumero(101));

        // Prueba 2.3.
        List<Object> lista = Arrays.asList(1, 3, 0, 4, 0, false, "Hola", "0", 0, 10, "Mundo", 0, 12, true);
        List<Object> resultado = moverCeros(lista);
        System.out.println(resultado);
    }

    //Funcion 2.1. Cálculo IMC
    //Creamos la función a la cual le tendremos que dar dos números para realizar el cálculo
    public static double calculateImc(double peso, double altura) {

        // Creamos una variable que contenga el cálculo
        double result = peso / (altura * altura);

        // Realizamos las comprobaciones en cada caso
        if (result <= 18.5) System.out.println(result + " = Infrapeso");
        else if (result <= 25.0) System.out.println(result + " = Normal");
        else if (result <= 30.0) System.out.println(result + " = Sobrepeso");
        else System.out.println(result + " = Obesidad");

        // Devolvemos el resultado del cálculo
        return result;
    }

    // 2.2. Suma de dígitos
    public static int sumaDigitos(int numero) {
        // Creamos una variable que contendrá la suma de los dígitos
        int suma = 0;

        // Iteramos sobre cada número desde 1 hasta N
        for (int i = 1; i <= numero; i++) {
            // Añadimos el último dígito de i a la suma
            suma += sumaDigitosDeNumero(i);
        }

        // Devolvemos la suma de los dígitos
        return suma;

    }

    // Metodo auxiliar para sumar los dígitos de un número
    public static int sumaDigitosDeNumero(int numero) {

        int suma = 0;

        while (numero > 0) {
            suma += numero % 10; // Obtener el último dígito
            numero /= 10; // Eliminar el último dígito
        }

        return suma;
    }

    // 2.3. Moviendo ceros
    // Creamos la función que nos devolverá una lista con los ceros movidos al final
    public static List<Object> moverCeros (List<Object> lista) {

        // Creamos dos listas, una que almacena no los ceros y otra que sí
        // Uso de las superclase Object para contener todos los tipos de objetos.
         List<Object> noCeros = new ArrayList<>();
         List<Object> ceros = new ArrayList<>();

         // Separamos los ceros de los demás elementos en un bucle for-each
        // Uso del bucle for-each para iterar los elementos de la lista de manera sencilla y legible
        for (Object elemento : lista) {

            // Verificamos si el elemento actual es una instancia de entero
            // Comprobamos también que en caso de que sea una cadena con un único 0 lo trate como 0
            // Si es así, se agraga a la lista de ceros.
            if ( elemento instanceof Integer && (Integer) elemento == 0 || "0".equals(elemento)) {
                ceros.add(elemento);
            } else {
                noCeros.add(elemento);
            }
        }

        // Juntamos las listas en una sola y la devolvemos
        // Primero los no ceros y luego los ceros
        noCeros.addAll(ceros);

        return noCeros;
    }
}