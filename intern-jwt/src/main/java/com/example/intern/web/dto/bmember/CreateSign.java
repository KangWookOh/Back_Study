package com.example.intern.web.dto.bmember;

import com.example.intern.web.entity.Fastener;
import com.example.intern.web.entity.Posture;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreateSign {

    private Long key_id;

    @ApiModelProperty(value = "사업자 번호")
    private Integer b_number;

    @Embedded
    @Column(nullable = false)
    @ApiModelProperty(value = "기기 번호")
    private String license;

    private List<Posture> postureList;
    private List<Fastener> fastenerList;

    private List<String> roles = new ArrayList<>();

    @Builder
    public CreateSign(Integer b_number, String license) {
        this.b_number = b_number;
        this.license = license;
    }

    @Builder
    public CreateSign(Long key_id, Integer b_number, String license) {
        this.key_id = key_id;
        this.b_number = b_number;
        this.license = license;
        roles.add("ROLE_USER");
    }

    @Builder
    public CreateSign(Long key_id, Integer b_number, String license, List<Posture> postureList, List<Fastener> fastenerList) {
        this.key_id = key_id;
        this.b_number = b_number;
        this.license = license;
        this.postureList = postureList;
        this.fastenerList = fastenerList;
    }
}
