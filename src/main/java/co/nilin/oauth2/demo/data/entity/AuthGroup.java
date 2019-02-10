package co.nilin.oauth2.demo.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "AUTH_USER_GROUP")
public class AuthGroup {

    @Id
    @Column(name = "AUTH_USER_GROUP_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(targetEntity = User.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "AUTH_USER")
    private User user;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "AUTH_GROUP")
    private String authGroup;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuthGroup() {
        return authGroup;
    }

    public void setAuthGroup(String authGroup) {
        this.authGroup = authGroup;
    }
}
