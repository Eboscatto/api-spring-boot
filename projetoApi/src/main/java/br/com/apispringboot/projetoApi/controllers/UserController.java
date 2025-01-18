package br.com.apispringboot.projetoApi.controllers;

import br.com.apispringboot.projetoApi.model.User;
import br.com.apispringboot.projetoApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLStreamHandlerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    // Cria uma lista de usuários
    private List<User> users = new ArrayList<>();

    // Injeta o Repository
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")

    /*
    // Busca um Id na lista
    public User user(@PathVariable("id") Long id) {
       Optional<User> userFind = users.stream().filter(user -> user.getId() == id).findFirst();
       if (userFind.isPresent()) {
           return userFind.get();
       }
        return null;
    }
     */

    // Busca um Id no banco de dados
    public User user(@PathVariable("id") Long id) {
        Optional<User> userFind = this.userRepository.findById(id);
        if (userFind.isPresent()) {
            return userFind.get();
        }
        return null;
    }


    /*
    // Adiciona um user na lista
    @PostMapping("/")
    public User user(@RequestBody User user) {
        users.add(user);
        return user;
    }
    */

    // Adiciona um user no banco de dados
    @PostMapping("/")
    public User user(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @GetMapping("/list")
        public List<User> list() {
        return this.userRepository.findAll();
        }

    @GetMapping("/list/{id}")
    public List<User> listMoreThan(@PathVariable("id")Long id) {
        return this.userRepository.findAllMoreThan(id);
    }

    @GetMapping("/lista/{id}")
    public List<User> listGreaterThan(@PathVariable("id")Long id) {
        return this.userRepository.findByIdGreaterThan(id);
    }

    @GetMapping("/nome/{name}")
    public List<User> listMoreThan(@PathVariable("name")String name) {
        return this.userRepository.findByNameIgnoreCase(name);
    }
}

