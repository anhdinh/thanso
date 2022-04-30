package aisa.andygroup.controller.dto;

import lombok.Data;

@Data
public class ResponseDto {
    private String message;
    public ResponseDto(){}
    public ResponseDto(String msg){
        this.message = msg;
    }
}
