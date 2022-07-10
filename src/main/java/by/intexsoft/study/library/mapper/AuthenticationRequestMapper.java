package by.intexsoft.study.library.mapper;

import by.intexsoft.study.library.model.AuthenticationRequest;
import by.intexsoft.study.library.model.AuthenticationRequestDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AuthenticationRequestMapper {

    AuthenticationRequestMapper authenticationRequestMapper = Mappers.getMapper(AuthenticationRequestMapper.class);

     AuthenticationRequestDto toDto(AuthenticationRequest authenticationRequest);

    @InheritInverseConfiguration
    AuthenticationRequest fromDto(AuthenticationRequestDto authenticationRequestDto);

    List<AuthenticationRequestDto> toDtos(List<AuthenticationRequest> authenticationRequests);

}