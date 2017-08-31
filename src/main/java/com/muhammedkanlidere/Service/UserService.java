package com.muhammedkanlidere.Service;

import com.muhammedkanlidere.Dao.FakeUserDao;
import com.muhammedkanlidere.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.management.BadAttributeValueExpException;
import javax.management.BadStringOperationException;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    @Qualifier("fakeData")
    private FakeUserDao fakeUserDao;

    public Collection<User> getAllUsers(){
        return fakeUserDao.getAllUsers();
    }
    public User getUserById(int id){
        if(fakeUserDao.users.containsKey(id)){
            return fakeUserDao.getUserById(id);
        }else{
            throw new InputMismatchException();
        }
    }

    public void removeUserById(int id) {
        if(fakeUserDao.users.containsKey(id)){
            this.fakeUserDao.removeStudentById(id);
        }else{
            throw new InputMismatchException();
        }
    }

    public void updateUser(User user){
        if(this.fakeUserDao.users.containsKey(user.getId())){
            this.fakeUserDao.updateUser(user);
        }else{
            throw new InputMismatchException();
        }
    }

    public boolean insertUser(User user) {
        try{
           int id = this.fakeUserDao.getBiggestId()+1;
           user.setId(id);
           this.fakeUserDao.insertUser(user);
           return true;
        }catch (Exception ex){
            return  false;
        }
    }
}
