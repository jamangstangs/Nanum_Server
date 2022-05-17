package com.nanum.nanumserver.user.application;

import com.nanum.nanumserver.IntegrityTest;
import com.nanum.nanumserver.user.dto.request.SignUpRequest;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest extends IntegrityTest {
    private static final String GIST_EMAIL = "tester@gist.ac.kr";
    private static final String PASSWORD = "password!";
    private static final String VERIFICATION_CODE = "AAAAA";
    private static final SignUpRequest DEFAULT_SIGN_UP_REQUEST = new SignUpRequest(GIST_EMAIL, PASSWORD, VERIFICATION_CODE);


}