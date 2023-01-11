package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentorRepository extends JpaRepository<Mentor, Integer> {

    Optional<Mentor> findByIdMentor(int id);
}
