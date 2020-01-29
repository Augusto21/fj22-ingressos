package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class DescontoParaEstudantes implements Desconto {

	private final BigDecimal TAXA_DESCONTO = new BigDecimal("2.0");

	@Override
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
		return precoOriginal.divide(TAXA_DESCONTO);
	}

}
