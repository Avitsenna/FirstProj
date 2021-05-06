package ru.back.backend.controllers;
//Imports
//Spring

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

//Spring web and/or web reactive
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
//мои классы
import ru.back.backend.model.Content;
import ru.back.backend.model.ContentList;

//Vanilla Java
import java.util.List;

@Controller
@RequestMapping("/feed")
public class FeedController {
    private final String url = "http://localhost:8080/news";

    @GetMapping("/news")
    public String getNews(ModelMap modelMap) {
        //все для перевода из HTTPS , можно попробовать YodaModule
        WebClient webClient = WebClient.create();
        ContentList responseJson = webClient.get()
                .uri(url)
                .exchange()
                .block()
                .bodyToMono(ContentList.class)
                .block();
        List<Content> contentList = responseJson.getList();
        modelMap.addAttribute("contentList", contentList);

        return "news";
    }


}
