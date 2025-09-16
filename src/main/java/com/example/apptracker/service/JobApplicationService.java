package com.example.apptracker.service;

import com.example.apptracker.domain.JobApplication;
import com.example.apptracker.domain.ApplicationStatus;
import com.example.apptracker.repo.JobApplicationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobApplicationService {
  private final JobApplicationRepository repo;
  public JobApplicationService(JobApplicationRepository repo){ this.repo = repo; }

  public JobApplication create(JobApplication ja){ return repo.save(ja); }
  public List<JobApplication> all(){ return repo.findAll(); }
  public JobApplication get(Long id){ return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found")); }
  public JobApplication update(Long id, JobApplication data){
    JobApplication ja = get(id);
    ja.setCompany(data.getCompany());
    ja.setPosition(data.getPosition());
    ja.setStatus(data.getStatus());
    ja.setAppliedDate(data.getAppliedDate());
    ja.setNotes(data.getNotes());
    return repo.save(ja);
  }
  public void delete(Long id){ repo.deleteById(id); }
  public List<JobApplication> byStatus(ApplicationStatus s){ return repo.findByStatus(s); }
}
