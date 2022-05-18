package com.nanum.nanumserver;

import com.nanum.nanumserver.utils.emailsender.EmailSender;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@Sql(value = "/clear.sql")
@ActiveProfiles(profiles = "test")
@SpringBootTest
public abstract class IntegrityTest {
    @MockBean
    EmailSender emailSender;
}
