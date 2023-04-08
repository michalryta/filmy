package pl.zajecia.filmy.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.zajecia.filmy.model.VideoCassette;
import pl.zajecia.filmy.repository.VideoCassetteRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class VideoCassetteService {
    private final VideoCassetteRepo videoCassetteRepo;

    @Autowired
    public VideoCassetteService(VideoCassetteRepo videoCassetteRepo) {
        this.videoCassetteRepo = videoCassetteRepo;
    }

    public Optional<VideoCassette> findById(Long id) {
        return videoCassetteRepo.findById(id);
    }

    public Iterable<VideoCassette> findAll() {
        return videoCassetteRepo.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette) {
        return videoCassetteRepo.save(videoCassette);
    }

    public void deleteById(Long id) {
        videoCassetteRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new VideoCassette(1L, "The Godfather", LocalDate.of(1972, 3, 24)));
        save(new VideoCassette(2L, "Star Wars: A New Hope", LocalDate.of(1977, 5, 25)));
        save(new VideoCassette(3L, "Jurassic Park", LocalDate.of(1993, 6, 9)));
    }

}

