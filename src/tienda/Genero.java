/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

/**
 *Método enumerado para el género.
 * @author cobos
 */
public enum Genero {
    M("M"),F("F"),U("U");
    
    Genero(String genero){
        this.genero = genero;
    }
    String genero;
}
