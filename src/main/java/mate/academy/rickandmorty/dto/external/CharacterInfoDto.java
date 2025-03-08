package mate.academy.rickandmorty.dto.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CharacterInfoDto(Long id, String name, String status, String species,
                               String type, String gender, String url, String image) {}


