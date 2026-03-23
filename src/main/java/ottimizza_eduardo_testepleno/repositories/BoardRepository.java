package ottimizza_eduardo_testepleno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ottimizza_eduardo_testepleno.models.Board;

import java.util.UUID;

public interface BoardRepository extends JpaRepository<Board, UUID> {

    boolean existsByName(String name);

}
