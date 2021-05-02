package finalproject.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A class to represent a recipe
 */
@Entity(name = "Recipe")
@Table(name = "recipes")

public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int recipeId;

    private String recipeName;
    private String mealType;

    @OneToMany(mappedBy="recipe", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Ingredient> ingredients = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="userId", nullable=false)
    private User user;

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
    public Recipe(User user, String recipeName, String mealType) {
        this.user = user;
        this.recipeName = recipeName;
        this.mealType = mealType;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", mealType='" + mealType + '\'' +
                ", ingredients=" + ingredients +
                ", user=" + user +
                '}';
    }

    /**
     * Adds a location to the Artist's set of locations
     * @param ingredient
     */
    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);

    }

}