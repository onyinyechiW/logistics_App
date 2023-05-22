package shita.utils;

import shita.model.User;
import shita.dto.request.RegisterUserRequest;
import shita.dto.response.RegisteredUserResponse;

public class Mapper {

    public static User map(RegisterUserRequest request) {
        User user = new User();
        user.setAddress(request.getAddress());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        return user;
    }
    public static RegisteredUserResponse map(User user) {
        RegisteredUserResponse response = new RegisteredUserResponse();
        response.setAddress(user.getAddress());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        return response;
    }
}
