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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final Encoder encoder;
//    private final SignUpValidator signUpValidator;
//    private final FindPasswordValidator findPasswordValidator;

    // 회원가입 가입 서비스
    @Transactional
    @DataIntegrityHandler(DuplicatedUserException.class)
    public Long signUP(SignUpRequest request) {
//        String username = request.getUsername();
//        String verificationCode = request.getVerificationCode();
//
//        if (userRepository.existsByUsername(username)) {
//            throw new DuplicatedUserException();
//        }
//
//        if (!EmailDomain.has(EmailParser.parseDomainFrom(username))) {
//            throw new InvalidEmailFormException();
//        }
//        signUpValidator.checkIsVerified(username, verificationCode);
//
//        User user = new User(username, encoder.hashPassword(request.getPassword()));
//        return userRepository.save(user).getId();
        return 0L;
    }

    // Id로 유저 찾기
    @Transactional(readOnly = true)
    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(NoSuchUserException::new);
    }

    // username으로 유저 찾기
    @Transactional(readOnly = true)
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(NoSuchUserException::new);
    }


    // password 바꾸기
    @Transactional
    public void updatePassword(Long userId, UpdatePasswordRequest passwordRequest) throws NotMatchedPasswordException {
        User user = findUserById(userId);
        if (!encoder.isMatch(passwordRequest.getOriginPassword(), user.getPassword())) {
            throw new NotMatchedPasswordException();
        }
        user.setPassword(encoder.hashPassword(passwordRequest.getNewPassword()));
    }

    // 계정 삭제
    @Transactional
    public void deleteUser(String username) {
        User user = findUserByUsername(username);
        userRepository.delete(user);
    }

    // 내 계정 삭제
    @Transactional
    public void deleteUserOfMind(Long userId, DeleteUserRequest deleteUserRequest) throws NotMatchedPasswordException {
        User user = findUserById(userId);
        if (!encoder.isMatch(deleteUserRequest.getPassword(), user.getPassword())) {
            throw new NotMatchedPasswordException();
        }
        userRepository.deleteById(userId);
    }

}
