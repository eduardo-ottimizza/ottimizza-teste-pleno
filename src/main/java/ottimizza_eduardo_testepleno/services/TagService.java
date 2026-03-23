package ottimizza_eduardo_testepleno.services;

import org.springframework.stereotype.Service;
import ottimizza_eduardo_testepleno.dto.TagDTO;
import ottimizza_eduardo_testepleno.exceptions.AlreadyRegisteredException;
import ottimizza_eduardo_testepleno.exceptions.NotFoundException;
import ottimizza_eduardo_testepleno.models.Tag;
import ottimizza_eduardo_testepleno.repositories.TagRepository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class TagService {

    private TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public TagDTO save(TagDTO tagDTO) {
        Tag tag = tagRepository.findByNameIgnoreCase(tagDTO.getName());

        if (tag != null) {

            if (tag.getDeletedAt() == null) {
                throw new AlreadyRegisteredException("A tag with that name already exists.");
            }

            tag.setDeletedAt(null);
        } else {
            tag = new Tag();
            tag.setName(tagDTO.getName());
        }

        tag = tagRepository.save(tag);
        return new TagDTO(tag);
    }

    public List<TagDTO> findAll() {
        List<Tag> tags = tagRepository.findAllByDeletedAtIsNull();

        return tags.stream().map(TagDTO::new).toList();
    }

    public void delete(UUID id) {
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new NotFoundException("Tag already deleted"));

        if(tag.getDeletedAt() != null) {
            throw new NotFoundException("Tag already deleted");
        }

        tag.setDeletedAt(Instant.now());

        tagRepository.save(tag);
    }

}
