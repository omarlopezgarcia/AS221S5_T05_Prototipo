package pe.edu.vallegrande.AS221S4_T16_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
