public class Main {
    public static void main(String[] args) {

        EstacionamentoController controller = new EstacionamentoController();
        
        // precisa criar as partições de testes e adicionar aqui
        Date entrada = new Date(); 
        Date saida = new Date();   
        boolean isVip = false;     
        
        double valor = controller.calcularValor(entrada, saida, isVip);
        System.out.println("Valor a ser pago: R$ " + valor);
    }
}
