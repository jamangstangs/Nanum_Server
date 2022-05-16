package com.nanum.nanumserver;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@Sql(value = "/clear.sql")
@ActiveProfiles(profiles = "test")
@SpringBootTest
public abstract class IntegrityTest {
}
