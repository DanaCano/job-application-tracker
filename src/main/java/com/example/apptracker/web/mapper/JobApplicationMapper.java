package com.example.apptracker.web.mapper;

import com.example.apptracker.domain.JobApplication;
import com.example.apptracker.web.dto.JobApplicationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobApplicationMapper {
  JobApplicationDto toDto(JobApplication entity);
  JobApplication toEntity(JobApplicationDto dto);
}
