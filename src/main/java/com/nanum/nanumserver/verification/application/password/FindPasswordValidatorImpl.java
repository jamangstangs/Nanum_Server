package com.nanum.nanumserver.verification.application.password;

import com.nanum.nanumserver.exception.verification.InvalidVerificationInfoException;
import com.nanum.nanumserver.exception.verification.NoSuchVerificationCodeException;
import com.nanum.nanumserver.verification.domain.PasswordVerificationInfo;
import com.nanum.nanumserver.verification.domain.PasswordVerificationInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class FindPasswordValidatorImpl implements FindPasswordValidator {

    private final PasswordVerificationInfoRepository passwordVerificationInfoRepository;

    @Override
    public void checkIsVerified(String username, String verificationCode) {
        PasswordVerificationInfo verificationInfo = passwordVerificationInfoRepository.findByUsernameAndVerificationCode(username, verificationCode)
                .orElseThrow(NoSuchVerificationCodeException::new);

        if (!verificationInfo.isConfirmed()) {
            throw new NoSuchVerificationCodeException();
        }

        if (!verificationInfo.isConfirmationValidAt(LocalDateTime.now())) {
            throw new InvalidVerificationInfoException();
        }

    }
}
