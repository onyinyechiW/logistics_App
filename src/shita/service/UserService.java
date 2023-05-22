package shita.service;

import shita.dto.request.RegisterUserRequest;
import shita.dto.response.RegisteredUserResponse;

public interface UserService {
    RegisteredUserResponse registerNewUser(RegisterUserRequest request);
    RegisteredUserResponse findUser(String id);
}
