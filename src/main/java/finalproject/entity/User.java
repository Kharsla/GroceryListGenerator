package finalproject.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

    /**
     * A class to represent a user
     */
    @Entity(name = "User")
    @Table(name = "users")
    public class User {
        @Column(name = "userName")
        private String userName;
        @Column(name = "password")
        private String password;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
        @GenericGenerator(name = "native", strategy = "native")
        private int userId;


//https://stackoverflow.com/questions/4334970/hibernate-throws-multiplebagfetchexception-cannot-simultaneously-fetch-multipl
        @LazyCollection(LazyCollectionOption.FALSE)
        @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
        private Set<Recipe> recipes = new HashSet<>();
        @OneToMany(mappedBy="user", orphanRemoval = true, fetch = FetchType.LAZY)
        private Set<GeneratorRecipe> generatorRecipes = new HashSet<>();
        @LazyCollection(LazyCollectionOption.FALSE)
        @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
        private Set<Role> roles = new HashSet<>();
        /**
         * Instantiates a new user.
         */
        public User() {
        }
        /**
         * Instantiates a new User.
         * @param userName the name of the recipe
         * @param password the type of meal
         */
        public User(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }
        /**
         * Gets the userName
         * @return the userName
         */
        public String getUserName() {
            return userName;
        }
        /**
         * Sets the userName
         * @param userName the userName
         */
        public void setUserName(String userName) {
            this.userName = userName;
        }

        /**
         * Gets the users password
         * @return the user password
         */
        public String getPassword() {
            return password;
        }
        /**
         * Sets the password
         * @param password the password
         */
        public void setPassword(String password) {
            this.password = password;
        }
        /**
         * Gets the userId
         * @return the userId
         */
        public int getUserId() {
            return userId;
        }
        /**
         * Sets the userID
         * @param userId the user id
         */

        public void setUserId(int userId) {
            this.userId = userId;
        }

        /**
         * Gets the recipes
         * @return the users recipes
         */
        public Set<Recipe> getRecipes() {
            return recipes;
        }
        /**
         * Sets the recipes
         * @param recipes the recipes
         */
        public void setRecipes(Set<Recipe> recipes) {
            this.recipes = recipes;
        }

        public Set<GeneratorRecipe> getGeneratorRecipes() {
            return generatorRecipes;
        }

        public void setGeneratorRecipes(Set<GeneratorRecipe> generatorRecipes) {
            this.generatorRecipes = generatorRecipes;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    ", password='" + password + '\'' +
                    ", userId=" + userId +
                    '}';
        }

    }
