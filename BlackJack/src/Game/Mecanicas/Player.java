package Game.Mecanicas;

import Game.Baraja.barajaFrance.CartaF;

import java.util.ArrayList;
import java.util.Scanner;

import static Game.Game2.baraja;

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
    protected boolean doblar = false;

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
    public boolean isDoblar() {
        return doblar;
    }

    public void setDinero(int dinero) {
        this.dinero += dinero;
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
        this.dinero-=apuesta;
        this.apuesta*=2;

    }
    @Override
    public String toString() {

        return nombre + " tiene "+dinero+" €, tu mano es " + puntos + " y tu apuesta es de " + apuesta + "€";


    }
    public void MenuPlayer(){
        Scanner sc=new Scanner(System.in);
        boolean salir = false;
        int opcion;//Opcion elejida por el user
        System.out.println("-------");
        System.out.println("Turno del jugador");
        while (!salir) {
            if (doblar) {
                System.out.println("-------");
                System.out.println("¿Que deseas hacer?");
                System.out.println("Opcion 1: Pedir Carta");
                System.out.println("Opcion 2: Plantaser");
                System.out.println("Opcion 3: Rendirse");
                System.out.print("Porfavor elije una opcion: ");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> {
                        pedirCarta((CartaF) baraja.siguienteCarta(true));
                        calcualrPuntos();
                        verMano();
                        System.out.println("-------");
                        System.out.println("Puntos actuales: " + getPuntos());
                    }
                    case 2 -> {
                        calcualrPuntos();
                        salir = true;
                    }
                    case 3 -> {
                        calcualrPuntos();
                        System.out.println("-------");
                        System.out.println("Tus puntos actuales son: " + getPuntos());
                        salir = true;
                    }
                    default -> System.out.println("La opcion elejida no es correcta. Por favor elije una opcion entre 1 y 3");
                }
            } else {
                System.out.println("-------");
                System.out.println("¿Que deseas hacer?");
                System.out.println("Opcion 1: Pedir Carta");
                System.out.println("Opcion 2: Doblar");
                System.out.println("Opcion 3: Plantaser");
                System.out.println("Opcion 4: Rendirse");
                System.out.print("Porfavor elije una opcion: ");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> {
                        pedirCarta((CartaF) baraja.siguienteCarta(true));
                        calcualrPuntos();
                        verMano();
                        System.out.println("-------");
                        System.out.println("Puntos actuales: " + getPuntos());
                        doblar = true;

                    }
                    case 2 -> {
                        System.out.println("-------");
                        System.out.println("Doble o nada");
                        pedirCarta((CartaF) baraja.siguienteCarta(true));
                        doblarApuesta();
                        calcualrPuntos();
                        verMano();
                        System.out.println(toString());
                        doblar = true;
                        salir = true;
                    }
                    case 3 -> {
                        calcualrPuntos();
                        salir = true;
                    }
                    case 4 -> {
                        calcualrPuntos();
                        System.out.println("-------");
                        System.out.println("Tus puntos actuales son: " + getPuntos());
                        salir = true;
                    }
                    default -> System.out.println("La opcion elejida no es correcta. Por favor elije una opcion entre 1 y 4");
                }
            }
        }
    }


}