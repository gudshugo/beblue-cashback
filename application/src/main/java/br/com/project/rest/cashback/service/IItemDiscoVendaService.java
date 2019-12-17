package br.com.project.rest.cashback.service;

import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.model.dto.DiscosListaDTO;

import java.util.List;
import java.util.Map;

public interface IItemDiscoVendaService {

    Boolean saveItemVendaDisco(DiscosListaDTO discosLista);

    Map<Disco, Double> recuperarCashbackPorDiscos(List<Long> listaDiscosIds);

}
