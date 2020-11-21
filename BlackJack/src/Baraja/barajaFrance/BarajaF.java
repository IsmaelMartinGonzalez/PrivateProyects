package Baraja.barajaFrance;

import Baraja.base.*;
/**
 * Project name: PrivateProyects/Baraja.barajaFrance
 * Filename: Baraja Francesa
 * Created:  21/11/2020 / 9:22
 * Description: Creamos un objeto hijo de baraja para generar una baraja Francesa.
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 1.0
 */
public class BarajaF extends Baraja {
    //Builder
    public BarajaF(){
        super();
        this.numCartas=52;
        this.cartasPorTipo=13;
        crearBaraja(); //Creamos la baraja
        super.barajar();//Barajamos la baraja
    }
    //Other Methods
    public boolean cartaRoja(Carta<PalosF> c){
        return c.getTipo()==PalosF.CORAZONES||c.getTipo()== PalosF.DIAMANTES;
    }
    public boolean cartaNegra(Carta<PalosF>c){
        return c.getTipo()==PalosF.TREBOLES||c.getTipo()== PalosF.PICAS;
    }

    @Override
    public void crearBaraja() {
        PalosF[] tipos=PalosF.values();

        for (int i = 0; i < tipos.length; i++) {
            for (int j = 0; j < cartasPorTipo; j++) {
                this.cartas.push(new CartaF(j+1, tipos[i]));
            }
        }
    }
}
