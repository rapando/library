package ke.innv8.library.category;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CategoryConfig {
@Bean
    CommandLineRunner categoryCommandLineRunner(CategoryRepository repository) {
    return args -> {
        Category action = new Category("Action and adventure");
        Category classics = new Category("Classics");
        repository.saveAll(List.of(action, classics));
    };
}

}
