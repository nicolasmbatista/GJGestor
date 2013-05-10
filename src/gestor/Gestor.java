package gestor;

import gestor.model.Product;
import gestor.repositories.ProductRepository;

public class Gestor {

    public static void main(String[] args) {
        
        ProductRepository prodRep = new ProductRepository(); 
        
        Product p = new Product(1, "Producto 1", 7.89f , 15); 
        Product p1 = new Product(2, "Producto 2", 7.89f , 15);
        Product p2 = new Product(3, "Producto 3", 7.89f , 15);
        //prodRep.add(p,p1,p2);
        
        //Product resultado = prodRep.getProductById(1);

        //prodRep.getAllProducts(true);
        
        // Test Cases :P
        System.out.println("//////////////////////////////////////////////////////////////////");
        prodRep.getProductById(1);
        System.out.println("//////////////////////////////////////////////////////////////////");
        prodRep.getProductById(2);
        System.out.println("//////////////////////////////////////////////////////////////////");
        prodRep.getProductById(10);
        System.out.println("//////////////////////////////////////////////////////////////////");
        prodRep.add(p);
        System.out.println("//////////////////////////////////////////////////////////////////");
        prodRep.add(p,p1,p2);
        System.out.println("//////////////////////////////////////////////////////////////////");
        prodRep.delete(1);
        System.out.println("//////////////////////////////////////////////////////////////////");
        prodRep.delete(2,3);
        System.out.println("//////////////////////////////////////////////////////////////////");
        prodRep.delete(10);
        System.out.println("//////////////////////////////////////////////////////////////////");
        prodRep.getAllProducts(true);
        System.out.println("//////////////////////////////////////////////////////////////////");
        prodRep.getAllProducts(false);

    }
}
