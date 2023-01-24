package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.Mentor;
import hr.foi.air.ednevnik.Entities.Specijalizant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MentorRepository extends JpaRepository<Mentor, Integer> {

    Mentor findAllByEmail(String email);

    Optional<Mentor> findByIdMentor(int id);

    List<Mentor> findAllByUstrojstvenaJedinica(int id);
}
