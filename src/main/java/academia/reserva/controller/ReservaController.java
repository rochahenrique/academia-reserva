package academia.reserva.controller;


import academia.reserva.entities.Reserva;
import academia.reserva.exception.HorarioInvalidoException;
import academia.reserva.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "*")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    /**
     *
     * @param reserva : cria a reserva a ser criada(Nome do responsável, hora de início, hora final)
     * @return : A resposta HTTP com o status e corpo contendo a nova reserva ou mensagem de erro.
     */
    @PostMapping
    public ResponseEntity<?> criarReserva(@RequestBody Reserva reserva){
        try{
            Reserva novaReserva = reservaService.criarReserva(reserva);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaReserva);
        } catch (HorarioInvalidoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    /**
     * Lista todas as reservas da academia
     *
     * @return : A resposta HTTP com o status OK e a relação de reservas existentes.
     */
    @GetMapping
    public ResponseEntity<List<Reserva>> listarReserva() {
        List<Reserva> reservas = reservaService.listarReservas();
        return ResponseEntity.ok(reservas);
    }

    /**
     * Exclui uma reserva específica pelo seu ID
     *
     * @param id : O ID da reserva a ser excluída.
     * @return : A resposta HTTP com status OK se a reserva for deletada com sucesso ou NOT FOUND caso a reserva não existir.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarReserva(@PathVariable Long id) {
        Optional<Reserva> reservaExistente = reservaService.buscarReservaPorId(id);
        if (reservaExistente.isPresent()) {
            reservaService.deletarReserva(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva não encontrada.");
        }
    }

}
