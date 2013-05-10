package gestor.repositories;

public abstract class IRepository {
    
    public void handleException(Exception ex){
        System.out.println("Error : " + ex.getMessage());
    }
    
}
