package com.taes.kim.dbisolationtest;

import java.io.File;

import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Tag("IntegrationTest")
@Testcontainers
@ActiveProfiles("junit-test")
@SpringBootTest
@AutoConfigureMockMvc
public abstract class IntegrationTest
{
    @Autowired
    protected MockMvc mockMvc;

    static final DockerComposeContainer composeContainer;

    static
    {
        composeContainer = new DockerComposeContainer(new File("src/test/resources/docker-compose.yml"));
        composeContainer.start();
    }
}
