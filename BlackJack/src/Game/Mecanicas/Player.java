package Game.Mecanicas;

import Game.Baraja.barajaFrance.CartaF;

import java.util.ArrayList;

/**
 * Project name: PrivateProyects/Recursos
 * Filename:
 * Created:  21/11/2020 / 9:06
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Player {
    //Attriubutes
    protected String nombre;
    protected ArrayList<CartaF> mano;
    protected int dinero;
    protected int puntos;
    protected int score;
    protected int apuesta;

    //Builder

    public Player(String nombre) {
        this.nombre = nombre;
        this.mano=new ArrayList<>();
        this.puntos=0;
        this.score=0;
        this.dinero=1000;
        this.apuesta=0;
    }
    //Getters/Setters

    public String getNombre() {
        return nombre;
    }
    public ArrayList<CartaF> getMano() {
        return mano;
    }
    public int getDinero() {
        return dinero;
    }
    public int getPuntos() {
        return puntos;
    }
    public int getScore() {
        return score;
    }
    public int getApuesta() {
        return apuesta;
    }

    //Other Methods
    public int numCartas(){
        return this.mano.size();
    }
    public void verMano(){
        System.out.println("Mano de "+nombre);
        for (int i = 0; i < numCartas(); i++) {
            CartaF tmpCarta = mano.get(i);
            System.out.println(i+". "+tmpCarta);
        }
    }
    public void pedirCarta(CartaF carata){
        this.mano.add(carata);
    }
    public int calcualrPuntos(){
        this.puntos=0;
        boolean ace=false;
        for (CartaF c:mano) {
            if (c.getValor()>10){
                c.setValor(10);
            } else if (c.getValor()==1){
                ace=true;
            }
            puntos+=c.getValor();
        }
        if (ace&&puntos+10==21){
            puntos=puntos+10;
        }
        return puntos;
    }
    public void apostar(int apuesta){
        this.apuesta+=apuesta;
        this.dinero-=apuesta;
    }
    public void doblarApuesta(){
        this.apuesta*=2;
        this.dinero-=apuesta;
    }
    @Override
    public String toString() {
        return nombre + " tiene " + dinero + "€, tu mano es " + puntos + " y tu apuesta es de " + apuesta + "€";
    }
}