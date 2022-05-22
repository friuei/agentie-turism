package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;
public class User {
    @Id
    private String username;
    private String password;
    private String role;
    private int status;
    private String programare;
    private String review;
    private String offer;

    public String getProgramare() {
        return programare;
    }

    public String getOffer() {
        return this.offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public User(String username, String password, String role, String programare, String review,String offer, int status) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.offer=offer;
        this.status = status;
        this.programare = programare;
        this.review = review;

    }

    public User() {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus(){ return status;}

    public void setStatus(int status){this.status = status;}

    public void setProgramare(String progrmare){this.programare=this.programare+progrmare;}

    public void setReview(String review){this.review=review;}

    public String getReview(){return review;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return role != null ? role.equals(user.role) : user.role == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
