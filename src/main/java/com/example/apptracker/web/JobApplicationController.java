package com.example.apptracker.web;

import com.example.apptracker.domain.ApplicationStatus;
import com.example.apptracker.service.JobApplicationService;
import com.example.apptracker.web.dto.JobApplicationDto;
import com.example.apptracker.web.mapper.JobApplicationMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {
  private final JobApplicationService service;
  private final JobApplicationMapper mapper;

  public JobApplicationController(JobApplicationService service, JobApplicationMapper mapper){
    this.service = service; this.mapper = mapper;
  }

  @GetMapping public List<JobApplicationDto> all(){
    return service.all().stream().map(mapper::toDto).toList();
  }

  @GetMapping("/{id}") public JobApplicationDto one(@PathVariable Long id){
    return mapper.toDto(service.get(id));
  }

  @GetMapping("/status/{status}") public List<JobApplicationDto> byStatus(@PathVariable ApplicationStatus status){
    return service.byStatus(status).stream().map(mapper::toDto).toList();
  }

  @PostMapping @ResponseStatus(HttpStatus.CREATED)
  public JobApplicationDto create(@RequestBody @Valid JobApplicationDto dto){
    return mapper.toDto(service.create(mapper.toEntity(dto)));
  }

  @PutMapping("/{id}") public JobApplicationDto update(@PathVariable Long id, @RequestBody @Valid JobApplicationDto dto){
    return mapper.toDto(service.update(id, mapper.toEntity(dto)));
  }

  @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id){ service.delete(id); }
}
