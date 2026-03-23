package ottimizza_eduardo_testepleno.dto;

import ottimizza_eduardo_testepleno.models.Columns;

import java.util.UUID;

public class ColumnsDTO {

    private UUID id;
    private String name;
    private Integer position;

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
}
