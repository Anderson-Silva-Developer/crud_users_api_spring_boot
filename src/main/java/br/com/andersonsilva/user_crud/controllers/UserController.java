package br.com.andersonsilva.user_crud.controllers;

import br.com.andersonsilva.user_crud.model.User;
import br.com.andersonsilva.user_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id){
    Optional<User> userFind =this.userRepository.findById(id);
    if(userFind.isPresent()){
      return userFind.get();
    }
    return null;
    }
    @PostMapping("/save")
    public  User user(@RequestBody User user){
        return this.userRepository.save(user);
    }
    @GetMapping("/list")
    public List<User> list(){
        return this.userRepository.findAll();
    }
    @GetMapping("/list/{id}")
    public List<User> listMoreThan(@PathVariable("id")Long id){
        return this.userRepository.findByIdGreaterThan(id);
    }
    @GetMapping("/getName/{name}")
    public List<User> findByName(@PathVariable("name") String name){
        return this.userRepository.findByNameIgnoreCase(name);
    }
    @PostMapping("delete/{id}")
    public  User deleteUser(@PathVariable("id")Long id){
        Optional<User> user =this.userRepository.findById(id);
         if(user!=null){
             this.userRepository.delete(user.get());
         }
         return user.get();
    }
    @PostMapping("/update")
    public  User userUpdate(@RequestBody User user){
        this.userRepository.updateUser(user.getName(),user.getUsername(),user.getId());
        return this.userRepository.findById(user.getId()).get();
    }



}
