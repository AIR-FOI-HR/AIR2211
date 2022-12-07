package hr.foi.air.ednevnik;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public List<String> hello()
    {
        return List.of("Hello", "AIR");
    }
}
