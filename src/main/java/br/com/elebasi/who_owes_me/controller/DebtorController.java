package br.com.elebasi.who_owes_me.controller;

import br.com.elebasi.who_owes_me.dto.DebtorDTO;
import br.com.elebasi.who_owes_me.service.DebtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("debtor")
public class DebtorController {

    @Autowired
    private DebtorService debtorService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody DebtorDTO debtorDTO){
        debtorService.saveDebtor(debtorDTO);
        return ResponseEntity.created(URI.create("")).build();
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody DebtorDTO debtorDTO) throws Exception {
        debtorService.updateDebtor(debtorDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam long id) throws Exception{
        debtorService.deleteDebtor(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<DebtorDTO>> getAllDebtors(){
        return ResponseEntity.ok(debtorService.findAll());
    }
}
