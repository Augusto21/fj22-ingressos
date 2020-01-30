package br.com.caelum.ingresso.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class SessaoTest {

	@Test
	public void oPrecoDaSessaoDeveSerIgualASomaDoPrecoDaSalaMaisOPrecoDoFilme() {
		Sala sala = new Sala("Eldorado - IMax", new BigDecimal("22.5"));
		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12.0"));

		BigDecimal somaDosPrecosDaSalEFilme = sala.getPreco().add(filme.getPreco());

		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);

		assertEquals(somaDosPrecosDaSalEFilme, sessao.getPreco());
	}

	@Test
	public void garanteQueOLugarA1EstaOcupadoEOsLugaresA2EA3Disponiveis() {

		Lugar a1 = new Lugar("A", 1);
		Lugar a2 = new Lugar("A", 2);
		Lugar a3 = new Lugar("A", 3);

		Sala sala = new Sala("Eldorado - IMax", new BigDecimal("22.5"));
		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12.0"));

		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);

		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.INTEIRO, a1);

		Set<Ingresso> ingressos = Stream.of(ingresso).collect(Collectors.toSet());

		sessao.setIngressos(ingressos);

		assertFalse(sessao.isDisponivel(a1));
		assertTrue(sessao.isDisponivel(a2));
		assertTrue(sessao.isDisponivel(a3));
	}
}
