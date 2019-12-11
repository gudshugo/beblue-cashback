package br.com.project.rest.cashback.service;

import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.model.Genero;

import java.util.List;

public interface IDiscoService {

    void saveDiscos(List<Disco> discos);
}
