package ottimizza_eduardo_testepleno.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ottimizza_eduardo_testepleno.dto.BoardDTO;
import ottimizza_eduardo_testepleno.exceptions.AlreadyRegisteredException;
import ottimizza_eduardo_testepleno.exceptions.NotFoundException;
import ottimizza_eduardo_testepleno.models.Board;
import ottimizza_eduardo_testepleno.repositories.BoardRepository;

import java.util.UUID;


@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardDTO save(BoardDTO boardDTO) {
        var alreadyRegistered = boardRepository.existsByName(boardDTO.getName());

        if(alreadyRegistered) {
            throw new AlreadyRegisteredException("Board already registered");
        }

        Board entity = new Board(boardDTO);
        entity = boardRepository.save(entity);

        return new BoardDTO(entity);
    }

    public Page<BoardDTO> findAll(Pageable pageable) {
        return boardRepository.findAll(pageable).map(BoardDTO::new);
    }

    public BoardDTO findById(UUID id) {
        Board entity = boardRepository.findById(id).orElseThrow(() -> new NotFoundException("Board not found!"));
        return new BoardDTO(entity);
    }

    public BoardDTO update(UUID id, BoardDTO boardDTO) {
        Board entity = boardRepository.findById(id).orElseThrow(() -> new NotFoundException("Board not found"));

        entity.setName(boardDTO.getName());

        boardRepository.save(entity);

        return new BoardDTO(entity);
    }

    public void delete(UUID id) {
        Board entity = boardRepository.findById(id).orElseThrow(() -> new NotFoundException("Board not found"));

        boardRepository.deleteById(entity.getId());
    }
}
