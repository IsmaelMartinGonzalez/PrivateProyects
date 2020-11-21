package Baraja.recursos.numeros;

import java.util.Arrays;
/**
 * Project name: PrivateProyects/Baraja.recursos.Numeros
 * Filename: Aleatorios
 * Created:  21/11/2020 / 9:24
 * Description: Este objeto nos permitira generar numero aleatorios.
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 1.0
 */
public class Aleatorios {
    //Constants
    public static final char[] SPECIAL_CHARTERS={'!', '%', '&', '(',')','*','/','-','#','@'};
    //Builder
    public Aleatorios(){}
    //Getters/Setters
    //Other Methods

    //Generamos un numero entero aleatorio.
    public static int generateRandomNumber(int min, int max){
        int num=(int)Math.floor(Math.random()*(double)(min-(max+1))+(double)(max+1));
        return num;
    }

    //Generamos un numero double aleatoria.
    public static double generateRandomRealNumber(int min, int max){
        double num=Math.floor(Math.random()*(double)(min-(max+1))+(double)(max+1));
        return num;
    }

    //generamos mas de un numero entero aleatorio.
    public static int[] generateRandomNumbers(int length, int min, int max){
        if (length<0){
            return null;
        }else {
            int[] numbres= new int[length];
            for (int i = 0; i < numbres.length; i++) {
                numbres[i]=generateRandomNumber(min, max);
            }
            return numbres;
        }
    }

    //Generamos numero aleatorios no repetidos.
    public static int[] generateNonRepeatingRandomNumbers(int length, int min, int max){
        if (length<0){
            return null;
        }else {
            if (max<min){
                int aux= min;
                min=max;
                max=min;
            }
            if (max-min<length-1){
                return null;
            }else {
                int[] numbers = new int[length];
                Arrays.fill(numbers, min-1);

                int i=0;
                for (boolean var5=false; i<numbers.length;++i){
                    boolean repeat;
                    int num;
                    do {
                        repeat=false;
                        num=generateRandomNumber(min, max);
                        for (int j = 0; j < numbers.length; j++) {
                            if (numbers[j]==num){
                                repeat=true;
                            }
                        }
                    }while (repeat);
                    numbers[i]=num;
                }
                return numbers;
            }
        }
    }

    //Generamos letras mayusculas aleatorias
    public static char generaLetraMayus() {
        int letra = generateRandomNumber(65, 90);
        return (char)letra;
    }

    //Generamos letras minusculas aleatoris
    public static char generaLetraMinus() {
        int letra = generateRandomNumber(97, 122);
        return (char)letra;
    }

    //Generamos caracteres especiales aleatorios.
    public static char generaLetraCaracteresEspeciales() {
        int letra = (int)Math.floor(Math.random() * (double)SPECIAL_CHARTERS.length);
        return SPECIAL_CHARTERS[letra];
    }

    //Generamos una contraseña aleatoria.
    public static String generaPassword(int longitud) {
        if (longitud <= 0) {
            return null;
        } else {
            String password = "";

            for(int i = 0; i < longitud; ++i) {
                int eleccion = (int)Math.floor(Math.random() * 4.0D);
                switch(eleccion) {
                    case 0:
                        password = password + Integer.toString(generateRandomNumber(0, 9));
                        break;
                    case 1:
                        password = password + generaLetraMayus();
                        break;
                    case 2:
                        password = password + generaLetraMinus();
                        break;
                    case 3:
                        password = password + generaLetraCaracteresEspeciales();
                }
            }

            return password;
        }
    }

    //Generamos un numero primo aleatorio
    public static int generarNumeroPrimoAzar(int minimo, int maximo) {
        if (Calculo.cuentaPrimosEntre(minimo, maximo) == 0) {
            return -1;
        } else {
            int numPrimo;
            do {
                numPrimo = generateRandomNumber(minimo, maximo);
            } while(!Calculo.esPrimo(numPrimo));

            return numPrimo;
        }
    }

    //Generamos numeros primos eentre un rango
    public static int[] generarNumerosPrimosEntre(int minimo, int maximo) {
        int[] numerosPrimos = new int[Calculo.cuentaPrimosEntre(minimo, maximo)];
        if (numerosPrimos.length == 0) {
            return null;
        } else {
            int i = minimo;

            for(int indice = 0; i < maximo; ++i) {
                if (Calculo.esPrimo(i)) {
                    numerosPrimos[indice] = i;
                    ++indice;
                }
            }

            return numerosPrimos;
        }
    }
}
