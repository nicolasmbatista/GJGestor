package gestor.repositories;

import HibernateUtil.HibernateUtil;
import gestor.model.Product;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ProductRepository extends IRepository {
    
    public ProductRepository(){
        
    }
    
    public Product getProductById(int idProduct){
        try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            Product result = (Product) session.createQuery( "from Product where idProduct =" + idProduct ).uniqueResult();
            tx.commit();
            if (result != null){
                System.out.println("Fetched " + result.toString());
                return result;
            }
            else return null;
        }
        catch (Exception e){
            // TO DO : logging
            handleException(e);
            return null;
        }
    }
    
    public long add(Product product, Product... products){
        try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(product);
            System.out.println("Added " + product.toString());
            if(products != null){
                for ( Product prod : products ) {
                    session.save(prod);
                    System.out.println("Added " + product.toString());
                }
            }                     
            session.getTransaction().commit();
            return product.getId();
        }
        catch (Exception e){
            // TO DO : logging
            handleException(e);
            return (long)-1;
        }   
    }
    
    public void delete(int idProduct, int... idProducts){
        try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Product product = getProductById(idProduct);
            session.delete(product);
            System.out.println("Product with id " + idProduct + " deleted ");
            if(idProducts != null){
                for ( int idProd : idProducts ) {
                    product = getProductById(idProd);
                    session.delete(product);
                    System.out.println("Product with id " + idProduct + " deleted ");
                }
            }                     
            session.getTransaction().commit();
        }
        catch (Exception e){
            // TO DO : logging
            handleException(e);
        }   
        }
    
    public List<Product> getAllProducts(boolean print){
        try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            List result = session.createQuery( "from Product" ).list();
            tx.commit();
            System.out.println("Retrieved " + result.size() + " products");
            if (print){
                for ( Product prod : (List<Product>) result ) {
                    System.out.println( prod.toString() );
                }
            }
            return result;
        }
        catch (Exception e){
            // TO DO : logging
            handleException(e);
            return null;
        }       
    }  
    
}

/* ROLLBACKS
 * Session sess = factory.openSession();
 Transaction tx;
 try {
     tx = sess.beginTransaction();
     //do some work
     ...
     tx.commit();
 }
 catch (Exception e) {
     if (tx!=null) tx.rollback();
     throw e;
 }
 finally {
     sess.close();
 }
 */