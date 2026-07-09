package course.register.demo.mapper;

import course.register.demo.model.Register;
import course.register.demo.repository.model.JRegister;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegisterMapper {
  private final UserMapper userMapper;
  private final CourseMapper courseMapper;

  public List<Register> toModel(List<JRegister> jRegisters) {
    return jRegisters.stream().map(this::toModel).toList();
  }

  public Register toModel(JRegister jRegister) {
    return Register.builder()
        .id(jRegister.getId())
        .createdAt(jRegister.getCreatedAt())
        .registerStatus(jRegister.getRegisterStatus())
        .user(userMapper.toModel(jRegister.getJUser()))
        .course(courseMapper.toModel(jRegister.getJCourse()))
        .build();
  }

  public List<Register> toModelWithoutCourse(List<JRegister> jRegisters) {
    return jRegisters.stream().map(this::toModelWithoutCourse).toList();
  }

  public Register toModelWithoutCourse(JRegister jRegister) {
    return Register.builder()
        .id(jRegister.getId())
        .createdAt(jRegister.getCreatedAt())
        .registerStatus(jRegister.getRegisterStatus())
        .user(userMapper.toModel(jRegister.getJUser()))
        .build();
  }

  public List<JRegister> toEntity(List<Register> registers) {
    return registers.stream().map(this::toEntity).toList();
  }

  public JRegister toEntity(Register register) {
    return JRegister.builder()
        .id(register.id())
        .createdAt(register.createdAt())
        .registerStatus(register.registerStatus())
        .jUser(userMapper.toEntity(register.user()))
        .jCourse(courseMapper.toEntity(register.course()))
        .build();
  }
}
