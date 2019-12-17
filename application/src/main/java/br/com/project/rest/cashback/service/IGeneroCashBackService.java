package br.com.project.rest.cashback.service;

import br.com.project.rest.cashback.enumeration.DiaEnum;
import br.com.project.rest.cashback.model.Disco;

import java.util.List;

public interface IGeneroCashBackService {

    List<Double> findGeneroCashBackPorGeneroHoje(List<Long> discos, DiaEnum dia);

}
