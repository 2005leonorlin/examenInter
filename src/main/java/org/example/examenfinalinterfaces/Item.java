package org.example.examenfinalinterfaces;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Representa un ítem en la colección "Items" en MongoDB.
 * Esta clase está anotada con @Document para indicar que es un documento de MongoDB.
 * La anotación @Data de Lombok genera los métodos getters, setters, toString, equals y hashCode.
 */
@Document(collection = "Items")
@Data
public class Item {
    private String id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private double rate;
    private int count;
}