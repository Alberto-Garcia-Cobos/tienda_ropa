
package tienda;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *Clase ticket donde se implementan los métodos para introducir datos y mostrarlos.
 * @author Alberto García Cobos
 */
public class Ticket {
    
    ArrayList<Articulo> listadoArticulo= new ArrayList<Articulo>();
    
    public void insertaArticulo(Articulo articulos){
        
        listadoArticulo.add(articulos);
    }
    /**
     * Método listar todos los articulos de la tienda introducidos.
     */
    public void listarArticulos(){
        
        for (int i=0; i<listadoArticulo.size();i++){
            
            System.out.println(listadoArticulo.get(i).toString());
   
        }
        
    }
    /**
     * Método de arrayList para buscar todos los articulos en la tienda 
     * mediante su código.
     * @param busquedaCodigo
     * @return 
     */
    public ArrayList buscaArticulo(int busquedaCodigo){
        
        ArrayList busqueda=new ArrayList();
        
        boolean flag = false;
        for (int i=0; i<listadoArticulo.size();i++){
            
            if(listadoArticulo.get(i).getCodigo()== busquedaCodigo){
               
                busqueda.add(listadoArticulo.get(i));
            };   
            
        }
        return busqueda;
            }
            
    /**
     * Método para modificar los articulos ya introducidos. SI existen dos articulos
     * con el mismo código, nos pedira que digamos que descripción queremos modificar
     * para diferenciarlos.
     * @param codigo
     * @param descripcion
     * @param genero
     * @param talla
     * @param composicion
     * @param precio 
     */
    public void modificarArticulo(int codigo, String descripcion, String genero, 
            String talla, String composicion, double precio){
        if (Validar.existeArticulo(codigo, listadoArticulo)){

        Articulo art = new Articulo();
            art.setCodigo(codigo);
            art.setDescripcion(descripcion);
            art.setGenero(genero);
            art.setTalla(talla);
            art.setcomposicion(composicion);
            art.setPrecio(precio);
        
            ArrayList<Articulo> articuloBuscado = buscaArticulo(codigo);
         if (articuloBuscado.size()==1){
            listadoArticulo.remove(articuloBuscado.get(0));
            listadoArticulo.add(art);
            System.out.println("Se ha modificado correctamente");
        }else{
            boolean flag = false;
            for (int i = 0; i < articuloBuscado.size(); i++) {
                if (articuloBuscado.get(i).getDescripcion().equals(art.getDescripcion())){
                    listadoArticulo.remove(articuloBuscado.get(i));
                    listadoArticulo.add(art);
                    flag = true;
                    break;
                }
            }
            if (flag == false){
                System.out.println("Descripcion no encontrada");
            }else{
               System.out.println("Se ha modificado correctamente");

            }
        }
        }else{
            System.out.println("No se puede modificar, por que no existe");
        }
        

    }
    /**
     * Método para eliminar los articulos a traves del código solicitado.
     * @param eliminaCodigo 
     */
    public void eliminarArticulo(int eliminaCodigo) {
        if (Validar.existeArticulo(eliminaCodigo, listadoArticulo)){
            ArrayList<Articulo> articuloBuscado = buscaArticulo(eliminaCodigo);
            if (articuloBuscado.size()==1){
                listadoArticulo.remove(articuloBuscado.get(0));
                System.out.println("Se ha eliminado correctamente");
            }else{
                  System.out.println("Que descripción desea eliminar");
                       Scanner teclado=new Scanner(System.in);
                String descripcion=(teclado.next());
               teclado.nextLine();
                boolean flag = false;
                for (int i = 0; i < articuloBuscado.size(); i++) {
                    if (articuloBuscado.get(i).getDescripcion().equals(descripcion)){
                        listadoArticulo.remove(articuloBuscado.get(i));
                        flag = true;
                        break;
                    }
                }
                if (flag == false){
                    System.out.println("Descripcion no encontrada");
                }else{
                   System.out.println("Se ha eliminado correctamente");

                }
            }
        }else{
            System.out.println("No se puede eliminar, por que no existe");
        }
        
    }
    
    
}
