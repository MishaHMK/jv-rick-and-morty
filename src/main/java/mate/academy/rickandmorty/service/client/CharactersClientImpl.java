package mate.academy.rickandmorty.service.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.external.CharacterResponseDto;
import mate.academy.rickandmorty.mapper.CharacterMapper;
import mate.academy.rickandmorty.model.Character;
import mate.academy.rickandmorty.repository.character.CharacterRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharactersClientImpl implements CharactersClient {
    private static final String API_URL = "https://rickandmortyapi.com/api/character";
    private final CharacterMapper characterMapper;
    private final CharacterRepository characterRepository;

    @Override
    public void fetchAndSaveCharacters() {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(API_URL))
                .build();
        try {
            HttpResponse<String> response = httpClient
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            CharacterResponseDto responseData = objectMapper.readValue(response.body(),
                    new TypeReference<>(){}
            );
            List<Character> charactersToCreate = responseData.results().stream()
                    .map(characterMapper::toCharacter)
                    .peek(c -> c.setId(null))
                    .toList();
            characterRepository.saveAll(charactersToCreate);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Fetching or saving characters "
                    + "from Rick&MortyAPI failed", e);
        }
    }

   @PostConstruct
    public void init() {
        if (characterRepository.count() == 0) {
            fetchAndSaveCharacters();
        }
    }
}
