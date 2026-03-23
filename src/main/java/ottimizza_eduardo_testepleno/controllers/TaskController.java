package ottimizza_eduardo_testepleno.controllers;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ottimizza_eduardo_testepleno.dto.TaskDTO;
import ottimizza_eduardo_testepleno.dto.response.TaskResponse;
import ottimizza_eduardo_testepleno.services.TaskService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> save(@RequestBody @Valid TaskDTO taskDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(taskDTO));
    }

    @GetMapping
    public ResponseEntity<Page<TaskResponse>> findAll(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findAll(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> update(@RequestBody @Valid TaskDTO taskDTO, @PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.update(id, taskDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskResponse> delete(@PathVariable UUID id) {
        taskService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
