package com.example.meeting.controller;

import com.example.meeting.model.User;
import com.example.meeting.repository.UserRepository;
import com.example.meeting.security.JwtUtil;

import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.Map;

@RestController
@RequestMapping("/auth")

@Tag(
        name = "1️⃣ Authentication APIs",
        description = "Step 1: Register and login to generate a JWT token. This token is required to access all Meeting Room APIs."
)

public class AuthController {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public AuthController(JwtUtil jwtUtil, UserRepository userRepository){
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @Operation(
            summary = "Register a new user",
            description = """
        Creates a new user account.

        Example request:
        {
          "username": "rahul",
          "password": "1234"
        }

        After registering, use the login API to generate a JWT token.
        """
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User registered successfully")
    })

    @PostMapping("/register")
    public String register(@RequestBody User user){

        if(userRepository.findByUsername(user.getUsername()).isPresent()){
            throw new RuntimeException("User already exists");
        }

        userRepository.save(user);

        return "User registered successfully";
    }


    @Operation(
            summary = "Login and generate JWT token",
            description = """
        Authenticates the user and returns a JWT token.

        Example request:
        {
          "username": "rahul",
          "password": "1234"
        }

        Copy the token from the response.

        Then click the 'Authorize' button in Swagger and paste:

        Bearer <your_token>
        """
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login successful"),
            @ApiResponse(responseCode = "401", description = "Invalid credentials")
    })

    @PostMapping("/login")
    public Map<String,String> login(@RequestBody User request){

        User user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!user.getPassword().equals(request.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getUsername());

        return Map.of("token", token);
    }

}