package servico;

import interfaces.ServicoPagamentoOnline;

public class ServiçoPaypal implements ServicoPagamentoOnline {

	@Override
	public double taxaPagamento(double Valor) {
		// TODO Auto-generated method stub
		Valor +=(Valor* 0.02);
		return Valor;
	}

	@Override
	public double adicaoJuros(double Valor, int numeroparcela) {
		// TODO Auto-generated method stub
		Valor += (Valor*0.01)*numeroparcela;
		
		return Valor;
	}

}
