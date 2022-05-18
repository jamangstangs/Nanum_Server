package com.nanum.nanumserver.verification.application.signup;

import com.nanum.nanumserver.verification.domain.SignUpVerificationInfoRepository;
import org.springframework.stereotype.Component;

@Component
public class SignUpValidatorImpl implements SignUpValidator {
    private final SignUpVerificationInfoRepository signUpVerificationInfoRepository;


}
