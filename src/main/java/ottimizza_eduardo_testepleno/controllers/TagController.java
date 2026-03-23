package ottimizza_eduardo_testepleno.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ottimizza_eduardo_testepleno.dto.TagDTO;
import ottimizza_eduardo_testepleno.services.TagService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/tags")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public ResponseEntity<TagDTO> save(@RequestBody @Valid TagDTO tagDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tagService.save(tagDTO));
    }

    @GetMapping
    public ResponseEntity<List<TagDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(tagService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        tagService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
