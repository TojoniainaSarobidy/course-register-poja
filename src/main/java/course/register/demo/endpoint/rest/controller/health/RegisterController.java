package course.register.demo.endpoint.rest.controller.health;

import course.register.demo.model.Register;
import course.register.demo.service.RegisterService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegisterController {
  private final RegisterService registerService;

  @GetMapping("/registers")
  public List<Register> registers() {
    return registerService.registers();
  }

  @GetMapping("/registers/{id}")
  public Register getById(@PathVariable UUID id) {
    return registerService.getById(id);
  }
}
