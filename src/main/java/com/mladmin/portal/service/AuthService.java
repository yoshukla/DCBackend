package com.mladmin.portal.service;

import com.mladmin.portal.dto.LoginInput;
import com.mladmin.portal.dto.AuthResponse;
import com.mladmin.portal.entity.UserMaster;
import com.mladmin.portal.repository.UserMasterRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

import javax.crypto.SecretKey;

@Service
public class AuthService {
   
    private final UserMasterRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    private static final long EXPIRATION_TIME = 3600000; // 1 hour
 // Generate a strong key for HS512
    private static final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public AuthService(UserMasterRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public AuthResponse login(LoginInput input) {
        Optional<UserMaster> userOpt = userRepository.findByCompanyId(input.getCompanyId());
        if (userOpt.isEmpty() || !passwordEncoder.matches(input.getPassword(), userOpt.get().getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        UserMaster user = userOpt.get();
        String token = generateToken(user);
        return new AuthResponse(token, user,"Login Succesfull");
    }

    private String generateToken(UserMaster user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
         
        return Jwts.builder()
                .setSubject(user.getCompanyId())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(secretKey, SignatureAlgorithm.HS512)
                .compact();
    }
}
