package com.scalefocus.workforcemanagement.security;

public class CustomUserPrincipal {

    private long id;

    private String username;

    private String email;

    private boolean isAdmin;

    public CustomUserPrincipal(long id, String username, String email, boolean isAdmin) {
        this.setId(id);
        this.setUsername(username);
        this.setEmail(email);
        this.setAdmin(isAdmin);
    }

    public long getId() {
        return this.id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }

    private void setAdmin(boolean admin) {
        this.isAdmin = admin;
    }
}
