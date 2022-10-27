package br.com.elebasi.who_owes_me.service;

import br.com.elebasi.who_owes_me.dto.LitleBoxDTO;
import br.com.elebasi.who_owes_me.entity.LitleBox;
import br.com.elebasi.who_owes_me.exception.LitleBoxException;
import br.com.elebasi.who_owes_me.exception.NotFoundException;
import br.com.elebasi.who_owes_me.repository.LitleBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LitleBoxService {

    @Autowired
    private LitleBoxRepository litleBoxRepository;

    public void createLitleBox(LitleBoxDTO litleBoxDTO){
        litleBoxRepository.save(new LitleBox(litleBoxDTO.getTitle()));
    }

    public LitleBoxDTO getLitleBoxByTitle(String title) throws Exception{
        Optional<LitleBox> litleBoxOpt = litleBoxRepository.findByTitle(title); //Lembrar de colocar unique na coluna de titulo na base de dados.

        if(!litleBoxOpt.isPresent()){
            throw new NotFoundException(404, "LitleBox não encontrada");
        }

        return LitleBoxDTO.converter(litleBoxOpt.get());
    }

    public List<LitleBoxDTO> findAll(){
        List<LitleBox> litleBoxList = litleBoxRepository.findAll();
        return litleBoxList.stream().map(litleBox -> LitleBoxDTO.converter(litleBox)).toList();
    }

    public void updateLitleBox(LitleBoxDTO litleBoxDTO) throws Exception{
        Optional<LitleBox> litleBoxOpt = litleBoxRepository.findById(litleBoxDTO.getId());

        if(!litleBoxOpt.isPresent()){
            throw new NotFoundException(4001, "LitleBox não encontrada");
        }

        LitleBox newLitleBox = litleBoxOpt.get();

        newLitleBox.setTitle(litleBoxDTO.getTitle());

        litleBoxRepository.save(newLitleBox);
    }

    public void deleteLitleBox(long id) throws Exception{
        Optional<LitleBox> litleBoxOpt = litleBoxRepository.findById(id);

        if(!litleBoxOpt.isPresent()){
            throw new NotFoundException(404, "LitleBox não encontrada");
        }
        litleBoxRepository.delete(litleBoxOpt.get());
    }

}
