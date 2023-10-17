/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author meghnahavalgi
 */
public class UserList {
    
    private ArrayList<User> user ;
    
    public UserList()
    {
        this.user = new ArrayList<User>();
    }

    public ArrayList<User> getUser() {
        return user;
    }

    public void setUser(ArrayList<User> user) {
        this.user = user;
    }

  public User addNewUser()
    {
        User newUser = new User();
        user.add(newUser);
        return newUser;
    }
  
  public ArrayList<User> getAllUsers() {
        return user;
    }
    
    
    public User getUserById(int userId) {
        for (User u : user) {
            
            if (u.getId() == userId) {
                return u; 
            }
        }
        return null; 
    }
    
    public void updateUsernameAndPassword(int id, String newUsername, String newPassword) {
    for (User user : user) {
        if (user.getId() == id) {
           
            user.setUsername(newUsername); 
            user.setHshpassword(newPassword);
            return; 
        }
    }
   
}
    public ArrayList<User> getSearchResults(String searchTerm){
        ArrayList<User> searchResults = new ArrayList<User>();
        for(User u: user){
           if(u.getId() == Integer.parseInt(searchTerm)){
                searchResults.add(u);
            }
        }
       return searchResults;
    }
    
    public void updateUser(int id, String newFirstName, String newLastName) {
    for (User user : user) {
        if (user.getId() == id) {
            user.setFname(newFirstName);
            user.setLname(newLastName);
            return; 
        }
    }
    
}

}
