package com.example.apptracker;

import com.example.apptracker.domain.JobApplication;
import com.example.apptracker.repo.JobApplicationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
class JobApplicationIntegrationTest {

  // Imagen declarada explícitamente y marcada como compatible con el módulo Postgres
  private static final DockerImageName POSTGRES_IMAGE =
      DockerImageName.parse("postgres:16-alpine")
                     .asCompatibleSubstituteFor("postgres");

  @Container
  @SuppressWarnings("resource") // El ciclo de vida lo gestiona Testcontainers
  static final PostgreSQLContainer<?> postgres =
      new PostgreSQLContainer<>(POSTGRES_IMAGE)
          .withDatabaseName("apptracker")
          .withUsername("apptracker")
          .withPassword("apptracker");

  @DynamicPropertySource
  static void registerProps(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", postgres::getJdbcUrl);
    registry.add("spring.datasource.username", postgres::getUsername);
    registry.add("spring.datasource.password", postgres::getPassword);
    registry.add("spring.flyway.enabled", () -> false);
    registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
  }

  @Autowired JobApplicationRepository repo;

  @Test
  void persistsEntity() {
    var ja = new JobApplication();
    ja.setCompany("Wayne Enterprises");
    ja.setPosition("Java Engineer");
    assertThat(repo.save(ja).getId()).isNotNull();
  }
}
