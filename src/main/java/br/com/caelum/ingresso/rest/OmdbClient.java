package br.com.caelum.ingresso.rest;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.ingresso.model.Filme;

@Service
public class OmdbClient {

	public <T> Optional<T> request(Filme filme, Class<T> clazz) {
		RestTemplate omdbClient = new RestTemplate();

		String titulo = filme.getNome().replace(" ", "+");

		String url = String.format("https://omdb-fj22.herokuapp.com/movie?title=%s", titulo);

		System.out.println(url);

		try {
			return Optional.ofNullable(omdbClient.getForObject(url, clazz));
		} catch (RestClientException e) {
			return Optional.empty();
		}
	}

}
