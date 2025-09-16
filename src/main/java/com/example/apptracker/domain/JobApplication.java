package com.example.apptracker.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class JobApplication {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false) private String company;
  @Column(nullable = false) private String position;
  @Enumerated(EnumType.STRING) @Column(nullable = false)
  private ApplicationStatus status = ApplicationStatus.APPLIED;

  private LocalDate appliedDate = LocalDate.now();
  @Column(length = 2000) private String notes;

  public Long getId() { return id; }
  public String getCompany() { return company; }
  public void setCompany(String company) { this.company = company; }
  public String getPosition() { return position; }
  public void setPosition(String position) { this.position = position; }
  public ApplicationStatus getStatus() { return status; }
  public void setStatus(ApplicationStatus status) { this.status = status; }
  public LocalDate getAppliedDate() { return appliedDate; }
  public void setAppliedDate(LocalDate appliedDate) { this.appliedDate = appliedDate; }
  public String getNotes() { return notes; }
  public void setNotes(String notes) { this.notes = notes; }
}
