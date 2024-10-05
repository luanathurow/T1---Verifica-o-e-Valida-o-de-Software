import java.time.LocalDateTime;

public class EstacionamentoModel {
    
    private boolean clienteVip;
    private LocalDateTime horarioEntrada;
    private LocalDateTime horarioSaida;

    public EstacionamentoModel(boolean clienteVip, LocalDateTime horarioEntrada, LocalDateTime horarioSaida) {
        this.clienteVip = clienteVip;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
    }

    public boolean isClienteVip() {
        return clienteVip;
    }

    public void setClienteVip(boolean clienteVip) {
        this.clienteVip = clienteVip;
    }

    public LocalDateTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(LocalDateTime horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public LocalDateTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalDateTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }
}
