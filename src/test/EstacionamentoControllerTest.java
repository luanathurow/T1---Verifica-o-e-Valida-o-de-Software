import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class EstacionamentoControllerTest {

    EstacionamentoController controller = new EstacionamentoController();

    //exemplo, mas deve criar as partições e realizar os testes
    @ParameterizedTest
    @CsvSource({
        "2024-10-05T09:00, 2024-10-05T09:10, false, 0.0", // cortesia de 15 minutos
        "2024-10-05T09:00, 2024-10-05T10:00, false, 5.90", // ate 1 hora
        "2024-10-05T09:00, 2024-10-05T12:00, false, 10.90", // 3 horas
        "2024-10-05T09:00, 2024-10-06T09:00, false, 50.00", // pernoite
        "2024-10-05T09:00, 2024-10-05T12:00, true, 5.45"  // cliente VIP/ 3 horas
    })
    void testCalcularTarifa(String entradaStr, String saidaStr, boolean isVip, double expectedTarifa) {
        LocalDateTime entrada = LocalDateTime.parse(entradaStr);
        LocalDateTime saida = LocalDateTime.parse(saidaStr);
        EstacionamentoModel estacionamento = new EstacionamentoModel(isVip, entrada, saida);
        double tarifa = controller.calcularTarifa(estacionamento);
        assertEquals(expectedTarifa, tarifa, 0.01);
    }
}
