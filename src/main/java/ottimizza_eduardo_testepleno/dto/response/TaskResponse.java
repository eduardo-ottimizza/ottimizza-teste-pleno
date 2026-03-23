package ottimizza_eduardo_testepleno.dto.response;

import ottimizza_eduardo_testepleno.models.Task;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public class TaskResponse {

    private UUID id;
    private String name;
    private Integer position;
    private OffsetDateTime dueData;
    private Boolean completed;
    private List<String> tags;
    private ColumnsResponse columns;

    public TaskResponse() {
    }

    public TaskResponse(UUID id, String name, Integer position, OffsetDateTime dueData, Boolean completed, List<String> tags, ColumnsResponse columns) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.dueData = dueData;
        this.completed = completed;
        this.tags = tags;
        this.columns = columns;
    }

    public TaskResponse(Task task, ColumnsResponse columns) {
        this.id = task.getId();
        this.name = task.getName();
        this.position = task.getPosition();
        this.dueData = task.getDueData();
        this.completed = task.getCompleted();
        this.tags = task.getTags();
        this.columns = columns;
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

    public ColumnsResponse getColumns() {
        return columns;
    }
    public void setColumns(ColumnsResponse columns) {
        this.columns = columns;
    }
}
