package com.nanum.nanumserver.verification.application.signup;

import com.nanum.nanumserver.exception.verification.InvalidVerificationInfoException;
import com.nanum.nanumserver.exception.verification.NoSuchVerificationCodeException;
import com.nanum.nanumserver.exception.verification.NotConfirmedVerificationCodeException;
import com.nanum.nanumserver.verification.domain.SignUpVerificationInfo;
import com.nanum.nanumserver.verification.domain.SignUpVerificationInfoRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SignUpValidatorImpl implements SignUpValidator {

    private final SignUpVerificationInfoRepository signUpVerificationInfoRepository;

    public SignUpValidatorImpl(SignUpVerificationInfoRepository signUpVerificationInfoRepository) {
        this.signUpVerificationInfoRepository = signUpVerificationInfoRepository;
    }

    @Override
    public void checkIsVerified(String username, String verificationCode) {
        SignUpVerificationInfo verificationInfo = signUpVerificationInfoRepository.findByUsernameAndVerificationCode(username, verificationCode)
                .orElseThrow(NoSuchVerificationCodeException::new);
        if (!verificationInfo.isConfirmed()) {
            throw new NotConfirmedVerificationCodeException();
        }

        if (!verificationInfo.isConfirmationValidAt(LocalDateTime.now())) {
            throw new InvalidVerificationInfoException();
        }
    }
}
