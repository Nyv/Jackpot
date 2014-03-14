/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jackpot;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author usuario
 */
public class Historial {
    Jackpot jackpot = new Jackpot();
    double premio=jackpot.premios();
    double saldo=jackpot.getSaldo();
    double deposito=jackpot.getDeposito();
    Calendar calendar = Calendar.getInstance();
    ArrayList<Jackpot> listaJack = new ArrayList();
    
    public void guardar(){
        listaJack.add(jackpot);
    }
    //****************************************************************
    //mostrar por salida estándar
    public void mostrarHistorial(){
        for(int i=0;i<listaJack.size();i++){
            System.out.println(listaJack.get(i));
        }
    }
}
