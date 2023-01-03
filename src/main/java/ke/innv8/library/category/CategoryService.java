package ke.innv8.library.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getCategories() {
        return repository.findAll();
    }

    public Optional<Category> getCategory(Long id) {
        return repository.findById(id);
    }

    public void createCategory(Category category) {
        Optional<Category> categoryOptional = repository.findByName(category.getName());
        if (categoryOptional.isPresent()) {
            throw new IllegalStateException("category " + category.getName() + " already exists");
        }
        repository.save(category);
    }
}
