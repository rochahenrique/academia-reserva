package academia.reserva.repository;

import academia.reserva.entities.Reserva;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByInicioLessThanEqualAndFimGreaterThanEqual(LocalDateTime fim, LocalDateTime inicio);
}
