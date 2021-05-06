package ru.back.backend.model;
//Imports
//lombok
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
//Vanilla Java
import java.util.ArrayList;
import java.util.List;

//аннотации
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor

public class ContentList {//arraylist для Content

    private List<Content> list;

    public ContentList() {
        list = new ArrayList<>();
    }
}
