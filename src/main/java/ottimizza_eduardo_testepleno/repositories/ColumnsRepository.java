package ottimizza_eduardo_testepleno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ottimizza_eduardo_testepleno.models.Columns;

import java.util.UUID;

public interface ColumnsRepository extends JpaRepository<Columns, UUID> {

    boolean existsByName(String name);

}
