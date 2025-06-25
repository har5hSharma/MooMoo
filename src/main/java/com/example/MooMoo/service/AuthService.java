package com.example.MooMoo.service;

import com.example.MooMoo.dto.AuthResponseDTO;
import com.example.MooMoo.dto.LoginDTO;
import com.example.MooMoo.model.User;
import com.example.MooMoo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepository;

    public AuthResponseDTO authenticate(LoginDTO loginDTO) {
        Optional<User> userOpt = userRepository.findById(loginDTO.getEmail_id());

        if (userOpt.isPresent()) {
            throw new RuntimeException("User not found");
        }

        User user = userOpt.get();

        // If token is missing: validate credentials and generate new token
        if (loginDTO.getAuth_token() == null || loginDTO.getAuth_token().isEmpty()) {
            if (!user.getUser_pass().equals(loginDTO.getUser_pass())) {
                throw new RuntimeException("Invalid credentials");
            }
            // Generate new token and optionally set expiry (future enhancement)
            String newToken = UUID.randomUUID().toString();
            user.setAuth_token(newToken);
        }

        // Update location if provided
        GeoJsonPoint newLocation = loginDTO.getLocation();
        if (newLocation != null) {
            user.setLocation(newLocation);
        }

        userRepository.save(user);

        return new AuthResponseDTO(user);
    }
}
