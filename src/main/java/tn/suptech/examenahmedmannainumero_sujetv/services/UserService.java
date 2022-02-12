package tn.suptech.examenahmedmannainumero_sujetv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.examenahmedmannainumero_sujetv.entities.User;
import tn.suptech.examenahmedmannainumero_sujetv.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    private  UserRepository _userRepository;

    public UserService(UserRepository _userRepository) {
        this._userRepository = _userRepository;
    }

    public List<User> getAll(){
        return _userRepository.findAll();
    }
    public User getOne(Long id){
        return _userRepository.findById(id).get();
    }
    public User add(User user){
        return  _userRepository.save(user);
    }

    public User update (User user){
        return  _userRepository.save(user);
    }

    public User delete (Long id ){
        User userDeletet=this.getOne(id);
        _userRepository.delete(userDeletet);
        return  userDeletet;
    }
}
