package com.example.intern.web.dto.bmember;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginInfo {

    private Long key_id;

    @NotNull
    @ApiModelProperty(value = "사업자 번호")
    private Integer b_number;

    @NotNull
    @ApiModelProperty(value = "기기 번호")
    private String license;

    public LoginInfo(Long key_id, Integer b_number, String license) {
        this.key_id = key_id;
        this.b_number = b_number;
        this.license = license;
    }
}
