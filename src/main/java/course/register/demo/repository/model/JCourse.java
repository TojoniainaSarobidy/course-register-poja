package course.register.demo.repository.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "course")
@Entity
@Builder
public class JCourse {
  @GeneratedValue @UuidGenerator @Id private UUID id;
  private String title;
  private Instant startDate;
  private Instant endDate;

  @ManyToMany
  @JoinTable(
      name = "register",
      joinColumns = @JoinColumn(name = "id_course"),
      inverseJoinColumns = @JoinColumn(name = "id_user"))
  private List<JUser> users;
}
