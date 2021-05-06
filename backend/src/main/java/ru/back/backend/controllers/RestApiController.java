package ru.back.backend.controllers;

//Imports
//
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

//Spring
import org.springframework.http.MediaType;

//Spring web and/or reactive web
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import ru.back.backend.model.Meduza;

//Vanilla Java
import java.util.Map;

@RestController
public class RestApiController {


    private final String url = "https://meduza.io/api/v3/search?chrono=news&locale=ru&page=0&per_page=24";

    @GetMapping(value = "/news", produces = MediaType.APPLICATION_JSON_VALUE)
    public String news() throws JsonProcessingException {


        WebClient webClient = WebClient.create();
        String responseJson = webClient.get()
                .uri(url)
                .exchange()
                .block()
                .bodyToMono(String.class)
                .block();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JSR310Module());
        Meduza meduza = objectMapper.readValue(responseJson, Meduza.class);
        System.out.println(meduza);

        for (Map.Entry<String, Map<Object, Object>> entry : meduza.getDocuments().entrySet()) {
            Map<Object, Object> map = entry.getValue();
            for (Map.Entry<Object, Object> obj : map.entrySet()) {
                String text = (String) obj.getKey();
                System.out.println(text);
            }
        }
        return null;
    }
}
