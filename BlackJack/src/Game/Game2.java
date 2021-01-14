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
 * Description: Clase principal en la que ocurrira lo necesario correspondiente al juago
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 0.3
 */
public class Game2 {
    private    Scanner sc = new Scanner(System.in);
    private    String user;
    public static   BarajaF baraja = new BarajaF();
    private   IA croupier = new IA();
    private   Player jugador;
    private boolean blackJack=false;
    private boolean salir= false;
    private boolean saldo=false;
    public void Play() {
        System.out.println("Bienvenido al Blak Jack");
        System.out.print("Por favor introduce tu nombre: ");
        user = sc.next();
        jugador = new Player(user);
        Round();
        while (!salir){
            NewRound();
        }
        System.out.println("-------");
        System.out.println("Adios!,\n" +
                "Tus ganancias han sido: "+jugador.getDinero()+"€");
    }

    private void Round(){
        System.out.println("-------\n" +
                "Tu dinero actual es " + jugador.getDinero()+"\n" +
                "¿Cual es tu apuesta?\n" +
                "min 10 / max 1000\n" +
                "10, 50, 100, 500, 1000");
        do {
            System.out.print("Apuesta: ");
            user = sc.next();
            if (Integer.parseInt(user)>jugador.getDinero()){
                System.out.println("El saldo es mas bajo que la apuesta, por favor introduce una apuesta acorde.");
            }
        } while (!(user.equals("10") || user.equals("50") || user.equals("100") || user.equals("500") || user.equals("1000")));
        jugador.apostar(Integer.parseInt(user));
        System.out.println("Tu apuesta es " + jugador.getApuesta()+" €\n" +
                "Repartiendo...");
        for (int i = 0; i < 2; i++) {
            jugador.pedirCarta((CartaF) baraja.siguienteCarta(true));
        }
        jugador.verMano();
        jugador.calcualrPuntos();
        System.out.println("Puntos: " + jugador.getPuntos()+"\n" +
                "-------");
        for (int i = 0; i < 2; i++) {
            croupier.pedirCarta((CartaF) baraja.siguienteCarta(true));
        }
        croupier.verManoOculta();
        /**Menu del jugador*/
        if (jugador.getPuntos()==21||croupier.getPuntos()==21){
            if (croupier.getPuntos()==21) {
                croupier.verMano();
            }
            blackJack=true;
            EndRound();
        }else{
            jugador.MenuPlayer();
            if (jugador.getPuntos()>21){
                EndRound();
            }else if (jugador.getOpcion()==4){
                EndRound();
            }else {
                /**Menu Croupier*/
                croupier.MenuIA();
                /**Comparación de los turnos y ganador*/
                EndRound();
            }
        }
    }

    private void NewRound() {
        int op;
        while (!salir){
            if (jugador.getDinero()<=0){
                salir=true;
                System.out.println("Te has quedado sin dinero.");
            }else{
                System.out.println("-------");
                System.out.println("Opción 1: Seguir jugando");
                System.out.println("Opción 2: salir");
                System.out.print("Por favor elije una opcion: ");
                op=sc.nextInt();
                switch (op){
                    case 1->{
                        jugador.limpiarMano();
                        croupier.limpiarMano();
                        jugador.setApuesta(0);
                        jugador.setDoblar(false);
                        baraja.crearBaraja();
                        baraja.barajar();
                        Round();
                    }
                    case 2->{
                        salir=true;
                    }
                }
            }

        }
    }

    private void EndRound(){
        System.out.println("-------");
        System.out.println(jugador.toString());
        System.out.println(croupier.toString());
       if (jugador.getOpcion()==4||(jugador.getOpcion()==3&&jugador.isDoblar())){
           System.out.println("Te has rendido!");
           croupier.setDinero(jugador.getApuesta());
       }else if ((jugador.getPuntos()==21&&blackJack)&&croupier.getPuntos()!=21){
            System.out.println("Has ganado!");
            jugador.setDinero(jugador.getApuesta()*3);
            croupier.setDinero(jugador.getApuesta()*2);
        }else if ((croupier.getPuntos()==21&&blackJack)&&jugador.getPuntos()!=21){
            System.out.println("Gana la banca!");
            croupier.setDinero(jugador.getApuesta());
        }else if (jugador.getPuntos()==croupier.getPuntos()){
            System.out.println("Empate! Recuperas la apuesta!");
            jugador.setDinero(jugador.getApuesta());
        }else{
            if ((croupier.getPuntos() > 21 && jugador.getPuntos() <= 21)||(jugador.getPuntos()<=21 && jugador.getPuntos() > croupier.getPuntos())) {
                System.out.println("Has ganado");
                if (jugador.isDoblar()) {
                    jugador.setDinero(jugador.getApuesta() * 2);
                    croupier.setDinero(-jugador.getApuesta());
                } else {
                    jugador.setDinero(jugador.getApuesta() * 2);
                    croupier.setDinero(-jugador.getApuesta());
                }
            } else if (jugador.getPuntos() < croupier.getPuntos() || jugador.getPuntos() > 21) {
                System.out.println("Has perdido");
            }
        }
        System.out.println(jugador.toString());
    }
}
