package com.example.apptracker;

import com.example.apptracker.domain.JobApplication;
import com.example.apptracker.service.JobApplicationService;
import com.example.apptracker.repo.JobApplicationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

class JobApplicationServiceTest {
  @Test
  void createAndList(){
    var repo = Mockito.mock(JobApplicationRepository.class);
    var svc = new JobApplicationService(repo);
    var ja = new JobApplication();
    ja.setCompany("Acme"); ja.setPosition("Backend Dev");
    Mockito.when(repo.save(Mockito.any())).thenReturn(ja);
    Mockito.when(repo.findAll()).thenReturn(List.of(ja));

    var saved = svc.create(ja);
    assertThat(saved.getCompany()).isEqualTo("Acme");
    assertThat(svc.all()).hasSize(1);
  }
}
