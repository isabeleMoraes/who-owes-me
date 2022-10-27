package br.com.elebasi.who_owes_me.dto;

import br.com.elebasi.who_owes_me.entity.LitleBox;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class LitleBoxDTO {
    private long id;

    @NotBlank
    private String title;

    public static LitleBoxDTO converter(LitleBox litleBox){
        return LitleBoxDTO.builder().id(litleBox.getId()).title(litleBox.getTitle()).build();
    }
}
