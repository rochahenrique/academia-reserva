package academia.reserva.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do responsável deve ser informado")
    @Size(min =3, message = "O nome do responsável deve ter no mínimo 3 caracteres")
    private String usuario;

    @NotNull(message = "A hora inicila da reserva deve ser informada")
    private LocalDateTime inicio;

    @NotNull(message = "A hora final da reserva deve ser informada")
    private LocalDateTime fim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "O nome do responsável deve ser informado") @Size(min = 3, message = "O nome do responsável deve ter no mínimo 3 caracteres") String getUsuario() {
        return usuario;
    }

    public void setUsuario(@NotBlank(message = "O nome do responsável deve ser informado") @Size(min = 3, message = "O nome do responsável deve ter no mínimo 3 caracteres") String usuario) {
        this.usuario = usuario;
    }

    public @NotNull(message = "A hora inicila da reserva deve ser informada") LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(@NotNull(message = "A hora inicila da reserva deve ser informada") LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public @NotNull(message = "A hora final da reserva deve ser informada") LocalDateTime getFim() {
        return fim;
    }

    public void setFim(@NotNull(message = "A hora final da reserva deve ser informada") LocalDateTime fim) {
        this.fim = fim;
    }
}
