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
    Random numAleatorio = new Random();
    int nombreImagen[] = new int[4];
    NumberFormat formato = NumberFormat.getCurrencyInstance();
    ImageIcon imagen=new ImageIcon();
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
    //Conocer el saldo
    public double getPremio(){
        return premio;
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
    //imagenes al azar
    public ImageIcon setImagenes(){
        //Asignar valores
        for(int i=0;i<nombreImagen.length;i++){
            nombreImagen[i] = numAleatorio.nextInt(5);
        }
        for(int v=0;v<nombreImagen.length;v++){
            imagen = new ImageIcon(getClass().getResource("../imagenes/"+ nombreImagen[v] + ".png"));
            //premios
            if(nombreImagen[0]==0){
                premio = 1.00;
                saldo += 1.00;
            }
            if(nombreImagen[0]==0 && nombreImagen[1]==0){
                premio = 5.00;
                saldo += 5.00;
            }
            if(nombreImagen[0]==1 && nombreImagen[1]==1 && nombreImagen[2]==4){
                premio = 10.00;
                saldo += 10.00;
            }
            if(nombreImagen[0]==1 && nombreImagen[1]==1 && nombreImagen[2]==1){
                premio = 10.00;
                saldo += 10.00;
            }
            if(nombreImagen[0]==2 && nombreImagen[1]==2 && nombreImagen[2]==2){
                premio = 15.00;
                saldo += 15.00;
            }
            if(nombreImagen[0]==2 && nombreImagen[1]==2 && nombreImagen[2]==4){
                premio = 15.00;
                saldo += 15.00;
            }
            if(nombreImagen[0]==3 && nombreImagen[1]==3 && nombreImagen[2]==3){
                premio = 20.00;
                saldo += 15.00;
            }
            if(nombreImagen[0]==3 && nombreImagen[1]==3 && nombreImagen[2]==4){
                premio = 20.00;
                saldo += 20.00;
            }
            if(nombreImagen[0]==4 && nombreImagen[1]==4 && nombreImagen[2]==4){
                premio = 100.00;
                saldo += 100.00;
            }
        }
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
    
    //*************************************************************************
    //Cobrar
    public void getDinerito(){
        saldo=0;
        premio=0;
        deposito -= saldo;
    }
    //*************************************************************************
    //deposito a 0
    public void depositoEmpty(Component parent){
        if(deposito==0){
            JOptionPane.showMessageDialog(parent, "El depósito está vacío. Pase por caja", "Depósito vacío", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
