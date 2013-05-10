package gestor.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int idProduct;
    
    private String description;
    
    private float cost;
    
    private float percentage;

    public Product(){
    
    }

    public Product(int idProduct, String description, float cost, float percentage) {
        this.idProduct = idProduct;
        this.description = description;
        this.cost = cost;
        this.percentage = percentage;
    }   
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", idProduct=" + idProduct + ", description=" + description + ", cost=" + cost + ", percentage=" + percentage + '}';
    }

  
    
}
