package br.com.elebasi.who_owes_me.dto;

import br.com.elebasi.who_owes_me.entity.Debtor;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class DebtorDTO {
    private long id;

    @NotBlank
    private String name;

    public static DebtorDTO converter(Debtor debtor){
        return DebtorDTO.builder().id(debtor.getId()).name(debtor.getName()).build();
    }
}
