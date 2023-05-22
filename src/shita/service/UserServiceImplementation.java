package shita.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shita.model.User;
import shita.repository.UserRepository;
import shita.dto.request.RegisterUserRequest;
import shita.dto.response.RegisteredUserResponse;
import shita.utils.Mapper;

@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisteredUserResponse registerNewUser(RegisterUserRequest request) {
        User MappedUser = Mapper.map(request);
        User savedUser = userRepository.save(MappedUser);
        return Mapper.map(savedUser);
    }

    @Override
    public RegisteredUserResponse findUser(String id) {
        RegisteredUserResponse userResponse = new RegisteredUserResponse();
        User foundUser =  userRepository.findById(id).get();
        userResponse.setEmail(foundUser.getEmail());
        userResponse.setAddress(foundUser.getAddress());
        userResponse.setFirstName(foundUser.getFirstName());
        userResponse.setPhoneNumber(foundUser.getPhoneNumber());
        return userResponse;
    }
}

