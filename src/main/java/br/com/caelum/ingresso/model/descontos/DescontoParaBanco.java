package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class DescontoParaBanco implements Desconto {

	private final BigDecimal PORCENTAGEM = new BigDecimal("0.3");

	@Override
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
		return precoOriginal.subtract(trintaPorCentoSobre(precoOriginal));
	}

	private BigDecimal trintaPorCentoSobre(BigDecimal precoOriginal) {
		return precoOriginal.multiply(PORCENTAGEM);
	}

	@Override
	public String getDescricao() {
		return "Desconto Banco";
	}
}
