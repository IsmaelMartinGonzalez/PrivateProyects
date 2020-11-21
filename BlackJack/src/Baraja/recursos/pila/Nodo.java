package Baraja.recursos.pila;

/**
 * Project name: PrivateProyects/Baraja.recursos.pila
 * Filename: Nodo
 * Created:  21/11/2020 / 9:25
 * Description: Este es el elemnto auxiliar de nuestra pila dinamica
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 1.0
 */
public class Nodo<T> {
    //Attriubutes
    private T element;
    private Nodo<T>next;//Apunta al siguiente nodo.
    //Builder
    public Nodo(T element, Nodo<T> next){
        this.element=element;
        this.next=next;
    }
    //Getters/Setters
    public Nodo<T> getNext() {
        return next;
    }
    public void setNext(Nodo<T> next) {
        this.next = next;
    }
    public T getElement() {
        return element;
    }
    public void setElement(T element) {
        this.element = element;
    }
    //Other Methods

    @Override
    public String toString() {
        return element+"\n";
    }
}
