package com.online.shopping_back.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.online.shopping_back.dto.request.auth.SignInRequestDto;
import com.online.shopping_back.dto.request.auth.SignUpRequestDto;
import com.online.shopping_back.dto.response.ResponseDto;
import com.online.shopping_back.dto.response.auth.SignInResponseDto;
import com.online.shopping_back.dto.response.auth.SignUpResponseDto;
import com.online.shopping_back.entity.UserEntity;
import com.online.shopping_back.provider.JwtProvider;
import com.online.shopping_back.service.AuthService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.online.shopping_back.repository.UserRepository;

import org.springframework.http.ResponseEntity;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {
    
    private final UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {
        
        try {
    
            String email = dto.getEmail();
            String nickname = dto.getNickname();
            String telNumber = dto.getTelNumber();

            boolean hasEmail = userRepository.existsByEmail(email);
            if (hasEmail) return SignUpResponseDto.duplicateEmail();

            boolean hasNickname = userRepository.existsByNickname(nickname);
            if (hasNickname) return SignUpResponseDto.duplicateNickname();

            boolean hasTelNumber = userRepository.existsByTelNumber(telNumber);
            if (hasTelNumber) return SignUpResponseDto.duplicateTelNumber();            

            String password = dto.getPassword();
            String encodedPassword = passwordEncoder.encode(password);

            dto.setPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SignUpResponseDto.success();
    }

    private final JwtProvider jwtProvider;

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {

        String token = null;

        try {

            String email = dto.getEmail();
            
            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return SignInResponseDto.signInFailed();
            
            String password = dto.getPassword();
            String encodedPassword = userEntity.getPassword();

            boolean isMatched = passwordEncoder.matches(password, encodedPassword);
            if (!isMatched) return SignInResponseDto.signInFailed();
            
            token = jwtProvider.create(email);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SignInResponseDto.success(token);
    }
    

    
}
