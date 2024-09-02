package academia.reserva.service;


import academia.reserva.entities.Reserva;
import academia.reserva.exception.HorarioInvalidoException;
import academia.reserva.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    /**
     * Valida uma reserva para garantir que ela atende às restrições de
     * horário e disponibilidade
     *
     * @param reserva : A reserva a ser validada.
     * @throws Exception : Se já existir uma reserva no horário solicitado
     * ou se a reserva no mesmo horário
     * @throws HorarioInvalidoException : Se a reserva não atender as restrição de
     * horário.
     */
   private void validarReserva (Reserva reserva) throws Exception{
       LocalTime inicio = reserva.getInicio().toLocalTime();
       LocalTime fim  = reserva.getFim().toLocalTime();

       if(inicio.isBefore(LocalTime.of(6,0)) || fim.isAfter(LocalTime.of(22,0))){
           throw new HorarioInvalidoException("Reservas da academia são permitidas entre 06h00 até 22h00.");
       }

       boolean conflitoReserva = reservaRepository
               .findByInicioLessThanEqualAndFimGreaterThanEqual(reserva.getFim(),reserva.getInicio())
               .stream()
               .anyMatch(r -> !r.getId().equals(reserva.getId()));

       if(conflitoReserva){
           throw new Exception("Já existe uma reserva nesse horário.");
       }

       if (reserva.getInicio().isBefore(LocalDateTime.now())){
           throw new Exception("Não é possível realizar reservas no passado.");
       }


   }

    /**
     * Cria uma nova reserva após validar as restrições de horário e disponibilidade
     *
     * @param reserva: A reserva a ser criada
     * @return : A reserva criada
     * @throws Exception Se a reserva não atender às restrições de horário
     * ou já existir uma reserva
     */
    public Reserva criarReserva(Reserva reserva) throws Exception {
        validarReserva(reserva);
        return reservaRepository.save(reserva);
    }

    /**
     * Busca uma reserva pelo seu ID.
     *
     * @param id : O ID da reserva a ser buscada
     * @return : UM optional contendo a reserva se encontrada ou vazio se não encontrada.
     */
    public Optional<Reserva> buscarReservaPorId(Long id) {
       return reservaRepository.findById(id);
    }

    /**
     * Lista todas as reservas existentes
     *
     * @return Uma lista de todas as reservas
     */
   public List<Reserva> listarReservas() {
       return reservaRepository.findAll();
   }

    /**
     * Exclui uma reserva pelo seu ID
     *
     * @param id : O ID da reserva a ser excluída
     */
   public void deletarReserva(Long id) {
       reservaRepository.deleteById(id);
   }
}
