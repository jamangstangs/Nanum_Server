package com.nanum.nanumserver.verification.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SignUpVerificationInfoRepository extends JpaRepository<SignUpVerificationInfo, Long> {
    Optional<SignUpVerificationInfo> findByVerificationCode(String verificationCode);

    Optional<SignUpVerificationInfo> findByUsernameAndVerificationCode(String username, String verificationCode);

    List<SignUpVerificationInfo> findByUserName(String username);

    void deleteByUsername(String username);

}

