package shita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shita.dto.request.RegisterUserRequest;
import shita.dto.response.RegisteredUserResponse;
import shita.model.User;
import shita.service.UserServiceImplementation;
import shita.service.UserService;

@RestController
public class UserController {
    private UserService userService;


    @PostMapping("/user")
    public ResponseEntity<?> registerNewUser(@RequestBody RegisterUserRequest request){
        var response = userService.registerNewUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findUserById(@PathVariable String id){
      try {
          return new ResponseEntity<>(new ApiResponse(true,userService.findUser(id)),HttpStatus.FOUND);
      }
      catch (IllegalArgumentException ex){
          return new ResponseEntity<>(new ApiResponse(false,ex.getMessage()),HttpStatus.NOT_FOUND);
      }
    }
}
