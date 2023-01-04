package ke.innv8.library.config;

import ke.innv8.library.entity.Category;
import ke.innv8.library.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CategoryConfig {
@Bean
    CommandLineRunner categoryCommandLineRunner(CategoryRepository repository) {
    return args -> {
        Category action = Category.builder().name("Action and adventure").build();
        Category classics = Category.builder().name("Classics").build();
        repository.saveAll(List.of(action, classics));
    };
}

}
