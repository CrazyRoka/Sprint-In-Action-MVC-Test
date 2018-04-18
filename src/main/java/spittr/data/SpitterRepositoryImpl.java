package spittr.data;

import org.springframework.context.annotation.Configuration;
import spittr.Spitter;

@Configuration
public class SpitterRepositoryImpl implements SpitterRepository {

    private static int counter = 1;

    public Spitter save(Spitter spitter) {
        return new Spitter(
                counter++,
                spitter.getFirstName(),
                spitter.getLastName(),
                spitter.getUsername(),
                spitter.getPassword()
        );
    }

    public Spitter findByUsername(String username) {
        return new Spitter(
                counter++,
                "Rostislav",
                "Toch",
                "roka",
                "1234"
        );
    }
}
