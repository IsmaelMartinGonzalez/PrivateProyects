package Baraja.recursos.numeros;

import java.awt.Component;
import javax.swing.JOptionPane;
/**
 * Project name: PrivateProyects/Baraja.recursos.Numeros
 * Filename: Calculo
 * Created:  21/11/2020 / 9:24
 * Description: Este objeto sirve de apollo para el objeto aleatorias. Tambien nos permite hacer calculos matematicos.
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 1.0
 */
public class Calculo {
    //Builder
    public Calculo() {
    }
    //Other Methods
    public static int factorial(int num) {
        int producto = num;

        for(int i = num - 1; i > 0; --i) {
            producto *= i;
        }

        return producto;
    }

    public static double[] ecuacion2Grado(int a, int b, int c) {
        if (Math.pow((double)b, 2.0D) - (double)(4 * a * c) >= 0.0D) {
            double[] soluciones = new double[]{((double)(-b) + Math.sqrt(Math.pow((double)b, 2.0D) - (double)(4 * a * c))) / (double)(2 * a), ((double)(-b) - Math.sqrt(Math.pow((double)b, 2.0D) - (double)(4 * a * c))) / (double)(2 * a)};
            return soluciones;
        } else {
            JOptionPane.showMessageDialog((Component)null, "La ecuacion no se puede resolver");
            return null;
        }
    }

    public static boolean esPotenciaDe(int numero, int potencia) {
        if (potencia <= 1) {
            return potencia >= 0;
        } else {
            int contador = -1;

            for(int i = numero; i > 0; i = (int)Math.floor((double)i) / potencia) {
                ++contador;
            }

            return (double)numero == Math.pow((double)potencia, (double)contador);
        }
    }

    public static int exponenteDe(int numeroFinal, int base) {
        if (base <= 1) {
            return numeroFinal != 1 && numeroFinal != 0 ? -1 : numeroFinal;
        } else {
            int contador = -1;

            for(int i = numeroFinal; i > 0; i = (int)Math.floor((double)i) / base) {
                ++contador;
            }

            return (double)numeroFinal == Math.pow((double)base, (double)contador) ? contador : -1;
        }
    }

    public static int menorDivisor(int num) {
        if (esPrimo(num)) {
            return num >= 0 ? 1 : -1;
        } else {
            int[] divisores = rellenaDivisores(num);
            return divisores[0];
        }
    }

    public static int mayorDivisor(int num) {
        if (esPrimo(num)) {
            return num >= 0 ? 1 : -1;
        } else {
            int[] divisores = rellenaDivisores(num);
            return divisores[divisores.length - 1];
        }
    }

    public static int[] rellenaDivisores(int num) {
        int[] divisor = new int[cuentaDivisores(num)];
        int i;
        int j;
        if (num >= 0) {
            i = 2;

            for(j = 0; i < num && j < divisor.length; ++i) {
                if (num % i == 0) {
                    divisor[j] = i;
                    ++j;
                }
            }
        } else {
            i = -2;

            for(j = 0; i > num && j < divisor.length; --i) {
                if (num % i == 0) {
                    divisor[j] = i;
                    ++j;
                }
            }
        }

        return divisor;
    }

    public static int cuentaDivisores(int num) {
        int contador = 0;
        int i;
        if (num >= 0) {
            for(i = 2; i < num; ++i) {
                if (num % i == 0) {
                    ++contador;
                }
            }
        } else {
            for(i = -2; i > num; --i) {
                if (num % i == 0) {
                    ++contador;
                }
            }
        }

        return contador;
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        } else {
            int contador = 0;

            for(int i = (int)Math.sqrt((double)numero); i > 1; --i) {
                if (numero % i == 0) {
                    ++contador;
                }
            }

            return contador < 1;
        }
    }

    public static int cuentaPrimosEntre(int minimo, int maximo) {
        int contador;
        if (maximo < minimo) {
            contador = minimo;
            minimo = maximo;
            maximo = contador;
        }

        contador = 0;

        for(int i = minimo; i <= maximo; ++i) {
            if (esPrimo(i)) {
                ++contador;
            }
        }

        return contador;
    }
}
