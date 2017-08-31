package com.muhammedkanlidere.Controller;

import com.muhammedkanlidere.Entity.User;
import com.muhammedkanlidere.Service.UserService;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        try
        {
            User tempUser = userService.getUserById(id);
            return new ResponseEntity<User>(tempUser, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

    }
    @CrossOrigin
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUserById(@PathVariable("id") int id){
        try{
            User removedUser = userService.getUserById(id);
            userService.removeUserById(id);
            return new ResponseEntity<User>(removedUser,HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody User user){
        try{
            userService.updateUser(user);
            return new ResponseEntity<User>(user,HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> insertUser(@RequestBody User user){

        if(userService.insertUser(user)){
            return new ResponseEntity<User>(user,HttpStatus.OK);
        }else{
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

}
