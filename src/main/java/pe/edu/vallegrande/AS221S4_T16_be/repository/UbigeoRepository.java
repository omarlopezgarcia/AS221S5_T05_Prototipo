package pe.edu.vallegrande.AS221S4_T16_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.AS221S4_T16_be.model.entity.Ubigeo;

import java.util.List;

@Repository
public interface UbigeoRepository extends JpaRepository<Ubigeo, Long> {
    @Query(value = "SELECT u FROM Ubigeo u ORDER BY u.district ASC")
    List<Ubigeo> findAllOrderByDistrictAsc();
}
