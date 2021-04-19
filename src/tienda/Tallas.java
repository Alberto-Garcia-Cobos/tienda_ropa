/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

/**
 *Método enumerado para las Tallas.
 * @author cobos
 */
public enum Tallas {
    XS("XS"), S("S"), M("M") , L("L"), XL("XL");
    
    Tallas(String talla){
        this.talla = talla;
    }
    String talla;
}
