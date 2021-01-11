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
public class Game {
    public static Scanner sc = new Scanner(System.in);
    public static String user;
    public static BarajaF baraja = new BarajaF();
    public static IA croupier = new IA();
    public static Player jugador;

    public static void newGame() {
        System.out.println("Bienvenido al Blak Jack");
        System.out.print("Por favor introduce tu nombre: ");
        user = sc.next();
        jugador = new Player(user);
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
        System.out.println("Tu apuesta es " + jugador.getApuesta());
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
        /**Menu del jugador*/
        System.out.println("-------");
        System.out.println("Turno del jugador");
        boolean salir = false;
        int opcion;//Opcion elejida por el user
        boolean doblar = false;
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
                        jugador.pedirCarta((CartaF) baraja.siguienteCarta(true));
                        jugador.calcualrPuntos();
                        jugador.verMano();
                        System.out.println("-------");
                        System.out.println("Puntos actuales: " + jugador.getPuntos());
                    }
                    case 2 -> {
                        jugador.calcualrPuntos();
                        salir = true;
                    }
                    case 3 -> {
                        jugador.calcualrPuntos();
                        System.out.println("-------");
                        System.out.println("Tus puntos actuales son: " + jugador.getPuntos());
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
                        jugador.pedirCarta((CartaF) baraja.siguienteCarta(true));
                        jugador.calcualrPuntos();
                        jugador.verMano();
                        System.out.println("-------");
                        System.out.println("Puntos actuales: " + jugador.getPuntos());
                        doblar = false;

                    }
                    case 2 -> {
                        System.out.println("-------");
                        System.out.println("Doble o nada");
                        jugador.pedirCarta((CartaF) baraja.siguienteCarta(true));
                        jugador.doblarApuesta();
                        jugador.calcualrPuntos();
                        jugador.verMano();
                        System.out.println(jugador.toString());
                        doblar = true;
                        salir = true;
                    }
                    case 3 -> {
                        jugador.calcualrPuntos();
                        salir = true;
                    }
                    case 4 -> {
                        jugador.calcualrPuntos();
                        System.out.println("-------");
                        System.out.println("Tus puntos actuales son: " + jugador.getPuntos());
                        salir = true;
                    }
                    default -> System.out.println("La opcion elejida no es correcta. Por favor elije una opcion entre 1 y 4");
                }
            }
        }
        croupier.verManoOculta();
        /**Menu Croupier*/
        System.out.println("-------");
        System.out.println("Turno del Croupier");
        croupier.verMano();
        croupier.calcualrPuntos();
        System.out.println("Puntos del croupier " + croupier.getPuntos());
        while (croupier.getPuntos() < 17 && croupier.getPuntos() < 21) {
            System.out.println("-------");
            croupier.pedirCarta((CartaF) baraja.siguienteCarta(true));
            croupier.verMano();
            croupier.calcualrPuntos();
            System.out.println("Puntos del croupier " + croupier.getPuntos());
        }
        /**Comparación de los turnos y ganador*/
        System.out.println("-------");
        System.out.println(jugador.toString());
        System.out.println(croupier.toString());
        if (croupier.getPuntos() > 21 && jugador.getPuntos() <= 21) {
            System.out.println("Has ganado");
            if (doblar) {
                jugador.setDinero(jugador.getApuesta() * 2);

            } else {
                jugador.setDinero(jugador.getApuesta() * 2);
            }
        } else if (jugador.getPuntos() < croupier.getPuntos() || jugador.getPuntos() > 21) {
            System.out.println("Has perdido");
        } else if (jugador.getPuntos() > croupier.getPuntos()) {
            System.out.println("Has ganado");
            if (doblar) {
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
    }
}
