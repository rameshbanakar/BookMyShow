package com.example.BookMyShow.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity

public class Theater extends BaseEntity{
    private String name;

    @OneToMany(mappedBy = "theater")
    private List<Screen> screen;

    @ManyToOne
    private City city;

}
