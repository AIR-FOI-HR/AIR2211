package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.Mentor;
import hr.foi.air.ednevnik.Entities.Specijalizant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SpecijalizantRepository extends JpaRepository<Specijalizant, Integer> {
    List<Specijalizant> findAll();

    Optional<Specijalizant> findAllByIdSpecijalizant(int id);

    @Query(value = "SELECT s FROM Specijalizant s INNER JOIN Specijalizacija sp ON s.idSpecijalizant=sp.specijalizant INNER JOIN Mentor m ON sp.glavniMentor=m.idMentor WHERE m.idMentor = :id")
    List<Specijalizant> findAllSpecijalizantiByMentorId(@Param("id") int id);

    @Transactional
    Long deleteByIdSpecijalizant(int id);

}
