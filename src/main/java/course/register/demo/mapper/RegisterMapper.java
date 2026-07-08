package course.register.demo.mapper;

import course.register.demo.endpoint.rest.controller.health.dto.RegisterRequest;
import course.register.demo.model.Register;
import course.register.demo.model.RegisterStatus;
import course.register.demo.repository.model.JRegister;
import course.register.demo.service.CourseService;
import course.register.demo.service.UserService;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegisterMapper {
  private final UserService userService;
  private final CourseService courseService;
  private final UserMapper userMapper;
  private final CourseMapper courseMapper;

  public List<Register> registers(List<JRegister> registers) {
    return registers.stream().map(this::toModel).toList();
  }

  public Register toModel(JRegister jRegister) {
    return Register.builder()
        .id(jRegister.getId())
        .createdAt(jRegister.getCreatedAt())
        .status(jRegister.getRegisterStatus())
        .user(jRegister.getId())
        .status(jRegister.getRegisterStatus())
        .build();
  }

  public JRegister toEntity(Register register) {
    var user = userService.getById(register.id());
    var course = courseService.getById(register.id());
    return JRegister.builder()
        .id(register.id())
        .createdAt(register.createdAt())
        .registerStatus(register.status())
        .user(userMapper.toEntity(user))
        .course(courseMapper.toEntity(course))
        .build();
  }

  public JRegister toEntity(UUID id, RegisterRequest registerRequest) {
    var course = courseService.getById(id);
    var user = userService.getById(registerRequest.userId());
    return JRegister.builder()
        .id(UUID.randomUUID())
        .createdAt(Instant.now())
        .registerStatus(RegisterStatus.ACTIVE)
        .course(courseMapper.toEntity(course))
        .user(userMapper.toEntity(user))
        .build();
  }
}
