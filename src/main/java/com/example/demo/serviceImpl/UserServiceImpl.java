package com.example.demo.serviceImpl;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.request.CustomerRequestDTO;
import com.example.demo.dto.request.UserRequestDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Person;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserEntity save(UserRequestDTO userRequestDTO) {
        return userRepository.save(convertToCustomer(userRequestDTO));
    }

    public UserEntity convertToCustomer(UserRequestDTO userRequestDTO) {

        Person person = new Person();
        person.setName(userRequestDTO.getName());
        person.setLastName(userRequestDTO.getLastName());
        person.setPhoneNumber(userRequestDTO.getPhoneNumber());
        person.setCedula(userRequestDTO.getCedula());

        UserEntity user = new UserEntity();

        user.setPerson(person);
        user.setUsername(person.getName());
        return user;
    }
}
