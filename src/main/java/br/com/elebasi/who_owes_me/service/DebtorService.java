package br.com.elebasi.who_owes_me.service;

import br.com.elebasi.who_owes_me.dto.DebtorDTO;
import br.com.elebasi.who_owes_me.entity.Debtor;
import br.com.elebasi.who_owes_me.exception.DebtorException;
import br.com.elebasi.who_owes_me.exception.NotFoundException;
import br.com.elebasi.who_owes_me.repository.DebtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DebtorService {
    @Autowired
    private DebtorRepository repository;

    public void saveDebtor(DebtorDTO debtorDTO){

        repository.save(new Debtor(debtorDTO.getName()));
    }

    public void updateDebtor(DebtorDTO debtorDTO) throws Exception{
        Optional<Debtor> debtorOpt = repository.findById(debtorDTO.getId());

        if(!debtorOpt.isPresent()){
            throw new NotFoundException(404,"Devedor nao encontrado");
        }
        Debtor newDebtor = debtorOpt.get();
        newDebtor.setName(debtorDTO.getName());

        repository.save(newDebtor);
    }

    public void deleteDebtor(long id) throws Exception{
        Optional<Debtor> debtorOpt = repository.findById(id);

        if(!debtorOpt.isPresent()){
            throw new NotFoundException(404,"Devedor não encontrado");
        }
        repository.delete(debtorOpt.get());
    }

    public List<DebtorDTO> findAll(){
        List<Debtor> debtorList = repository.findAll();
        return debtorList.stream().map(debtor -> DebtorDTO.converter(debtor)).toList();
    }
}
