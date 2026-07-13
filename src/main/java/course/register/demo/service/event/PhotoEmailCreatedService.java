package course.register.demo.service.event;

import course.register.demo.endpoint.event.model.PhotoEmailCreated;
import course.register.demo.file.bucket.BucketComponent;
import course.register.demo.mail.Email;
import course.register.demo.mail.Mailer;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import java.time.Duration;
import java.util.List;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PhotoEmailCreatedService implements Consumer<PhotoEmailCreated> {
  private final BucketComponent bucketComponent;
  private final Mailer mailer;

  @Override
  @SneakyThrows
  public void accept(PhotoEmailCreated photoEmailCreated) {
    sendPhotoConfirmationEmail(photoEmailCreated.getPhotoEmail());
  }

  private void sendPhotoConfirmationEmail(course.register.demo.model.PhotoEmail photoEmail)
      throws AddressException {
    var presignedUrl =
        bucketComponent.presign(photoEmail.nameFile(), Duration.ofMinutes(5)).toString();

    var to = photoEmail.email();
    var subject = "Votre photo a bien été enregistrée";
    var htmlBody =
        """
        <html>
            <body>
                <p>Bonjour,</p>
                <p>Votre photo a bien été enregistrée avec succès.</p>
                <p>Vous pouvez la consulter via ce lien (valable 5 minutes) :</p>
                <p><a href="%s">%s</a></p>
                <p>Cordialement,<br>
                L'équipe</p>
            </body>
        </html>
        """
            .formatted(presignedUrl, presignedUrl);

    var email =
        new Email(new InternetAddress(to), List.of(), List.of(), subject, htmlBody, List.of());
    mailer.accept(email);
  }
}
