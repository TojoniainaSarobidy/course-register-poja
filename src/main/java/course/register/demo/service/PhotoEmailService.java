package course.register.demo.service;

import course.register.demo.endpoint.event.EventProducer;
import course.register.demo.endpoint.event.model.PhotoEmailCreated;
import course.register.demo.file.bucket.BucketComponent;
import course.register.demo.mapper.PhotoEmailMapper;
import course.register.demo.model.PhotoEmail;
import course.register.demo.repository.PhotoEmailRepository;
import java.io.File;
import java.nio.file.Files;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class PhotoEmailService {
  private final PhotoEmailRepository photoEmailRepository;
  private final BucketComponent bucketComponent;
  private final PhotoEmailMapper photoEmailMapper;
  private final EventProducer eventProducer;

  public List<PhotoEmail> findAll() {
    return photoEmailMapper.toModel(photoEmailRepository.findAll());
  }

  @SneakyThrows
  public PhotoEmail submit(String email, MultipartFile image) {
    var id = UUID.randomUUID();
    var nameFile = id + "-" + image.getOriginalFilename();

    var tempFile = File.createTempFile("upload-", ".png");
    Files.write(tempFile.toPath(), image.getBytes());

    bucketComponent.upload(tempFile, nameFile);

    var photoEmail = new PhotoEmail(id, nameFile, email, Instant.now());
    var entityToSave = photoEmailMapper.toEntity(photoEmail);
    var savedEntity = photoEmailRepository.save(entityToSave);

    eventProducer.accept(List.of(new PhotoEmailCreated(photoEmailMapper.toModel(savedEntity))));

    return photoEmailMapper.toModel(savedEntity);
  }
}
