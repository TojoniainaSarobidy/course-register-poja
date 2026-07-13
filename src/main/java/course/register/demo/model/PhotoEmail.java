package course.register.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.Instant;
import java.util.UUID;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PhotoEmail(UUID id, String nameFile, String email, Instant createdAt) {}
