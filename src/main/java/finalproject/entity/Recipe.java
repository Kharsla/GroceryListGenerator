package finalproject.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;


/**
 * A class to represent a recipe
 */
@Entity(name = "Recipe")
@Table(name = "recipes")
public class Recipe {
    @Column(name = "recipeName")
    private String recipeName;
    @Column(name = "mealType")
    private String mealType;
    @Column(name = "userId")
    private int userId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int recipeId;

    /**
     * Instantiates a new recipe.
     */
    public Recipe() {
    }

    /**
     * Instantiates a new User.
     * @param recipeName the name of the recipe
     * @param mealType the type of meal
     */
    public Recipe(int userId, String recipeName, String mealType) {
        this.userId = userId;
        this.recipeName = recipeName;
        this. mealType = mealType;
    }

    /**
     * Gets recipe name.
     * @return the recipe name
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * Sets first name.
     * @param recipeName the recipe name
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * Gets type of meal
     * @return the type of meal
     */
    public String getMealType() {
        return mealType;
    }

    /**
     * Sets the meal type
     * @param mealType type of meal
     */
    public void setMealType(String mealType) {
        this.mealType= mealType;
    }

}