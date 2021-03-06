package com.nanum.nanumserver.user.application;

import com.nanum.nanumserver.IntegrityTest;
import com.nanum.nanumserver.exception.user.NoSuchUserException;
import com.nanum.nanumserver.exception.user.NotMatchedPasswordException;
import com.nanum.nanumserver.user.domain.SimpleUser;
import com.nanum.nanumserver.user.domain.User;
import com.nanum.nanumserver.user.domain.UserRepository;
import com.nanum.nanumserver.user.dto.request.SignInRequest;
import com.nanum.nanumserver.utils.password.Encoder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

public class LoginServiceTest extends IntegrityTest {
    private static final String GIST_EMIAL = "tester@gist.ac.kr";
    private static final String PASSWORD = "password";

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Encoder encoder;

    @Test
    void SignIn() {
        User registerdUser = userRepository.save(new User(GIST_EMIAL, encoder.hashPassword(PASSWORD)));
        SignInRequest signInRequest = new SignInRequest(GIST_EMIAL, PASSWORD);

        loginService.login(signInRequest);

        SimpleUser simpleUser = loginService.getLoginUser();
        assertThat(simpleUser.getId()).isEqualTo(registerdUser.getId());
    }

    @Test
    void signInFailedIfNotValidUsername() {
        userRepository.save(new User(GIST_EMIAL, encoder.hashPassword(PASSWORD)));
        String faceUsername = "wrong@gist.ac.kr";
        SignInRequest signInRequest = new SignInRequest(faceUsername, PASSWORD);

        assertThatThrownBy(
                () -> loginService.login(signInRequest)
        ).isInstanceOf(NoSuchUserException.class);
        assertThat(loginService.getLoginUser()).isNull();
    }

    @Test
    void signInFailedIfNoteValidPassword() {
        userRepository.save(new User(GIST_EMIAL, encoder.hashPassword(PASSWORD)));
        String fakePassword = "fake";
        SignInRequest signInRequest = new SignInRequest(GIST_EMIAL, fakePassword);

        assertThatThrownBy(
                () -> loginService.login(signInRequest)
        ).isInstanceOf(NotMatchedPasswordException.class);
        assertThat(loginService.getLoginUser()).isNull();
    }
}
