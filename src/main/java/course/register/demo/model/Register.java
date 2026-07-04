package course.register.demo.model;

import lombok.Builder;

@Builder
public record Register(Course course, User user) {}
