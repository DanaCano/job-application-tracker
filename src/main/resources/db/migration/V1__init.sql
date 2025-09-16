CREATE TABLE job_application (
  id BIGSERIAL PRIMARY KEY,
  company VARCHAR(255) NOT NULL,
  position VARCHAR(255) NOT NULL,
  status VARCHAR(50) NOT NULL,
  applied_date DATE,
  notes TEXT
);
