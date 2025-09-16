package com.example.apptracker.repo;

import com.example.apptracker.domain.JobApplication;
import com.example.apptracker.domain.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
  List<JobApplication> findByStatus(ApplicationStatus status);
}
