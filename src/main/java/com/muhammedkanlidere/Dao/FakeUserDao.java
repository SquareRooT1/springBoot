package com.muhammedkanlidere.Dao;

import com.muhammedkanlidere.Entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeUserDao implements UserDao {

    public static Map<Integer, User> users;

    //TODO  connect to db instead of static user.
    static {
        users = new HashMap<Integer, User>(){
            {
                put(1, new User(1,"Muhammed", "Kanlıdere", "Istanbul/Turkey"));
                put(2, new User(2,"Mustafa", "Kanlıdere", "Adana/Turkey"));
                put(3, new User(3,"Emre", "Ates", "Adana/Turkey"));
            }
        };
    }

    @Override
    public Collection<User> getAllUsers(){

        return this.users.values();
    }

    @Override
    public User getUserById(int id){
        return this.users.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        this.users.remove(id);
    }

    @Override
    public void updateUser(User user){
        User tempUser = users.get(user.getId());

        tempUser.setName(user.getName() == null ? tempUser.getName() : user.getName());
        tempUser.setSurname(user.getSurname() == null ? tempUser.getSurname() : user.getSurname());
        tempUser.setAddress(user.getAddress() == null ? tempUser.getAddress() : user.getAddress());
        users.put(user.getId(),tempUser);
    }

    @Override
    public void insertUser(User user) {
        this.users.put(user.getId(), user);
    }

    public int getBiggestId(){
        int maxId = 0;
        for (int i = 1 ; i <= this.users.size(); i++){
            if (this.users.containsKey(i)){
                int currentId = this.users.get(i).getId();
                if(currentId > maxId){
                    maxId = currentId;
                }
            }

        }
        return maxId++;
    }
}
