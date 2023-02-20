package com.system.recipe_app.pojo;
import com.system.recipe_app.entity.Food;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodPojo {
    private Integer id;

    @NotNull
    private String food_name;

    @NotNull
    private String description;
    private String ingredients;

    private Integer foodCategory;
    private String duration;

    //    private MultipartFile image;
    @NotNull
    private String image;


    public FoodPojo(Food food){
        this.id=food.getId();
        this.food_name=food.getFood_name();
        this.description=food.getDescription();
        this.ingredients=food.getIngredients();
        this.foodCategory=getFoodCategory();
        this.duration=getDuration();
        this.image=food.getImage();

    }
}
