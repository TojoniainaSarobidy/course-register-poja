package course.register.demo.repository;

import course.register.demo.repository.model.JPhotoEmail;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoEmailRepository extends JpaRepository<JPhotoEmail, UUID> {}
