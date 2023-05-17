package com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse  extends BaseResponse{

    private String token;

}
