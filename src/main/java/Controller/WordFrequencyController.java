package Controller;

import com.example.wordfrequency.service.WordFrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordFrequencyController {
    @Autowired
    WordFrequencyService service;

    @GetMapping("/")
    public String index() {
        //return "index";
        return "Hello, Hello";
    }

    @PostMapping(value="/run", produces = "application/json")
    ResponseEntity newEmployee(@RequestBody String text) {
        return ResponseEntity.ok(service.wordMap(text));
    }

}
