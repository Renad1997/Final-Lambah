package com.example.finalproject.Repository;

import com.example.finalproject.Model.Review;
import com.example.finalproject.Model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Integer> {

    Tutor findTutorById (Integer id);

    Tutor findTutorByFirstName(String firstName);

   List<Tutor> findTutorByGpa(double gpa);




}
