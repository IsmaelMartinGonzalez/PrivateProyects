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
    private Nodo<T> top;//Elemento que siempre esta arriba.
    private int size;//Tamaño de la pila.

    //Builder
    public PilaDinamica(){
        top=null;
        this.size=0;
    }

    //Other Methods

    //Is Empty: Si esta creado o no la pila.
    public boolean isEmpty(){
     return top==null;
    }

    //Tamaño de la pila
    public int size(){
        return this.size;
    }

    //Saca un elemento de la pila, muestra el contenido y lo elimana de la pila
    public T pop(){
        if (isEmpty()){
            return null;
        }else{
            T elment=top.getElement();
            //Actualizamos la pila para eliminar el elemento cogido
            Nodo<T> aux= top.getNext();
            top=null;//Al convertirlo en null elimina el elemento de la pila.,
            top=aux;
            this.size--;//Reducimos el tamaño de la pila.
            return elment;
        }
    }

    //Mete un elemento en la pila
    public void push(T element){
        Nodo<T> aux=new Nodo<>(element,top); //Creamos un nuevo elemento en la pila.
        top=aux; //Lo metemos en la pila al indicar que es el primero.
        this.size++; //Aumentamos el tamaño.
    }

    //Muestra el primer elemento de la pila.
    public T top(){
        if (isEmpty()){
            return null;
        }else {
            return top.getElement();
        }
    }

    //Muestra los elementos de la pila.
    public String toString() {
        if (isEmpty()){
            return "Pila bacia";
        }else{
            String result="";
            Nodo<T> aux=top;
            while (aux!=null){ //Recorremos la pila hasta llegar al ultimo elemento.
                result+=aux.toString();
                aux=aux.getNext();
            }
            return result;
        }
    }
}
