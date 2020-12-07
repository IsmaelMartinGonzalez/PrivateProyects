package Game;

import Game.Baraja.barajaFrance.BarajaF;
import Game.Baraja.barajaFrance.CartaF;
import Game.Mecanicas.IA;
import Game.Mecanicas.Player;
import java.util.Scanner;

/**
 * Project name: PrivateProyects/Game
 * Filename:
 * Created:  07/12/2020 / 16:56
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Game {
    public static void newGame() {
         Scanner sc = new Scanner(System.in);
         BarajaF baraja = new BarajaF();
         IA croupier = new IA();
         String user;
        System.out.println("Bienvenido al Blak Jack");
        System.out.print("Por favor introduce tu nombre: ");
        user=sc.next();
        Player jugador = new Player(user);
        for (int i = 0; i < 2; i++) {
            jugador.pedirCarta((CartaF) baraja.siguienteCarta(true));
        }
        jugador.verMano();
        jugador.calcualrPuntos();
        System.out.println("-------");
        for (int i = 0; i < 2; i++) {
            croupier.pedirCarta((CartaF) baraja.siguienteCarta(true));
        }
        croupier.verManoOculta();
        /**Menu del jugador*/
        System.out.println("-------");
        System.out.println("Turno del jugador");
        boolean salir = false;
        int opcion;//Opcion elejida por el user
        while (!salir){
            System.out.println("¿Que deseas hacer?");
            System.out.println("Opcion 1: Apostar");
            System.out.println("Opcion 2: Pedir Carta");
            System.out.println("Opcion 3: Doblar");
            System.out.println("Opcion 4: Ver puntos");
            System.out.println("Opcion 5: Plantaser");
            System.out.print("Porfavor elije una opcion: ");
            opcion=sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    int apuesta;
                    System.out.println("¿Cuanto desea apostar?");
                    System.out.print("Apuesta: ");
                    apuesta=sc.nextInt();
                    jugador.apostar(apuesta);
                    jugador.calcualrPuntos();
                    System.out.println(jugador.toString());
                }
                case 2 -> {
                    jugador.pedirCarta((CartaF) baraja.siguienteCarta(true));
                    jugador.calcualrPuntos();
                    jugador.verMano();
                    System.out.println("Puntos actuales: "+jugador.getPuntos());
                }
                case 3 -> {
                    System.out.println("Apuesta Doblada");
                    jugador.calcualrPuntos();
                    jugador.doblarApuesta();
                    System.out.println(jugador.toString());
                }
                case 4 -> {
                    jugador.calcualrPuntos();
                    System.out.println("Tus puntos actuales son: "+ jugador.getPuntos());
                }
                case 5->{
                    jugador.calcualrPuntos();
                    salir=true;
                }
                default -> System.out.println("La opcion elejida no es correcta. Por favor elije una opcion entre 1 y 5");
            }
        }
        /**Menu Croupier*/
        System.out.println("-------");
        System.out.println("Turno del Croupier");
        croupier.verMano();
        croupier.calcualrPuntos();
        System.out.println("Puntos del croupier " +croupier.getPuntos());
        while (croupier.getPuntos()<17&&croupier.getPuntos()<21){
            System.out.println("-------");
            croupier.pedirCarta((CartaF) baraja.siguienteCarta(true));
            croupier.verMano();
            croupier.calcualrPuntos();
            System.out.println("Puntos del croupier " +croupier.getPuntos());
        }
        /**Comparación de los turnos y ganador*/
        System.out.println("-------");
        System.out.println(jugador.toString());
        System.out.println(croupier.toString());

    }
}
