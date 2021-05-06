package ru.back.backend.mapper;

import org.springframework.stereotype.Component;
//мои классы
import ru.back.backend.model.Content;
import ru.back.backend.model.Meduza;

//Vanilla Java
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class Mapper implements ModelMapper<Meduza, List<Content>> {
    @Override
    public List<Content> toDto(Meduza meduzaNews) {
        List<Content> list = new ArrayList<>();
        for (Map.Entry<String, Map<Object, Object>> entry : meduzaNews.getDocuments().entrySet()) {
            Map<Object, Object> map = entry.getValue();
            Content content = new Content();
            for (Map.Entry<Object, Object> obj : map.entrySet()) {
                switch ((String) obj.getKey()) {
                    //надо совместить url с title, чтобы title был кликабельным
                    case "url":
                        content.setUrl((String) obj.getValue());
                        break;
                    case "title":
                        content.setTitle((String) obj.getValue());
                        break;

                    case "share_image_url":
                        content.setImageUrl((String) obj.getValue());
                        break;
                    case "pub_date":
                        content.setDate(LocalDate.parse((String) obj.getValue()));
                        break;
                }

            }
            list.add(content);
        }
        return list;
    }

    @Override
    public Meduza toModel(List<Content> contents) {
        return null;
    }

}
