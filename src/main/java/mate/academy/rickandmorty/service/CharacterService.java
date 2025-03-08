package mate.academy.rickandmorty.service;

import java.util.List;
import mate.academy.rickandmorty.dto.internal.CharacterBiographyDto;

public interface CharacterService {
    List<CharacterBiographyDto> findAll(String name);

    CharacterBiographyDto findById(Long id);
}
