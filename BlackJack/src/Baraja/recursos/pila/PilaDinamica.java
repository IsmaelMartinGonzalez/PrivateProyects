package Baraja.recursos.pila;

/**
 * Project name: PrivateProyects/Baraja.recursos.pila
 * Filename: Pila dinamica
 * Created:  21/11/2020 / 9:25
 * Description: Esto es nuestra pila dinamica en la que tendremos un objeto auxiliar llamado Nodo.
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 1.0
 */
public class PilaDinamica<T> {
    //Attriubutes
    private Nodo<T> top; //Ultimo nodo incluido que siempre esta arriba.
    private int size;//Tamaño de la pila.

    //Builder
    public PilaDinamica(){
        top=null;//No hay elementos
        this.size=0;
    }

    //Other Methods

    //Indica si esta vacia o no la pila.
    public boolean isEmpty(){
     return top==null;
    }

    //Tamaño de la pila
    public int size(){
        return this.size;
    }

    //Muestra el primer elemento de la pila.
    public T top(){
        if (isEmpty()){
            return null;
        }else {
            return top.getElement();
        }
    }

    //Muestra el elemento de mas arriba y lo elimana de la pila
    public T pop(){
        if (isEmpty()){
            return null;
        }else{
            T elment=top.getElement();
            //Actualizamos la pila para eliminar el elemento cogido
            Nodo<T> aux= top.getNext();
            top=null;//Indicamso que lo borre.
            top=aux;//Actualizamos el top.
            this.size--;//Reducimos el tamaño de la pila.
            return elment;
        }
    }

    //Mete un elemento en la pila
    public T push(T element){
        Nodo<T> aux=new Nodo<>(element,top); //Creamos un nuevo elemento en la pila.
        top=aux; //Lo metemos en la pila al indicar que es el primero.
        this.size++; //Aumentamos el tamaño.
        return aux.getElement();
    }

    //Muestra el estado de la pila.
    public String toString() {
        if (isEmpty()){
            return "Pila vacia";
        }else{
            String result="";
            Nodo<T> aux=top;
            //Recorremos la pila hasta llegar al ultimo elemento.
            while (aux!=null){
                result+=aux.toString();
                aux=aux.getNext();
            }
            return result;
        }
    }
}
