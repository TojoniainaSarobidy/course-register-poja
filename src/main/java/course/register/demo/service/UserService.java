package course.register.demo.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper){
        this.repository=repository;
        this.mapper=mapper;
    }
}
    public User createUser(String firstName, String lastName, String userName, String email){
        User user = mapper.toEntity(firstName, lastName, userName, email);
        return repository.save(user);
    }
}
