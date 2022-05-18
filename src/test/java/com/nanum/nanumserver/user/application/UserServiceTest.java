package com.nanum.nanumserver.user.application;

import com.nanum.nanumserver.IntegrityTest;
import com.nanum.nanumserver.user.domain.UserRepository;
import com.nanum.nanumserver.user.dto.request.SignUpRequest;
import com.nanum.nanumserver.utils.password.Encoder;
import com.nanum.nanumserver.verification.application.password.FindPasswordValidator;
import com.nanum.nanumserver.verification.application.signup.SignUpValidator;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest extends IntegrityTest {
    private static final String GIST_EMAIL = "tester@gist.ac.kr";
    private static final String PASSWORD = "password!";
    private static final String VERIFICATION_CODE = "AAAAA";
    private static final SignUpRequest DEFAULT_SIGN_UP_REQUEST = new SignUpRequest(GIST_EMAIL, PASSWORD, VERIFICATION_CODE);

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Encoder encoder;
    @MockBean
    private SignUpValidator signUpValidator;
    @MockBean
    private FindPasswordValidator passwordValidator;

    @BeforeEach
    void setUp() {
        doNothing().when(signUpValidator).checkIsVerified(any(), eq(VERIFICATION_CODE));
        doNothing().when(passwordValidator).checkIsVerified(any(), eq(VERIFICATION_CODE));
    }



}