package co.nilin.oauth2.demo.data.repository;

import co.nilin.oauth2.demo.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

   @Autowired
   UserRepository userRepository;

    public User findUserByUsername(String username){
        User user=userRepository.findUserByUsername(username);
        return user;
    }

}
