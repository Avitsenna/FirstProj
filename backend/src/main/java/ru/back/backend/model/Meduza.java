package ru.back.backend.model;

//Imports
// Vanilla Java?(nahh)
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//lombok
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//Vanilla Java
import java.util.Map;

//Аннотации
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Meduza {//мапа , где K=String, V=Map<Obj,Obj> *(мапа с мапой внутри)
    private Map<String, Map<Object, Object>> documents;
}
