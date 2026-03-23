package ottimizza_eduardo_testepleno.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import ottimizza_eduardo_testepleno.models.Columns;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class ColumnsDTO {

    private UUID id;

    @NotBlank(message = "O campo 'name' é obrigatório")
    private String name;

    @NotNull(message = "O campo 'position' é obrigatório")
    private Integer position;

    @JsonProperty("board_id")
    private UUID boardId;

    public ColumnsDTO() {
    }

    public ColumnsDTO(UUID id, String name, Integer position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public ColumnsDTO(Columns columns) {
        this.id = columns.getId();
        this.name = columns.getName();
        this.position = columns.getPosition();
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

    public UUID getBoardId() {
        return boardId;
    }
}
