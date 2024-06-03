/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * @author lienm
 */
public class UserError {

    private String userID;
    private String fullName;
    private String role;
    private String password;
    private String confirm;

    public UserError() {
        this.userID = "";
        this.fullName = "";
        this.role = "";
        this.password = "";
        this.confirm = "";
    }

    public UserError(String userID, String fullName, String role, String password, String confirm) {
        this.userID = userID;
        this.fullName = fullName;
        this.role = role;
        this.password = password;
        this.confirm = confirm;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

}
