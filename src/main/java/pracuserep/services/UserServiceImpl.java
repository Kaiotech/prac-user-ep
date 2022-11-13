package pracuserep.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pracuserep.entity.UserEntity;
import pracuserep.repositories.UserRepository;
import pracuserep.web.mappers.UserMapper;
import pracuserep.web.model.UserDto;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;
    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new IllegalArgumentException("User already fked");
        } else if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("User already fked");
        }

        UserEntity userEntity = mapper.userDtoToUser(userDto);
        userRepository.save(userEntity);
        return mapper.userToUserDto(userEntity);
    }
}
