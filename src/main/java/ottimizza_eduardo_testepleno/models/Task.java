package ottimizza_eduardo_testepleno.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer position;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "due_date")
    private OffsetDateTime dueData;

    @Column(nullable = false)
    private Boolean completed = false;

    @Column(name = "tags")
    private List<String> tags;

    @ManyToOne
    @JoinColumn(name = "column_id", nullable = false)
    private Columns column;

    public Task() {
    }

    public Task(UUID id, String name, Integer position, Instant createdAt, OffsetDateTime dueData, Boolean completed, List<String> tags, Columns column) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.createdAt = createdAt;
        this.dueData = dueData;
        this.completed = completed;
        this.tags = tags;
        this.column = column;
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

    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
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

    public Columns getColumn() {
        return column;
    }
    public void setColumn(Columns column) {
        this.column = column;
    }
}
