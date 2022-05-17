package com.nanum.nanumserver.user.application;

import com.nanum.nanumserver.exception.user.NoSuchUserException;
import com.nanum.nanumserver.exception.user.NotMatchedPasswordException;
import com.nanum.nanumserver.user.domain.SimpleUser;
import com.nanum.nanumserver.user.domain.User;
import com.nanum.nanumserver.user.domain.UserRepository;
import com.nanum.nanumserver.user.dto.request.SignInRequest;
import com.nanum.nanumserver.utils.password.Encoder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@AllArgsConstructor
public class SessionLoginService implements LoginService{

    public static final String SESSION_KEY = "user";
    private final HttpSession httpSession;
    private final UserRepository userRepository;
    private final Encoder encoder;

    @Override
    @Transactional(readOnly = true)
    public void login(SignInRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(NoSuchUserException::new);
        if (!encoder.isMatch(request.getPassword(), user.getPassword())) {
            throw new NotMatchedPasswordException();
        }
        httpSession.setAttribute(SESSION_KEY, new SimpleUser(user));
    }

    @Override
    public void logout() {
        httpSession.invalidate();
    }

    @Override
    public SimpleUser getLoginUser() {
        return (SimpleUser) httpSession.getAttribute(SESSION_KEY);
    }
}
