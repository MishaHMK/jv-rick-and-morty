package mate.academy.rickandmorty.service;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.internal.CharacterBiographyDto;
import mate.academy.rickandmorty.exception.EntityNotFoundException;
import mate.academy.rickandmorty.mapper.CharacterMapper;
import mate.academy.rickandmorty.model.Character;
import mate.academy.rickandmorty.repository.character.CharacterRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository characterRepository;
    private final CharacterMapper characterMapper;

    @Override
    public List<CharacterBiographyDto> findAllByName(String name) {
        return characterRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(characterMapper::toBiographyDto)
                .toList();
    }

    @Override
    public List<CharacterBiographyDto> findAll() {
        return characterRepository.findAll()
                .stream()
                .map(characterMapper::toBiographyDto)
                .toList();
    }


    @Override
    public CharacterBiographyDto findById(Long id) {
        Character character = characterRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find character by id " + id)
        );
        return characterMapper.toBiographyDto(character);
    }
}
