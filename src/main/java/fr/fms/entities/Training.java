package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Training implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String image; // Champ que va récupérer Angular côté front
    private String name;
    private String description;
    private double price;
    private int quantity;
}
