package course.register.demo.endpoint.rest.controller.health;

import course.register.demo.model.PhotoEmail;
import course.register.demo.service.PhotoEmailService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
public class PhotoEmailController {
  private final PhotoEmailService photoEmailService;

  @GetMapping("/photo-email")
  public List<PhotoEmail> findAll() {
    return photoEmailService.findAll();
  }

  @PostMapping("/photo-email")
  public PhotoEmail submit(@RequestParam String email, @RequestParam("image") MultipartFile image) {
    return photoEmailService.submit(email, image);
  }
}
