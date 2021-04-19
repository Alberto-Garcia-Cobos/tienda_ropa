/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.util.ArrayList;

/**
 *
 * @author cobos
 */
public class Validar {
    static boolean esPrecioPositivo(double precio){
        return precio >= 0;
    }
    /**
     * Método estatico para validar tallas
     * @param talla
     * @return 
     */
    static boolean validaTalla(String talla){
        if (Tallas.XS.talla.equals(talla)){
            return true;
        } else if (Tallas.S.talla.equals(talla)){
            return true;
        }else if (Tallas.M.talla.equals(talla)){
            return true;
        }else if (Tallas.L.talla.equals(talla)){
            return true;
        }else if (Tallas.XL.talla.equals(talla)){
            return true;
        }
        return false;
    }
    /**
     * Método estatico para validar el género.
     * @param genero
     * @return 
     */
    static boolean validaGenero(String genero){
        if (Genero.F.genero.equals(genero)){
            return true;
        } else if (Genero.M.genero.equals(genero)){
            return true;
        }else if (Genero.U.genero.equals(genero)){
            return true;
        }
        return false;
    }
    /**
     * Metodo estatico para no repetir articulos.
     * @param codigo
     * @param listadoArticulos
     * @return 
     */
    static boolean existeArticulo(int codigo,  ArrayList<Articulo> listadoArticulos){
        for (int i = 0; i < listadoArticulos.size(); i++) {
                  if (listadoArticulos.get(i).getCodigo() == codigo){
                    return true;
            }
        }
        return false;
    }
    
}
