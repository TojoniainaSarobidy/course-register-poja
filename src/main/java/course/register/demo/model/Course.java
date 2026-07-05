package course.register.demo.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record Course(UUID id, String title, Instant startDate, Instant endDate, List<User> users) {}
