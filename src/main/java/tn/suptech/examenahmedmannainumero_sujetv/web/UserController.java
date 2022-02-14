package tn.suptech.examenahmedmannainumero_sujetv.web;

import org.springframework.web.bind.annotation.*;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Eleve;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Enseignant;
import tn.suptech.examenahmedmannainumero_sujetv.entities.User;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Admnistrateur;
import tn.suptech.examenahmedmannainumero_sujetv.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/gestionUser")
public class UserController {
    private UserService userService ;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/users")
    public List<User> getAllUsers(){
        return userService.getAll();
    }
    @RequestMapping(path="/user/{id}")
    public  User getUserById(@PathVariable Long id){
        return  userService.getOne(id);
    }

    @RequestMapping(path = "/admins")
    public List<User> getAllAdmins(){
        return userService.getAll().stream().filter(u->u.getClass().equals(Admnistrateur.class)).collect(Collectors.toList());
    }
    @RequestMapping(path = "/eleves")
    public List<User> getAllEleves(){
        return userService.getAll().stream().filter(u->u.getClass().equals(Eleve.class)).collect(Collectors.toList());
    }
    @RequestMapping(path = "/enseignants")
    public List<User> getAllEnseignants(){
        return userService.getAll().stream().filter(u->u.getClass().equals(Enseignant.class)).collect(Collectors.toList());
    }
    //creation des users
    @PostMapping("user/admin")
    public  User createAdmin(@RequestBody Admnistrateur admnistrateur){
        return userService.add(admnistrateur);
    }
    @PostMapping("user/eleve")
    public  User createAdmin(@RequestBody Eleve eleve){
        return userService.add(eleve);
    }
    @PostMapping("user/enseignant")
    public  User createAdmin(@RequestBody Enseignant enseignant){
        return userService.add(enseignant);
    }


    // update users

    @PutMapping("user/admin")
    public  User updateAdmin(@RequestBody Admnistrateur admnistrateur){
        return userService.update(admnistrateur);
    }
    @PutMapping("user/eleve")
    public  User updateAdmin(@RequestBody Eleve eleve){
        return userService.update(eleve);
    }
    @PutMapping("user/enseignant")
    public  User updateAdmin(@RequestBody Enseignant enseignant){
        return userService.update(enseignant);
    }


    //delete user
    @DeleteMapping (path="/user/{id}")
    public  User deleteUser(@PathVariable Long id){
        return  userService.delete(id);
    }







}
