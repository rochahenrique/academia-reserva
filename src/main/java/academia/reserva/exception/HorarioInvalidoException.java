package academia.reserva.exception;

/**
 * Exceção lançada para indicar que o horário reserva é inválido caso estejá fora do intervalo permitido (06h00 às 22:00).
 *
 */
public class HorarioInvalidoException extends RuntimeException {

    public HorarioInvalidoException(String mensagem){
        super(mensagem);
    }
}
