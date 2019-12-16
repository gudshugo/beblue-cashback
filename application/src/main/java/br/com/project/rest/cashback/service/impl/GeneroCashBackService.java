package br.com.project.rest.cashback.service.impl;

import br.com.project.rest.cashback.enumeration.DiaEnum;
import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.repository.GeneroCashBackRepository;
import br.com.project.rest.cashback.service.IGeneroCashBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroCashBackService implements IGeneroCashBackService {

    private final GeneroCashBackRepository generoCashBackRepository;

    @Autowired
    public GeneroCashBackService(GeneroCashBackRepository generoCashBackRepository){
        this.generoCashBackRepository = generoCashBackRepository;
    }

    @Override
    public List<Disco> findGeneroCashBackPorGeneroHoje(List<Long> discos, DiaEnum dia){
        return generoCashBackRepository.findGeneroCashBackByGeneroInAndDia(discos, dia);
    }
}
