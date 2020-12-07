package Game.Baraja.barajaFrance;


import Game.Baraja.base.Carta;
/**
 * Project name: PrivateProyects/Game.Baraja.barajaFrance
 * Filename: Carta Francesa
 * Created:  21/11/2020 / 9:21
 * Description: Creamos un objeto hijo de carta que contendra los palos de la baraja Francesa.
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 1.0
 */
public class CartaF extends Carta<PalosF> {
    //Builder
    public  CartaF(int valor, PalosF tipo){
        super(valor, tipo);
    }
    public CartaF(){}
    //Other Methods
    @Override
    public String toString() {
        String estado="";
        String nombreFigura="";
        switch (valor){
            case 1:
                nombreFigura="AS";
                break;
            case 11:
                nombreFigura="J";
                break;
            case 12:
                nombreFigura="Q";
                break;
            case 13:
                nombreFigura="K";
                break;
            default:
                nombreFigura=valor+"";
        }
        estado=nombreFigura+" de "+ tipo;
        return estado;
    }
}
