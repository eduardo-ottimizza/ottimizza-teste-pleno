package ottimizza_eduardo_testepleno.dto;

import jakarta.validation.constraints.NotNull;
import ottimizza_eduardo_testepleno.models.Tag;

import java.util.UUID;

public class TagDTO {

    private UUID id;

    @NotNull(message = "O campo 'name' é obrigatório")
    private String name;

    public TagDTO() {
    }

    public TagDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public TagDTO(Tag tag) {
        this.id = tag.getId();
        this.name = tag.getName();
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
