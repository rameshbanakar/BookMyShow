package com.example.BookMyShow.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@Entity
@Table(name = "shows")
public class Show extends BaseEntity{
    @ManyToOne
    private Movie movie;
    private Time startTime;
    private Time endTime;
    @ManyToOne
    private Screen screen;
    @ManyToOne
    private Theater theater;
}
