package course.register.demo.mapper;

import course.register.demo.model.PhotoEmail;
import course.register.demo.repository.model.JPhotoEmail;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PhotoEmailMapper {
  public List<PhotoEmail> toModel(List<JPhotoEmail> jPhotoEmails) {
    return jPhotoEmails.stream().map(this::toModel).toList();
  }

  public PhotoEmail toModel(JPhotoEmail jPhotoEmail) {
    return PhotoEmail.builder()
        .id(jPhotoEmail.getId())
        .nameFile(jPhotoEmail.getNameFile())
        .email(jPhotoEmail.getEmail())
        .createdAt(jPhotoEmail.getCreatedAt())
        .build();
  }

  public List<JPhotoEmail> toEntity(List<PhotoEmail> photoEmails) {
    return photoEmails.stream().map(this::toEntity).toList();
  }

  public JPhotoEmail toEntity(PhotoEmail photoEmail) {
    return JPhotoEmail.builder()
        .id(photoEmail.id())
        .nameFile(photoEmail.nameFile())
        .email(photoEmail.email())
        .createdAt(photoEmail.createdAt())
        .build();
  }
}
