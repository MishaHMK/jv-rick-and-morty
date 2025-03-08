package mate.academy.rickandmorty.config;

import mate.academy.rickandmorty.service.client.CharactersClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

@Configuration
public class AppConfig {
    @Bean
    public CommandLineRunner commandLineRunner(CharactersClient charactersClient) {
        return args -> {
            System.out.println("Fetching and saving characters at startup...");
            charactersClient.fetchAndSaveCharacters();
        };
    }
}