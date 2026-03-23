package ottimizza_eduardo_testepleno.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ottimizza_eduardo_testepleno.dto.BoardDTO;
import ottimizza_eduardo_testepleno.dto.ColumnsDTO;
import ottimizza_eduardo_testepleno.dto.TaskDTO;
import ottimizza_eduardo_testepleno.dto.response.ColumnsResponse;
import ottimizza_eduardo_testepleno.dto.response.TaskResponse;
import ottimizza_eduardo_testepleno.exceptions.AlreadyRegisteredException;
import ottimizza_eduardo_testepleno.exceptions.NotFoundException;
import ottimizza_eduardo_testepleno.models.Board;
import ottimizza_eduardo_testepleno.models.Columns;
import ottimizza_eduardo_testepleno.models.Task;
import ottimizza_eduardo_testepleno.repositories.ColumnsRepository;
import ottimizza_eduardo_testepleno.repositories.TaskRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ColumnsRepository columnsRepository;

    public TaskService(TaskRepository taskRepository, ColumnsRepository columnsRepository) {
        this.taskRepository = taskRepository;
        this.columnsRepository = columnsRepository;
    }

    public TaskResponse save(TaskDTO taskDTO) {
        if(taskRepository.existsByName(taskDTO.getName())) {
            throw new AlreadyRegisteredException("Task already registered");
        }

        Task entity = new Task(taskDTO);
        Columns columns = columnsRepository.findById(taskDTO.getColumnId()).orElseThrow(() ->
                new NotFoundException("Column not found"));

        entity.setColumn(columns);

        taskRepository.save(entity);

        return new TaskResponse(entity, new ColumnsResponse(columns));
    }

    public List<TaskResponse> findAll(Pageable pageable) {
        Page<Task> tasks = taskRepository.findAll(pageable);

        return tasks.map(task -> {
            ColumnsResponse columnsDTO = new ColumnsResponse(task.getColumn());
            return new TaskResponse(task, columnsDTO);
        }).getContent();
    }

    public TaskResponse update(UUID id, TaskDTO taskDTO) {

        Task entity = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found"));

        entity.setName(taskDTO.getName());
        entity.setPosition(taskDTO.getPosition());
        entity.setDueData(taskDTO.getDueData());
        if (taskDTO.getCompleted() != null) {
            entity.setCompleted(taskDTO.getCompleted());
        }
        if (taskDTO.getTags() != null) {
            entity.setTags(taskDTO.getTags());
        }


        Columns column = entity.getColumn();

        if (taskDTO.getColumnId() != null) {
            column = columnsRepository.findById(taskDTO.getColumnId())
                    .orElseThrow(() -> new NotFoundException("Column not found"));
            entity.setColumn(column);
        }

        taskRepository.save(entity);

        return new TaskResponse(entity, new ColumnsResponse(column));
    }

    public void delete(UUID id) {
        Task entity = taskRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Task not found"));

        taskRepository.deleteById(entity.getId());
    }
}
