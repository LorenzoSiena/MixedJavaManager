/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this license header, choose License Headers in Projec
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancamediolanum;

import java.util.*;

/**
 *
 * @author lorenzo
 */
public class Cliente {

    private String iban;//Key
    private int filiale;
    private float saldo;
    private String nome;
    LinkedList<Movimento> listaMovimenti;

    public Cliente(String iban, String nome, int filiale, float saldo) {
        this.iban = iban;
        this.nome = nome;
        this.filiale = filiale;
        this.saldo = saldo; //Ma il saldo non dovrebbe essere calcolato appena leggo dai movimenti del cliente?
        listaMovimenti = new LinkedList<Movimento>();

    }

    public void addMovimento(Movimento e) {

        listaMovimenti.add(e);

    }

    @Override
    public String toString() {
        String str;
        str = "Cliente: " + nome + " della filiale " + filiale + " Iban " + iban;
        for (Movimento m : listaMovimenti) {
            str += m.toString();
        }
        str += " Saldo totale:" + saldo;
        return str;
    }

    public String getIban() {
        return iban;
    }

    public float getSaldo() {
        return saldo;
    }

    public void delMov(String data) {
        boolean status = false;

        try {

            for (Movimento m : listaMovimenti) {
                if (m.getData().equals(data)) {
                    status = true;
                    if (m.getTipologia() == 0) {//addebito
                        saldo += m.getImporto();
                        listaMovimenti.remove(m);
                    } else { //accredito
                        saldo -= m.getImporto();
                        listaMovimenti.remove(m);
                    }
                }
            }

            if (status == false) {
                throw new NoMovementDataException();
            }

        } catch (NoMovementDataException e) {
            System.out.println("Errore: Non esistono movimenti per la data inserita" + data);
            System.exit(-1);
        }

    }

    float addebitoTotaleInData(String data) {
        float somma=0;
        for (Movimento m : listaMovimenti) {
            if (m.getTipologia()==0 && m.getData().equals(data)) {
               somma+=m.getImporto();
            }
        }
        return somma;
    }

}
