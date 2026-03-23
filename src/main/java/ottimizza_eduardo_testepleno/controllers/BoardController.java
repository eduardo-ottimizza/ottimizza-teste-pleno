package ottimizza_eduardo_testepleno.controllers;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ottimizza_eduardo_testepleno.dto.BoardDTO;
import ottimizza_eduardo_testepleno.services.BoardService;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity<BoardDTO> save(@RequestBody @Valid BoardDTO boardDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(boardService.save(boardDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardDTO> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<BoardDTO>> findAll(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);

        return ResponseEntity.status(HttpStatus.OK).body(boardService.findAll(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardDTO> update(@RequestBody @Valid BoardDTO boardDTO, @PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.update(id, boardDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        boardService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
