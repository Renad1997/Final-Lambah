package com.example.finalproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should not be empty!")
    @Column(columnDefinition = "varchar(50) not null")
    private String name;

    @NotNull
    private double duration;

    @NotEmpty
    @Pattern(regexp = "ZOOM|FACE_TO_FACE|VIDEO|DOCUMENT")
    private String learningMethod; // ZOOM, FACE_TO_FACE, VIDEO, DOCUMENT

    @NotNull
    private int maxParticipants;

    @NotNull
    @Positive
    private double price;

    //------------Relations---------------//
    @ManyToOne
    @JoinColumn(name = "student_id") // Ensure this matches the `mappedBy` value in the `Student` entity
    @JsonIgnore
    private Student student;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    @JsonIgnore
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonIgnore
    private Course course;

    @OneToMany(mappedBy = "session",cascade = CascadeType.ALL)
    private Set<Document> documents;

    @OneToMany(mappedBy = "session",cascade = CascadeType.ALL)
    private Set<Video> videos;

    @OneToOne(mappedBy = "session", cascade = CascadeType.ALL)
    private ZoomMeeting zoomMeeting;

    @OneToOne(mappedBy = "session", cascade = CascadeType.ALL)
    private FaceToFace faceToFace;


}
