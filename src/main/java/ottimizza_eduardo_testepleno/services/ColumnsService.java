package ottimizza_eduardo_testepleno.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ottimizza_eduardo_testepleno.dto.BoardDTO;
import ottimizza_eduardo_testepleno.dto.ColumnsDTO;
import ottimizza_eduardo_testepleno.exceptions.AlreadyRegisteredException;
import ottimizza_eduardo_testepleno.exceptions.NotFoundException;
import ottimizza_eduardo_testepleno.models.Board;
import ottimizza_eduardo_testepleno.models.Columns;
import ottimizza_eduardo_testepleno.dto.response.ColumnsResponse;
import ottimizza_eduardo_testepleno.repositories.BoardRepository;
import ottimizza_eduardo_testepleno.repositories.ColumnsRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ColumnsService {

    private ColumnsRepository columnsRepository;
    private BoardRepository boardRepository;

    public ColumnsService(ColumnsRepository columnsRepository, BoardRepository boardRepository) {
        this.columnsRepository = columnsRepository;
        this.boardRepository = boardRepository;
    }

    public ColumnsResponse save(ColumnsDTO columnsDTO) {
        var alreadyRegistered = columnsRepository.existsByName(columnsDTO.getName());
        if(alreadyRegistered) {
            throw new AlreadyRegisteredException("Column already registered");
        }

        Columns entity = new Columns(columnsDTO);
        Board board = boardRepository.findById(columnsDTO.getBoardId()).orElseThrow(() -> new NotFoundException("Board not found"));;

        entity.setBoard(board);

        entity = columnsRepository.save(entity);

        return new ColumnsResponse(entity, new BoardDTO(board));
    }

    public List<ColumnsResponse> findAll(Pageable pageable) {
        Page<Columns> page = columnsRepository.findAll(pageable);

        return page.map(column -> {
            BoardDTO boardDTO = new BoardDTO(column.getBoard());
            return new ColumnsResponse(column, boardDTO);
        }).getContent();
    }

    public ColumnsResponse update(UUID id, ColumnsDTO columnsDTO) {

        Columns entity = columnsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Column not found"));

        entity.setName(columnsDTO.getName());
        entity.setPosition(columnsDTO.getPosition());

        Board board = entity.getBoard();

        if (columnsDTO.getBoardId() != null) {
            board = boardRepository.findById(columnsDTO.getBoardId())
                    .orElseThrow(() -> new NotFoundException("Board not found"));
            entity.setBoard(board);
        }

        columnsRepository.save(entity);

        return new ColumnsResponse(entity, new BoardDTO(board));
    }

    public void delete(UUID id) {
        Columns entity = columnsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Column not found"));

        columnsRepository.deleteById(entity.getId());
    }
}
