package pe.edu.vallegrande.AS221S5_T05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.AS221S5_T05.model.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
