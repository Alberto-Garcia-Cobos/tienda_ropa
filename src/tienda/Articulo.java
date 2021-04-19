
package tienda;

/**
 * Clase Articulo es la encargada de la implementación de los metodos getter and setter
 * para la encapsulación de los mismo.
 * Su funcionalidad es recibir y gestionar las variables del programa.
 * @author Alberto García Cobos
 */

public class Articulo implements Comparable<Articulo> {
    public Articulo(){}
    
    /**
     * Método constructor de la clase Articulo.
     * @param codigo
     * @param descripcion
     * @param talla
     * @param genero
     * @param composicion
     * @param precio 
     */
    public Articulo (int codigo, String descripcion, String talla, String genero, String composicion, double precio){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.talla = talla;
        this.genero = genero;
        this.posicion = composicion;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getComposicion() {
        return posicion;
    }

    public void setcomposicion(String posicion) {
        this.posicion = posicion;
    }
/**
 * Método soString 
 * @return 
 */
    @Override
    public String toString() {
        return "Articulo{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", genero=" 
                + genero + ", talla=" + talla + ", posicion=" + posicion + ", precio=" + precio + '}';
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    private int codigo;
    private String descripcion;
    private String genero;
    private String talla;
    private String posicion;
    private double precio;

    @Override
    public int compareTo(Articulo o) {
        if (this.codigo<o.getCodigo()){
            return -1;
        }else if(this.codigo==o.getCodigo()){
            return 0;
        }else return 1;
    }
    
    
    
    
    
}
