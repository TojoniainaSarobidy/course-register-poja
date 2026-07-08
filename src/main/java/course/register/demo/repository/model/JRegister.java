package course.register.demo.repository.model;

import course.register.demo.model.RegisterStatus;
import jakarta.persistence.*;
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
@Table(name = "register")
@Entity
@Builder
public class JRegister {
  @Id @GeneratedValue @UuidGenerator private UUID id;
  private Instant createdAt;
  private RegisterStatus registerStatus;

  @ManyToOne
  @JoinColumn(name = "course_id")
  private JCourse course;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private JUser user;
}
