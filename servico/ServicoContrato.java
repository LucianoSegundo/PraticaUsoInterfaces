package servico;

import java.util.Calendar;
import entidades.Contrato;
import entidades.Prestacao;
import excessoes.CronologiaException;
import interfaces.ServicoPagamentoOnline;

public class ServicoContrato {
	private ServicoPagamentoOnline formaPagamento;


	public ServicoContrato(ServicoPagamentoOnline formaPagamento) {
		this.formaPagamento = formaPagamento;

	}

	public void processarContrato(Contrato contrato, int NumeroParcelas) throws CronologiaException {

		double valorParcela = contrato.getValorTotal() / NumeroParcelas;

		for (int i = 1; i <= NumeroParcelas; i++) {

// ajustando data da parcela
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(contrato.getDataContrato());
			calendario.add(Calendar.MONTH, i);

// ajustando valor da parcela     
			Double parcelaJuros = formaPagamento.adicaoJuros(valorParcela, i);
			Double parcelaTaxa = formaPagamento.taxaPagamento(parcelaJuros);

// salvando prestação
			Prestacao prestacao = new Prestacao(calendario.getTime(), parcelaTaxa);
			contrato.addPrestacao(prestacao);

		}

	}

}
