package pracuserep.web.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import pracuserep.entity.UserEntity;
import pracuserep.web.model.UserDto;

public abstract class UserMapperDecorator implements UserMapper {

    private UserMapper userMapper;

    @Autowired
    public void setMapper(UserMapper mapper) {
        this.userMapper = mapper;
    }

    @Override
    public UserDto userToUserDto(UserEntity userEntity) {
        return userMapper.userToUserDto(userEntity);
    }

    @Override
    public UserEntity userDtoToUser(UserDto userDto) {
        return userMapper.userDtoToUser(userDto);
    }
}
