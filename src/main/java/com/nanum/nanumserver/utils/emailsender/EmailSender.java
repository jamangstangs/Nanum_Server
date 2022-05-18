package com.nanum.nanumserver.utils.emailsender;

import java.util.List;

public interface EmailSender {
    void send(String to, String subject, String content);

    void send(List<String> to, String subject, String content);
}
