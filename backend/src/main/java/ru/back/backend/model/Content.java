package ru.back.backend.model;
//Imports
// Vanilla Java?
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//lombok
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Vanilla Java
import java.time.LocalDate;

//Аннотации
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Content {
    //ссылка и название
    public String url;
    public String title;
    //фотография
    @JsonProperty("image_url")
    public String ImageUrl;
    //дата (дд/мм/гггг)
    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public LocalDate Date;


}
