package com.ioco.robotapocalypse.resource;

import jakarta.persistence.*;

import com.ioco.robotapocalypse.survivor.Survivor;

@Entity
@Table(name = "Resources")
public class Resource {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
  
    @Column(nullable = false, length = 255)
    private String name;

    private Integer quantity;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SurvivorID")

    private Survivor survivor;
    
    public Resource(String string, int i, Object object) {
    }
    
    public Resource(String name, Integer quantity, Survivor survivor) {
       
        this.name = name;
        this.quantity = quantity;
        this.survivor = survivor;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Survivor getSurvivorId() {
        return survivor;
    }
    public void setSurvivorId(Survivor survivorId) {
        this.survivor = survivorId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

        
}
