package ottimizza_eduardo_testepleno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ottimizza_eduardo_testepleno.models.Tag;

import java.util.List;
import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {

    Tag findByNameIgnoreCase(String name);

    List<Tag> findAllByDeletedAtIsNull();
}
