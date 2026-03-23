package ottimizza_eduardo_testepleno.models;

import jakarta.persistence.*;
import ottimizza_eduardo_testepleno.dto.BoardDTO;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Columns> columns;

    public Board() {
    }

    public Board(UUID id, String name, List<Columns> columns) {
        this.id = id;
        this.name = name;
        this.columns = columns;
    }

    public Board(BoardDTO boardDTO) {
        this.id = boardDTO.getId();
        this.name = boardDTO.getName();
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

    public List<Columns> getColumns() {
        return columns;
    }

    public void setColumns(List<Columns> columns) {
        this.columns = columns;
    }


}
