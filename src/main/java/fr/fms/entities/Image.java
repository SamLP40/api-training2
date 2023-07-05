package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Image {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Lier l'ID image à l'ID de chaque Training
    private String url;

}
