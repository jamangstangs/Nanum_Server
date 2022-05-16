package com.nanum.nanumserver.user.application;

import com.nanum.nanumserver.config.annotation.DataIntegrityHandler;
import com.nanum.nanumserver.exception.user.DuplicatedUserException;
import com.nanum.nanumserver.exception.user.NoSuchUserException;
import com.nanum.nanumserver.exception.user.NotMatchedPasswordException;
import com.nanum.nanumserver.user.domain.User;
import com.nanum.nanumserver.user.domain.UserRepository;
import com.nanum.nanumserver.user.dto.request.DeleteUserRequest;
import com.nanum.nanumserver.user.dto.request.SignUpRequest;
import com.nanum.nanumserver.user.dto.request.UpdatePasswordRequest;
import com.nanum.nanumserver.utils.password.Encoder;
import com.nanum.nanumserver.verification.application.password.FindPasswordValidator;
import com.nanum.nanumserver.verification.application.signup.SignUpValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final Encoder encoder;
    private final SignUpValidator signUpValidator;
    private final FindPasswordValidator findPasswordValidator;

    @Transactional
    @DataIntegrityHandler(DuplicatedUserException.class)
    public Long signUP(SignUpRequest request) {
        String username = request.getUsername();

        if (userRepository.existsByUsername(username)) {
            throw new DuplicatedUserException();
        }

        if(!EmailDo)

        User user = new User(username, encoder.hashPassword(request.getPassword()));
        return userRepository.save(user).getId();

    }

    @Transactional(readOnly = true)
    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(NoSuchUserException::new);
    }

    @Transactional(readOnly = true)
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(NoSuchUserException::new);
    }

    @Transactional
    public void updatePassword(Long userId, UpdatePasswordRequest passwordRequest) throws NotMatchedPasswordException {
        User user = findUserById(userId);
        if (!encoder.isMatch(passwordRequest.getOriginPassword(), user.getPassword())) {
            throw new NotMatchedPasswordException();
        }
        user.setPassword(encoder.hashPassword(passwordRequest.getNewPassword()));
    }

    @Transactional
    public void deleteUser(String username) {
        User user = findUserByUsername(username);
        userRepository.delete(user);
    }

    @Transactional
    public void deleteUserOfMind(Long userId, DeleteUserRequest deleteUserRequest) throws NotMatchedPasswordException {
        User user = findUserById(userId);
        if (!encoder.isMatch(deleteUserRequest.getPassword(), user.getPassword())) {
            throw new NotMatchedPasswordException();
        }
        userRepository.deleteById(userId);
    }

}
