package course.register.demo.service;

import course.register.demo.exception.NotFoundException;
import course.register.demo.mapper.RegisterMapper;
import course.register.demo.model.Register;
import course.register.demo.repository.RegisterRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterService {
  private final RegisterRepository registerRepository;
  private final RegisterMapper registerMapper;

  public List<Register> registers() {
    return registerMapper.toModel(registerRepository.findAll());
  }

  public Register getById(UUID id) {
    return registerMapper.toModel(
        registerRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundException("Register with id " + id + " not found")));
  }
}
