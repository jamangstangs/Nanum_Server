package com.nanum.nanumserver.user.application;

import com.nanum.nanumserver.user.domain.SimpleUser;
import com.nanum.nanumserver.user.dto.request.SignInRequest;

public interface LoginService {
    void login(SignInRequest request);

    void logout();

    SimpleUser getLoginUser();
}
