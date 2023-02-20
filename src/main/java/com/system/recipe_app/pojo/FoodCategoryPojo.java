package com.system.recipe_app.pojo;

import com.system.recipe_app.entity.FoodCategory;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodCategoryPojo {
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String image;

    public FoodCategoryPojo(FoodCategory foodCategory){
        this.id=foodCategory.getId();
        this.name=foodCategory.getName();
        this.description=foodCategory.getDescription();
        this.image=foodCategory.getImage();
    }
}
