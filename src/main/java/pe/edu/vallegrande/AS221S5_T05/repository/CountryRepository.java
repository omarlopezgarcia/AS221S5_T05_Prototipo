package pe.edu.vallegrande.AS221S5_T05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
