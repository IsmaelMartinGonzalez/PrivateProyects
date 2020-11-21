import Baraja.recursos.pila.*;
/**
 * Project name: PrivateProyects/PACKAGE_NAME
 * Filename:
 * Created:  21/11/2020 / 11:19
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Main {
    public static void main(String[] args) {
        PilaDinamica<Integer> pilaNumeros = new PilaDinamica<>();
        System.out.println(pilaNumeros);
        pilaNumeros.push(5);
        pilaNumeros.push(10);
        pilaNumeros.push(15);
        pilaNumeros.push(20);
        System.out.println(pilaNumeros.size());
        System.out.println(pilaNumeros.top());
        int elment = pilaNumeros.pop();
        System.out.println(elment);
        System.out.println(pilaNumeros.size());
        System.out.println(pilaNumeros);
    }
}
