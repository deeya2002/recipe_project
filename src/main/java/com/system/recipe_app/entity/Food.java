package com.system.recipe_app.entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "food_name", nullable = false)
    private String food_name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodcategory_id",nullable = true)
    private FoodCategory foodCategory;

    @Column (name = "description",length = 600, nullable = false)
    private String description;

    @Column (name = "ingredients",length = 600, nullable = false)
    private String ingredients;

    @Column(name = "image")
    private String image;

    @Column(name = "duration", nullable = false)
    private String duration;

//    @Transient
//    private String imageBase64;
}
