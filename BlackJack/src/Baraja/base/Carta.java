package Baraja.base;

/**
 * Project name: PrivateProyects/Recursos
 * Filename: Carta
 * Created:  21/11/2020 / 9:06
 * Description: Este objeto auxilia a baraja para generar las barajas, tambien sirve como objeto padre para generar
 *              distintos tipos de cartas.
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 1.0
 */
public class Carta<T> {
    //Attriubutes
    protected int valor;
    protected T tipo;
    //Builder
    public Carta(int valor, T palo){
        this.valor=valor;
        this.tipo=palo;
    }
    public Carta(){}
    //Getters/Setters
    public int getValor() {
        return valor;
    }
    public T getTipo() {
        return tipo;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
