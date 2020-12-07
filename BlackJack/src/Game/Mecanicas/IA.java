package Game.Mecanicas;

import Game.Baraja.barajaFrance.CartaF;

import java.util.ArrayList;

/**
 * Project name: PrivateProyects/Game.Mecanicas
 * Filename:
 * Created:  07/12/2020 / 16:01
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class IA extends Player {
    //Attriubutes
    //Builder
    public IA() {
        super("Croupier");
        this.dinero=100000;
    }
    //Getters/Setters
    //Other Methods
    public void verManoOculta(){
        System.out.println("Mano del "+nombre);
        System.out.println("Carta oculta");
        for (int i = 1; i < numCartas(); i++) {
            CartaF Carta = mano.get(i);
            System.out.println(i+". "+Carta);
        }
    }

    @Override
    public String toString() {
        return nombre +" su mano es " + puntos;
    }
}
