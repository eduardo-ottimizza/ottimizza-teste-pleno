package ottimizza_eduardo_testepleno.models;

import jakarta.persistence.*;
import ottimizza_eduardo_testepleno.dto.ColumnsDTO;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "columns")
public class Columns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @OneToMany(mappedBy = "column", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

    public Columns() {
    }

    public Columns(UUID id, String name, Integer position, Board board, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.board = board;
        this.tasks = tasks;
    }

    public Columns(ColumnsDTO columnsDTO) {
        this.id = columnsDTO.getId();
        this.name = columnsDTO.getName();
        this.position = columnsDTO.getPosition();
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

    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Task> getTasks() {
        return tasks;
    }
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
