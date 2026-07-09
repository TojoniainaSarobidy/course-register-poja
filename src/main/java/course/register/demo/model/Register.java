package course.register.demo.model;

import java.time.Instant;
import java.util.UUID;
import lombok.Builder;

@Builder
public record Register(
    UUID id, Instant createdAt, RegisterStatus registerStatus, Course course, User user) {}
