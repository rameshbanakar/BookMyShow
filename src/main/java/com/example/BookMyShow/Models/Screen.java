package com.example.BookMyShow.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseEntity{
    private String name;
    @ManyToOne
    private Theater theater;

    @OneToMany(mappedBy = "screen")
    private List<Show> show;

    @Enumerated(EnumType.STRING)
    private Feature features;

}
