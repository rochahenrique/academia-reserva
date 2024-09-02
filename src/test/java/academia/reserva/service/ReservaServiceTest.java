package academia.reserva.service;

import academia.reserva.entities.Reserva;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ReservaServiceTest {

    private ReservaService reservaService = new ReservaService();

    @Test
    public void naoPodeCriarReservaNoHorarioInvalido(){
        Reserva reserva = new Reserva();
        reserva.setUsuario("Henrique");
        reserva.setInicio(LocalDateTime.of(2024,8,20,04,0));
        reserva.setFim(LocalDateTime.of(2024,8,28,5,30));

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            reservaService.criarReserva(reserva);
        });

        Assertions.assertEquals("Reservas da academia são permitidas entre 06h00 até 22h00.",exception.getMessage());
    }
}
