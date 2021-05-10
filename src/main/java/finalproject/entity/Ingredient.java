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
    /**
     * Gets the ingredientID
     * @return the ingredientID
     */
    public int getIngredientId() {
        return ingredientId;
    }
    /**
     * Sets ingreident ID
     * @param ingredientId the ingreidentID
     */
    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }
    /**
     * Gets the ingredientName
     * @return the ingredientName
     */
    public String getIngredientName() {
        return ingredientName;
    }
    /**
     * Sets ingreident name
     * @param ingredientName the ingreidentName
     */

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
    /**
     * Gets the quantity
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * Sets quantity
     * @param quantity the quantity
     */

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /**
     * Gets the unitOfMeasure
     * @return the userName
     */

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }
    /**
     * Sets unit of Measure
     * @param unitOfMeasure unti of measure
     */

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
    /**
     * Gets the recipe
     * @return the recipe
     */

    public Recipe getRecipe() {
        return recipe;
    }
    /**
     * Sets recipe
     * @param recipe the recipe
     */

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}