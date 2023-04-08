package pl.zajecia.filmy.api;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.zajecia.filmy.manager.VideoCassetteService;
import pl.zajecia.filmy.model.VideoCassette;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cassetts")
public class VideoCasseteApi {

    @Autowired
    private final VideoCassetteService videoCassetteService;


    @GetMapping("/all")
    public Iterable<VideoCassette> getAll() {
        return videoCassetteService.findAll();
    }
    @GetMapping
    public Optional<VideoCassette> getById(@RequestParam Long id) {
        return videoCassetteService.findById(id);
    }

    @PostMapping
    public VideoCassette addVideo(@RequestBody VideoCassette videoCassette) {
        return videoCassetteService.save(videoCassette);
    }

    @PutMapping
    public boolean VideoCassette(@RequestParam Long id, @RequestBody VideoCassette videoCassette) {
        if (videoCassetteService.findById(id).isPresent())
       {
           videoCassetteService.save(videoCassette);
            return true;
        }
        return false;
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long id) {
         videoCassetteService.deleteById(id);
    }
}