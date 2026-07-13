package course.register.demo.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "photo_email")
@Entity
@Builder
public class JPhotoEmail {
  @Id @GeneratedValue @UuidGenerator private UUID id;
  private String nameFile;
  private String email;
  private Instant createdAt;
}
