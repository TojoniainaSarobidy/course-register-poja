package course.register.demo.mapper;

import course.register.demo.model.Course;
import course.register.demo.repository.model.JCourse;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CourseMapper {
  private final UserMapper userMapper;

  public List<Course> courses(List<JCourse> jCourses) {
    return jCourses.stream().map(this::toModel).toList();
  }

  public Course toModel(JCourse jCourse) {
    return Course.builder()
        .id(jCourse.getId())
        .title(jCourse.getTitle())
        .startDate(jCourse.getStartDate())
        .endDate(jCourse.getEndDate())
        .build();
  }

  public List<JCourse> toEntity(List<Course> courses) {
    return courses.stream().map(this::toEntity).toList();
  }

  public JCourse toEntity(Course course) {
    return JCourse.builder()
        .id(course.id())
        .title(course.title())
        .startDate(course.startDate())
        .endDate(course.endDate())
        .build();
  }
}
