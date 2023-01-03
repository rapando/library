package ke.innv8.library.category;

import com.smattme.requestvalidator.RequestValidator;
import ke.innv8.library.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/categories")
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<GenericResponse> getCategories() {
        List<Category> categories = service.getCategories();
        return ResponseEntity.ok().body(new GenericResponse(
                true, "ok", categories
        ));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<GenericResponse> getCategory(@PathVariable("id") Long id) {
        Optional<Category> category = service.getCategory(id);
        if (category.isPresent()) {
            return ResponseEntity.ok().body(new GenericResponse(
                    true, "ok", category.get()
            ));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<GenericResponse> createCategory(@RequestBody Category category) {
        Map<String, String> rules = new HashMap<>();
        rules.put("name", "required");

        List<String> errors = RequestValidator.validate(category, rules);
        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(new GenericResponse(
                    false, errors, "Missing parameter(s)"
            ));
        }

        try {
            service.createCategory(category);
            return ResponseEntity.ok().body(new GenericResponse(
                    true, "ok", null
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GenericResponse(
                    false, List.of(e.toString()), "failed to create category"
            ));
        }

    }

}
