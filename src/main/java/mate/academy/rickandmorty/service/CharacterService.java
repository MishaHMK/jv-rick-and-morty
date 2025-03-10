package mate.academy.rickandmorty.service;

import java.util.List;
import mate.academy.rickandmorty.dto.internal.CharacterBiographyDto;

public interface CharacterService {
    List<CharacterBiographyDto> findAllByName(String name);

    List<CharacterBiographyDto> findAll();

    CharacterBiographyDto findById(Long id);

}
