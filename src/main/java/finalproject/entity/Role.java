package finalproject.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a user Role
 */
@Entity(name = "Role")
@Table(name = "role")
public class Role {
    @Column(name = "userName")
    private String userName;
    @Column(name = "roleName")
    private String roleName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    @JoinColumn(name="userId", nullable=false)
    private User user;
    /**
     * Gets userName
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }
    /**
     * Sets userName
     * @param userName the userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * Gets roleName
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }
    /**
     * Sets roleName
     * @param roleName the role Name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    /**
     * Gets roleID
     * @return the roleID
     */
    public int getId() {
        return id;
    }
    /**
     * Sets the id
     * @param id the role id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Gets the user
     * @return the user
     */
    public User getUser() {
        return user;
    }
    /**
     * Sets the user
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }
}
