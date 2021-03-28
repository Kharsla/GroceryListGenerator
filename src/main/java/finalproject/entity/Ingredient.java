package finalproject.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * A class to represent a ingredient
 */
@Entity(name = "Ingredient")
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int ingredientId;

    private String ingredientName;
    private int quantity;
    private String unitOfMeasure;

    @ManyToOne
    @JoinColumn(name="recipeId", nullable=false)
    private Recipe recipe;

    /**
     * Instantiates a new ingredient.
     */
    public Ingredient() {
    }

    public Ingredient(int ingredientId, String ingredientName, int quantity, String unitOfMeasure, Recipe recipe) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.recipe = recipe;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}