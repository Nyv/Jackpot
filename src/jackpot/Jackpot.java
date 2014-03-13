/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jackpot;

import java.awt.Component;
import java.text.NumberFormat;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class Jackpot {
    //Atributos
    double premio=0;
    double saldo=0;
    double deposito=1000;
    int nombreImagen[] = new int[3];
    NumberFormat formato = NumberFormat.getCurrencyInstance();
    
    //métodos
    //*************************************************************************
    //tirada valida
    public boolean tiradaValida(){
        if(saldo>=0.50){
            return true;
        }else{
            return false;
        }
    }
    //*************************************************************************
    //Conocer el saldo formato string
    public String getSaldoSTR(){
        return formato.format(saldo);
    }
    //*************************************************************************
    //Conocer el saldo
    public double getSaldo(){
        return saldo;
    }
    //*************************************************************************
    //Conocer el saldo formato string
    public String getPremioSTR(){
        return formato.format(premio);
    }
    //*************************************************************************
    //deposito
    public double getDeposito(){
        return deposito;
    }
    //*************************************************************************
    //Introducción de monedas
    public void setMoneda50(){
        saldo += 0.50;
        deposito+=0.50;
    }
    public void setMoneda1(){
        saldo += 1.00;
        deposito += 1.00;
    }
    public void setMoneda2(){
        saldo += 2.00;
        deposito +=2.00;
    }
    //*************************************************************************
    //Tirada, a 0.50
    public void getTirada(){
        saldo -= 0.50;
    }
    //*************************************************************************
    //jugar
    public double jugar(){
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            nombreImagen[i] = random.nextInt(5);
        }
        this.getTirada();
        premio = premios();
        saldo += premio;
        return premio;
    }
    //*************************************************************************
    //imagenes al azar
    public ImageIcon setImagenes(int indice){
            ImageIcon imagen=new ImageIcon();
            imagen = new ImageIcon(getClass().getResource("../imagenes/"+ nombreImagen[indice] + ".png"));
        return imagen;
    }
    //*************************************************************************
    //desactivar
    public void desactivar(JButton jbutton){
        jbutton.setEnabled(false);
    }    
    //*************************************************************************
    //activar
    public void activar(JButton jbutton){
        jbutton.setEnabled(true);
    }    
    //*************************************************************************
     //premios
    private int premios(){
        if (nombreImagen[0] == 0 && nombreImagen[1] == 0) {
            return 5;
        } else if (nombreImagen[0] == 0) {
            return 1;
        } else if (nombreImagen[0] == 1 && nombreImagen[1] == 1 && nombreImagen[2] == 1) {
            return 10;
        } else if (nombreImagen[0] == 1 && nombreImagen[1] == 1 && nombreImagen[2] == 4) {
            return 10;
        } else if (nombreImagen[0] == 2 && nombreImagen[1] == 2 && nombreImagen[2] == 2) {
            return 15;
        } else if (nombreImagen[0] == 2 && nombreImagen[1] == 2 && nombreImagen[2] == 4) {
            return 15;   
        } else if (nombreImagen[0] == 3 && nombreImagen[1] == 3 && nombreImagen[2] == 3) {
            return 20;
        } else if (nombreImagen[0] == 3 && nombreImagen[1] == 3 && nombreImagen[2] == 4) {
            return 20;
        } else if (nombreImagen[0] == 4 && nombreImagen[1] == 4 && nombreImagen[2] == 4) {
            return 100;
        } else {
            return 0;
        }        
    }
    //*************************************************************************
    //Cobrar
    public void getDinerito(){
        deposito -= saldo;
        saldo=0;
        premio=0;
    }
    //*************************************************************************
    //deposito a 0
    public void depositoEmpty(Component parent){
        if(deposito==0){
            JOptionPane.showMessageDialog(parent, "El depósito está vacío. Pase por caja", "Depósito vacío", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
