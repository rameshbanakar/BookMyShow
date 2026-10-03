package com.example.BookMyShow.Models;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity

public class City extends BaseEntity{
    private String name;
    @OneToMany(mappedBy = "city")
    private List<Theater> theater;
}
