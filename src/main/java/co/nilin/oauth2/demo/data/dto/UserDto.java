package co.nilin.oauth2.demo.data.dto;

import co.nilin.oauth2.demo.data.entity.AuthGroup;

import java.util.List;

public class UserDto {

    private String userId;
    private String password;
    private String username;
    private List<AuthGroup> authGroups;

    public UserDto() {
    }

    public List<AuthGroup> getAuthGroups() {
        return authGroups;
    }

    public void setAuthGroups(List<AuthGroup> authGroups) {
        this.authGroups = authGroups;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
