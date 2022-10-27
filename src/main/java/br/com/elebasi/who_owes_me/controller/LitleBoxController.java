package br.com.elebasi.who_owes_me.controller;

import br.com.elebasi.who_owes_me.dto.LitleBoxDTO;
import br.com.elebasi.who_owes_me.service.LitleBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("litlebox")
public class LitleBoxController {

    @Autowired
    private LitleBoxService litleBoxService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody LitleBoxDTO litleBoxDTO){
        litleBoxService.createLitleBox(litleBoxDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody LitleBoxDTO litleBoxDTO) throws Exception {
        litleBoxService.updateLitleBox(litleBoxDTO);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestParam long id) throws Exception {
        litleBoxService.deleteLitleBox(id);
    }

    @GetMapping
    public ResponseEntity<List<LitleBoxDTO>> findAll(){
        return ResponseEntity.ok(litleBoxService.findAll());
    }

}
