package course.register.demo.model;

import java.time.Instant;
import java.util.UUID;
import lombok.Builder;

@Builder
public record Register(UUID id, Instant createdAt, RegisterStatus status, UUID course, UUID user) {}
