package ottimizza_eduardo_testepleno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ottimizza_eduardo_testepleno.models.Task;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {

    boolean existsByName(String name);
}
