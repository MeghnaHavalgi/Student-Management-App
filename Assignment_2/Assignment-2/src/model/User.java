/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author meghnahavalgi
 */
public class User {
    
    private String fname;
    private String lname;
    private int id;
    private static int nextId = 1;
    private String username;
    private String hshpassword;
    private String lastUsedPassword;
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = nextId++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHshpassword() {
        return hshpassword;
    }

    public void setHshpassword(String plainPassword) {
         if (!plainPassword.equals(lastUsedPassword)) {
            this.hshpassword = hashPassword(plainPassword);
            lastUsedPassword = plainPassword;
        } else {
            System.out.println("Password cannot be the same as the last used password.");
        }
    }

    public String getLastUsedPassword() {
        return lastUsedPassword;
    }
    public boolean verifyPassword(String plainPassword) {
    String hashedPassword = hashPassword(plainPassword);
     System.out.println(hashedPassword + "This is hashed");
     
    return hashedPassword.equals(this.hshpassword);
    
}
    
    public static String hashPassword(String plainPassword) {
        String salt = "Meghna";
        try {
            String saltedPassword = plainPassword + salt;
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(saltedPassword.getBytes());
            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte b : hashBytes) {
                hexStringBuilder.append(String.format("%02x", b));
            }

            return hexStringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null; 
        }
        
        
    }
        
}
