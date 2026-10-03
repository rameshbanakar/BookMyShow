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

public class User extends BaseEntity{
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Booking> booking;

}
