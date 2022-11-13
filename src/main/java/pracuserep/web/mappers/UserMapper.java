package pracuserep.web.mappers;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import pracuserep.entity.UserEntity;
import pracuserep.web.model.UserDto;

@Mapper(componentModel = "spring")
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {

    UserDto userToUserDto(UserEntity userEntity);

    UserEntity userDtoToUser(UserDto userDto);
}
