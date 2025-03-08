package mate.academy.rickandmorty.mapper;

import mate.academy.rickandmorty.config.MapperConfig;
import mate.academy.rickandmorty.dto.external.CharacterInfoDto;
import mate.academy.rickandmorty.dto.internal.CharacterBiographyDto;
import mate.academy.rickandmorty.model.Character;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class, componentModel = "spring")
public interface CharacterMapper {
    @Mapping(source = "id", target = "externalId")
    Character toCharacter(CharacterInfoDto characterInfoDto);

    CharacterBiographyDto toBiographyDto(Character character);
}
