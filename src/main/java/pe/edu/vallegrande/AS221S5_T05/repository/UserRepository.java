package pe.edu.vallegrande.AS221S5_T05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.AS221S5_T05.model.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u WHERE u.rol.id!=1 AND u.active=?1 ORDER BY u.lastName ASC")
    List<User> findByActiveUser(String active);

    @Modifying
    @Query("UPDATE User u SET u.active='I' WHERE u.id=?1")
    void removeById(Long id);

    @Modifying
    @Query("UPDATE User u SET u.active='A' WHERE u.id=?1")
    void restoreById(Long id);
}
