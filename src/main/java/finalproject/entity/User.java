package finalproject.entity;

import org.hibernate.annotations.GenericGenerator;

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



        @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
        private List<Recipe> recipes = new ArrayList<>();

        public User() {
        }

        public User(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public List<Recipe> getRecipes() {
            return recipes;
        }

        public void setRecipes(List<Recipe> recipes) {
            this.recipes = recipes;
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
