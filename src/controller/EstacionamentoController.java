import java.time.Duration;
import java.time.LocalDateTime;

public class EstacionamentoController {

    // valores fixos
    private static final double TARIFA_FIXA_ATE_UMA_HORA = 5.90;
    private static final double TARIFA_POR_HORA_EXTRA = 2.50;
    private static final double TARIFA_PERNOITE = 50.00;
    private static final int MINUTOS_CORTESIA = 15;

    public double calcularTarifa(EstacionamentoModel estacionamento) {
        LocalDateTime horarioEntrada = estacionamento.getHorarioEntrada();
        LocalDateTime horarioSaida = estacionamento.getHorarioSaida();

        long diferencaMinutos = calcularDiferencaMinutos(horarioEntrada, horarioSaida);

        if (diferencaMinutos <= MINUTOS_CORTESIA) {
            return 0.0;
        }

        if (pernoitou(horarioEntrada, horarioSaida)) {
            double tarifa = TARIFA_PERNOITE;
            return estacionamento.isClienteVip() ? tarifa / 2 : tarifa;
        }

        double tarifa = 0.0;
        if (diferencaMinutos <= 60) {
            tarifa = TARIFA_FIXA_ATE_UMA_HORA;
        } else {
            tarifa = TARIFA_FIXA_ATE_UMA_HORA + ((diferencaMinutos - 60) / 60) * TARIFA_POR_HORA_EXTRA;
        }

        if (estacionamento.isClienteVip()) {
            tarifa /= 2;
        }

        return tarifa;
    }

    private long calcularDiferencaMinutos(LocalDateTime entrada, LocalDateTime saida) {
        return Duration.between(entrada, saida).toMinutes();
    }

    private boolean pernoitou(LocalDateTime entrada, LocalDateTime saida) {
        return saida.getDayOfMonth() > entrada.getDayOfMonth() && saida.getHour() >= 8;
    }
}
