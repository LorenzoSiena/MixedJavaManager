/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmaciadambrogio;

import java.util.*;

/**
 *
 * @author lorenzo
 */
public class Cliente {

    private String nomeCognome;
    private String codFisc;
    private float punti;
    private LinkedList<Farmaco> listaFarmaci;

    public Cliente(String nomeCognome, String codFisc, float punti) {
        this.nomeCognome = nomeCognome;
        this.codFisc = codFisc;
        listaFarmaci = new LinkedList<>();
        this.punti = punti;
    }

    public String getNomeCognome() {
        return nomeCognome;
    }

    public String getCodFisc() {
        return codFisc;
    }

    public float getPunti() {
        return punti;
    }

    @Override
    public String toString() {

        String str = "Cliente{" + "nomeCognome=" + nomeCognome + ", codFisc=" + codFisc + ", punti=" + punti + '}';

        for (Farmaco farmaco : listaFarmaci) {
            str += "\n" + farmaco;
        }
        return str;
    }

    public void addAcquistoFarmaco(Farmaco f) {

        listaFarmaci.add(f);

    }

    public boolean checkData() {

        for (Farmaco farmaco : listaFarmaci) {
            if (farmaco.getDataAcquisto().compareTo("20200501") >= 0) {  //La data è maggiore del 20200501
                return true;
            }

        }
        return false;
    }

    public void addPoint(float f) {

        punti += (f / 2);

    }

//Controlla se un elemento della lista è contenuto in un altra lista
    boolean checkFarmaco(LinkedList<Farmaco> listaRef) {

        for (Farmaco farmaco : listaFarmaci) { //per ogni farmaco del cliente

            if (listaRef.contains(farmaco)) { //se la lista contiene un farmaco DOVE IL FARMACO E' il codiceFarmaco
                return true;
            }
        }
        return false;
    }

}
