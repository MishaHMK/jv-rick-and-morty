package mate.academy.rickandmorty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.internal.CharacterBiographyDto;
import mate.academy.rickandmorty.service.CharacterService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book Management", description = "Endpoints for managing books")
@RequiredArgsConstructor
@RestController
@RequestMapping("/characters")
public class CharacterController {
    private final CharacterService characterService;

    @GetMapping
    @Operation(summary = "Get all characters",
            description = "Get all character biographies with "
                    + "optional name filtering")
    public List<CharacterBiographyDto> getAll(@ParameterObject String name) {
        return characterService.findAll(name);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get character by id",
            description = "Get specific character biography "
                    + "by given unique id")
    public CharacterBiographyDto getCharacterBiographyById(@PathVariable Long id) {
        return characterService.findById(id);
    }
}
