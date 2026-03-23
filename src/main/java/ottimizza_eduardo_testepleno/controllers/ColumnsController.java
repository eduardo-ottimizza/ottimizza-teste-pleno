package ottimizza_eduardo_testepleno.controllers;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ottimizza_eduardo_testepleno.dto.ColumnsDTO;
import ottimizza_eduardo_testepleno.dto.response.ColumnsResponse;
import ottimizza_eduardo_testepleno.services.ColumnsService;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/column")
public class ColumnsController {

    private final ColumnsService columnsService;

    public ColumnsController(ColumnsService columnsService) {
        this.columnsService = columnsService;
    }

    @PostMapping
    public ResponseEntity<ColumnsResponse> save(@RequestBody @Valid ColumnsDTO columnsDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(columnsService.save(columnsDTO));

    }

    @GetMapping
    public ResponseEntity<Page<ColumnsResponse>> findAll(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(columnsService.findAll(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColumnsResponse> update(@RequestBody @Valid ColumnsDTO columnsDTO, @PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(columnsService.update(id, columnsDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        columnsService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
