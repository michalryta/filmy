package pl.zajecia.filmy.repository;

import org.springframework.data.repository.CrudRepository;
import pl.zajecia.filmy.model.VideoCassette;

import java.util.Optional;

public interface VideoCassetteRepo extends CrudRepository<VideoCassette, Long> {
    Optional<VideoCassette> findAllById(Long id);
}
