package pe.edu.vallegrande.AS221S5_T05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Ubigeo;

import java.util.List;

@Repository
public interface UbigeoRepository extends JpaRepository<Ubigeo, Long> {
    @Query(value = "SELECT u FROM Ubigeo u ORDER BY u.district ASC")
    List<Ubigeo> findAllOrderByDistrictAsc();
}
