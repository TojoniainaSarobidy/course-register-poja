package course.register.demo.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "user_course")
@Entity
@Builder
public class JUser {
  @Id private UUID id;
  private String firstName;
  private String lastName;
  private String email;

  @ManyToMany(mappedBy = "users")
  private List<JCourse> courses;
}
