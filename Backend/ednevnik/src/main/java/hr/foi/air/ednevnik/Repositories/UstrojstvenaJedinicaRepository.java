package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.UstrojstvenaJedinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UstrojstvenaJedinicaRepository extends JpaRepository<UstrojstvenaJedinica, Integer>  {

    Optional<UstrojstvenaJedinica> findByIdJedinica(int id);

    @Query(value = "SELECT uj FROM UstrojstvenaJedinica uj INNER JOIN DioSpecijalizacije ds ON uj.idJedinica=ds.ustrojstvenaJedinica INNER JOIN OdradeniDioSpecijalizacije ods ON ds.idDioSpecjalizacije=ods.dioSpecijalizacije INNER JOIN Specijalizacija s ON ods.specijalizacija=s.idSpecijalizacija WHERE s.specijalizant = :id_specijalizant AND ods.trajeDo IS NULL")
    Optional<UstrojstvenaJedinica> findCurrentBySpecijalizantId(@Param("id_specijalizant") int id_specijalizant);
}
