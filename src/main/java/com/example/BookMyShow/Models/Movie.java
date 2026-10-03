package com.example.BookMyShow.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity

public class Movie extends BaseEntity{
    private String title;
    private int year;
    private String director;
    private String genre;
    private int rating;
    private String descriptions;

    @ElementCollection(targetClass = Language.class)
    @Enumerated(EnumType.STRING)
    private List<Language> language;


}
