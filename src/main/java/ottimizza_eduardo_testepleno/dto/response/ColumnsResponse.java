package ottimizza_eduardo_testepleno.dto.response;

import ottimizza_eduardo_testepleno.dto.BoardDTO;
import ottimizza_eduardo_testepleno.models.Columns;

import java.util.UUID;

public class ColumnsResponse {

    private UUID id;
    private String name;
    private Integer position;
    private BoardDTO boards;

    public ColumnsResponse() {
    }

    public ColumnsResponse(UUID id, String name, Integer position, BoardDTO boards) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.boards = boards;
    }

    public ColumnsResponse(Columns columns, BoardDTO boards) {
        this.id = columns.getId();
        this.name = columns.getName();
        this.position = columns.getPosition();
        this.boards = boards;
    }

    public ColumnsResponse(Columns entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.position = entity.getPosition();

        if (entity.getBoard() != null) {
            this.boards = new BoardDTO(entity.getBoard());
        }
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }
    public void setPosition(Integer position) {
        this.position = position;
    }

    public BoardDTO getBoards() {
        return boards;
    }
    public void setBoards(BoardDTO boards) {
        this.boards = boards;
    }
}
