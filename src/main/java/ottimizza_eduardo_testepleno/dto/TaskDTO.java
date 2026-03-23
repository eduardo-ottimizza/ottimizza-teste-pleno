package ottimizza_eduardo_testepleno.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import ottimizza_eduardo_testepleno.models.Task;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public class TaskDTO {

    private UUID id;

    @NotBlank(message = "O campo 'name' é obrigatório")
    private String name;

    @NotNull(message = "O campo 'position' é obrigatório")
    private Integer position;
    private OffsetDateTime dueData;
    private Boolean completed = false;
    private List<String> tags;

    public TaskDTO() {
    }

    public TaskDTO(UUID id, String name, Integer position, OffsetDateTime dueData, Boolean completed, List<String> tags) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.dueData = dueData;
        this.completed = completed;
        this.tags = tags;
    }

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.position = task.getPosition();
        this.dueData = task.getDueData();
        this.completed = task.getCompleted();
        this.tags = task.getTags();
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

    public OffsetDateTime getDueData() {
        return dueData;
    }
    public void setDueData(OffsetDateTime dueData) {
        this.dueData = dueData;
    }

    public Boolean getCompleted() {
        return completed;
    }
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
