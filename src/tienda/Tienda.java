
package tienda;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *Examen final programación.
 * Clase main donde se interpreta un ticket de compra de un tienda, en la cual
 * introduciremos prodcutos con diferentes atributos. La función del programa es
 * poder insertar, listar, borrar y modificar todos los articulos necesarios.
 * 16/04/2021
 * @author Alberto García Cobos
 */
public class Tienda {


    public static void main(String[] args) {
        
        
        int opcion;
        Scanner teclado=new Scanner(System.in);
        Ticket ticket = new Ticket();
        
        //Listado del menu del programa.
        do{
           System.out.println("Elige una opción: \n 1 Nuevo Articulo: \n 2 Lista de articulos: "
           + "\n 3 Buscar articulo: \n 4 Modificar datos de un articulo: \n 5 Eliminar articulo: \n 6 Salir: ");
           opcion=Integer.parseInt(teclado.nextLine());
           
           //Comienzo del bucle por donde solicitaremos que función queremos hacer.
        switch(opcion){
                //Opcion 1: Introdución de un articulo
                case 1: 
                    //Introducimos el código del articulo
                    Articulo art= new Articulo();
                    System.out.println("Que código desea ingresar");
                    art.setCodigo(teclado.nextInt());
                    teclado.nextLine(); 
                    //Introducimos la descripción del articulo.
                    System.out.println("Que descripción desea ingresar");
                    art.setDescripcion(teclado.next());
                    teclado.nextLine(); 
                    //Introducimos el genero del articulo, con las restricciones dadas.
                    String genero;
                    //Comienzo del bucle
                    do{
                    System.out.println("Que genero desea ingresar: M,F o U");
                    genero = teclado.next();
                    teclado.nextLine();
                    //Incluimos la posibilidad de no existir ese genero
                    if(!Validar.validaGenero(genero)){
                       System.out.println("El genero no es correcto. Introduce otro");

                    }
                    }while(!Validar.validaGenero(genero));
                    art.setGenero(genero);//Lo añadimos
                    //Introducimos la talla del articulo con sus restricciones
                    String talla;
                    //Comienzo del bucle
                    do{
                    System.out.println("Que talla desea ingresar: XS, S, M, L , XL");
                    talla = teclado.next();
                    teclado.nextLine();
                    //Incluimos la posibilidad de que no exista.
                    if(!Validar.validaTalla(talla)){
                       System.out.println("La talla no es correcta. Introduce otra");

                    }
                    }while(!Validar.validaTalla(talla));
                    art.setTalla(talla);
                    //Introducimos la composición.
                    System.out.println("Que composición desea ingresar");
                    art.setcomposicion(teclado.next());
                    teclado.nextLine(); 
                    //Introducimos el precio, siendo la unica posibilidad que sea positivo.
                    double precio;
                    //Comienzo del bucle.
                    do{
                    System.out.println("Que precio desea ingresar. Debe ser positivo");
                    precio = teclado.nextDouble();
                    teclado.nextLine();
                    //Incluimos la posibilidad de que el precio ete mal introducido.
                    if(!Validar.esPrecioPositivo(precio)){
                       System.out.println("El precio no es positivo. Introduce otro");
                    }
                    }while(!Validar.esPrecioPositivo(precio));
                    art.setPrecio(precio);
                    
                    ticket.insertaArticulo(art);
                    //Fin de la opcion 1.
                    break;
                    //Opcion 2: Listado de todos los articulos introducidos.
                case 2:
                    
                    ticket.listarArticulos();
                      //Fin de la opción 2.              
                    break;
                    //Opción 3: busqueda de articulo pos su código.
                case 3:
                    
                    System.out.println("Que código desea buscar");
                    int busquedaCodigo=(teclado.nextInt());
                    teclado.nextLine();                    
                    ArrayList busquedaArticulo= ticket.buscaArticulo(busquedaCodigo);
                    //Indicamos la posibilidad de no existir ningún articulo con ese código.
                    if(busquedaArticulo.isEmpty()){
                        System.out.println("No hay ningun articulo con este código");
                    }else {
                        for (int i=0; i<busquedaArticulo.size();i++){
            
                            System.out.println(busquedaArticulo.get(i).toString());
                        }; 
                    }
                    //Fin de la opción 3.
                    break;
                    /*Opción 4: Se solicita el código de un producto para modificarlo
                    de encontrarse dos productos con el mismo código se solicita la 
                    descripción para diferenciarlos.
                    */
                case 4:
                    
                    
                    System.out.println("Que código desea modificar");
                    busquedaCodigo=(teclado.nextInt());
                    teclado.nextLine();                    
                    
                            System.out.println("Que descripción desea modificar");
                           String descripcion=(teclado.next());
                           teclado.nextLine();
                           System.out.println("Que genero desea modificar");
                           genero=(teclado.next());
                           teclado.nextLine();
                           System.out.println("Que talla desea modificar");
                           talla=(teclado.next());
                            teclado.nextLine();
                           System.out.println("Que composición desea modificar");
                           String composicion=(teclado.next());
                            teclado.nextLine();
                           System.out.println("Que precio desea modificar");
                           precio=(teclado.nextInt());
                           teclado.nextLine(); 
                           ticket.modificarArticulo(busquedaCodigo, descripcion, genero, talla, composicion, precio);
                           //fin de la opción 4.
                    break;  
                    //Opción 5: Se elimina un producto a traves del código solicitado.
                case 5:
                    
                    System.out.println("Que código desea eliminar");
                    int eliminaCodigo=(teclado.nextInt());
                    teclado.nextLine();                    
                            
                           ticket.eliminarArticulo(eliminaCodigo);
                    //Fin de la opción 5.
                    break;  
                    //Opción 6: Fin del programa
                case 6:
                    System.out.println("Fin del programa, gracias");
                    //Fin de la opción 6.    
                break;
        };
              
        }while (opcion<6);
     
    }
    
}
