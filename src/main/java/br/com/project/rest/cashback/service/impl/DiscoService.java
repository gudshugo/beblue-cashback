package br.com.project.rest.cashback.service.impl;

import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.repository.DiscoRepository;
import br.com.project.rest.cashback.service.IDiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscoService implements IDiscoService {

    private final DiscoRepository discoRepository;

    @Autowired
    public DiscoService(DiscoRepository discoRepository){
        this.discoRepository = discoRepository;
    }

    @Override
    public void saveDiscos(List<Disco> discos){
        discoRepository.saveAll(discos);
    }

    @Override
    public Long checkIfExistsAnyEntry(){
        return discoRepository.checkIfExistsAnyEntry();
    }

    @Override
    public Page<Disco> findAlbums(Long generoId, Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return discoRepository.findDiscoByGeneroId(generoId, pageRequest);
    }


}
