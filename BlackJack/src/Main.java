import Baraja.barajaFrance.BarajaF;
import Baraja.barajaFrance.CartaF;
import Mecanicas.Player;

/**
 * Project name: PrivateProyects/PACKAGE_NAME
 * Filename:
 * Created:  21/11/2020 / 11:19
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class Main {
    public static void main(String[] args) {
        BarajaF b = new BarajaF();
        Player p = new Player("Ismael");
        p.pedirCarta((CartaF) b.siguienteCarta(true));
        p.pedirCarta((CartaF) b.siguienteCarta(true));
        p.verMano();
        System.out.println("----------");
        p.calcualrPuntos();
        System.out.println(p.getPuntos());
        System.out.println("----------");
        p.apostar(10);
        System.out.println(p.toString());
        System.out.println("----------");
        p.pedirCarta((CartaF) b.siguienteCarta(true));
        p.verMano();
        p.calcualrPuntos();
        p.doblarApuesta();
        System.out.println(p.toString());
        p.plantarse();
    }
}
