package co.nilin.oauth2.demo.data.entity;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "USERSS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USER_NAME",nullable = false,unique = true)
    private String username;

    @Column(name = "USER_PASSWORD")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<AuthGroup> authGroups;

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
