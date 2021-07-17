package finalproject.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Entity(name = "GeneratorRecipe")
@Table(name = "GeneratorRecipes")
public class GeneratorRecipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    @JoinColumn(name="recipeId", nullable=false)
    private Recipe recipe;

    public GeneratorRecipe() {
    }

    public GeneratorRecipe(int id, Recipe recipe) {
        this.id = id;
        this.recipe = recipe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
