package br.com.andersonsilva.user_crud.controllers;

import br.com.andersonsilva.user_crud.error.EntityNotFoundException;
import br.com.andersonsilva.user_crud.model.User;
import br.com.andersonsilva.user_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("list/{id}")
    public User user(@PathVariable("id") Long id){
    Optional<User> userFind =this.userRepository.findById(id);

    if(userFind.isPresent()){
      return userFind.get();
    }

    throw new EntityNotFoundException("User not found");

    }
    @PostMapping("/save")
    public  User user(@RequestBody User user){

        return this.userRepository.save(user);

        }

    @GetMapping("/list")
    public List<User> list(){
        return this.userRepository.findAll();
    }

    @GetMapping("/getName/{name}")
    public List<User> findByName(@PathVariable("name") String name){

          List<User> listUser= this.userRepository.findByNameIgnoreCase(name);
        System.out.println(listUser);
          if(listUser.size()>0){
              return  listUser;
          }else {
              throw new EntityNotFoundException("User not found");
          }
    }
    @DeleteMapping("/delete/{id}")
    public  User deleteUser(@PathVariable("id")Long id){

            Optional<User> user = this.userRepository.findById(id);
            if (user != null) {
                this.userRepository.delete(user.get());
            }
            return user.get();
    }
    @PutMapping("/update/{id}")
    public  User userUpdate(@PathVariable("id")Long id,@RequestBody User user){

            this.userRepository.updateUser(user.getName(), user.getUsername(),id);
            return this.userRepository.findById(id).get();

    }



}
