package com.example.finalproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String title;

    @NotNull
    @Positive
    private double price;

    //------------Relations---------------//

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "session_id")// like document to session
    private Session session;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "student_user_id")
    private Student student;  //Reema added this

}
