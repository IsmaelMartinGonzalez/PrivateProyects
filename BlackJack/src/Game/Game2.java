package Game;

import Game.Baraja.barajaFrance.BarajaF;
import Game.Baraja.barajaFrance.CartaF;
import Game.Mecanicas.IA;
import Game.Mecanicas.Player;

import java.util.Scanner;

/**
 * Project name: PrivateProyects/Game
 * Filename: Game
 * Created:  07/12/2020 / 16:56
 * Description: Clase principal rn la que ocurrira lo necesario correspondiente al juago
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 0.1
 */
public class Game2 {
    public  Scanner sc = new Scanner(System.in);
    public  String user;
    public static   BarajaF baraja = new BarajaF();
    public  IA croupier = new IA();
    public  Player jugador;
    public boolean endRound=false;

    public void newGame() {
        System.out.println("Bienvenido al Blak Jack 2.0");
        System.out.print("Por favor introduce tu nombre: ");
        user = sc.next();
        jugador = new Player(user);
        Round();
    }
    public void Round(){
        System.out.println("-------");
        System.out.println("Tu dinero actual es " + jugador.getDinero());
        System.out.println("¿Cual es tu apuesta?");
        System.out.println("min 10 / max 1000");
        System.out.println("10, 50, 100, 500, 1000");
        do {
            System.out.print("Apuesta: ");
            user = sc.next();
        } while (!(user.equals("10") || user.equals("50") || user.equals("100") || user.equals("500") || user.equals("1000")));
        jugador.apostar(Integer.parseInt(user));
        System.out.println("Tu apuesta es " + jugador.getApuesta()+" €");
        System.out.println("Repartiendo...");
        for (int i = 0; i < 2; i++) {
            jugador.pedirCarta((CartaF) baraja.siguienteCarta(true));
        }
        jugador.verMano();
        jugador.calcualrPuntos();
        System.out.println("Puntos: " + jugador.getPuntos());
        System.out.println("-------");
        for (int i = 0; i < 2; i++) {
            croupier.pedirCarta((CartaF) baraja.siguienteCarta(true));
        }
        croupier.verManoOculta();
        /**Menu del jugador*/
        if (jugador.getPuntos()==21){
            EndRound();
        }else{
            jugador.MenuPlayer();
            /**Menu Croupier*/
            croupier.MenuIA();
            /**Comparación de los turnos y ganador*/
            EndRound();
        }
    }
    public void EndRound(){
        System.out.println("-------");
        System.out.println(jugador.toString());
        System.out.println(croupier.toString());
        if (croupier.getPuntos() > 21 && jugador.getPuntos() <= 21) {
            System.out.println("Has ganado");
            jugador.setDinero(jugador.getApuesta() * 2);
        } else if (jugador.getPuntos() < croupier.getPuntos() || jugador.getPuntos() > 21) {
            System.out.println("Has perdido");
        } else if (jugador.getPuntos() > croupier.getPuntos()) {
            System.out.println("Has ganado");
            if (jugador.isDoblar()) {
                jugador.setDinero(jugador.getApuesta() * 2);
                croupier.setDinero(-jugador.getDinero());

            } else {
                jugador.setDinero(jugador.getApuesta() * 2);
            }
        } else if (jugador.getPuntos() == croupier.getPuntos()) {
            System.out.println("Empate");
            jugador.setDinero(jugador.getApuesta());
        }
        System.out.println(jugador.toString());
        endRound=true;
    }
    public void NewRoud(){
        baraja.crearBaraja();
        baraja.barajar();

    }
}
