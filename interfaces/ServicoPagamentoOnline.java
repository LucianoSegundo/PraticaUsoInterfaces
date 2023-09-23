package interfaces;

public interface ServicoPagamentoOnline {

	public double taxaPagamento(double Valor);
	double adicaoJuros(double Valor, int numeroparcela);
}
