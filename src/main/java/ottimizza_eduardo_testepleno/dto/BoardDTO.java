package ottimizza_eduardo_testepleno.dto;

import jakarta.validation.constraints.NotBlank;
import ottimizza_eduardo_testepleno.models.Board;

import java.util.UUID;

public class BoardDTO {

    private UUID id;

    @NotBlank(message = "O campo 'name' é obrigatório")
    private String name;

    public BoardDTO() {
    }

    public BoardDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public BoardDTO(Board board) {
        this.id = board.getId();
        this.name = board.getName();
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
}
