package ottimizza_eduardo_testepleno.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;
import ottimizza_eduardo_testepleno.dto.TagDTO;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    public Tag() {
    }

    public Tag(UUID id, String name, Instant createdAt, Instant deletedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
    }

    public Tag(TagDTO tagDTO) {
        this.id = tagDTO.getId();
        this.name = tagDTO.getName();
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }
    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }
}
