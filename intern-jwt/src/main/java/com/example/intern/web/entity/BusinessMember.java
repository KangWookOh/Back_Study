package com.example.intern.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "bm")
public class BusinessMember implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key_id;

    @NotNull
    @ApiModelProperty(value = "사업자 번호")
    private Integer b_number;               // 사업자 번호

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty(value = "기기 번호")
    private String license;                 // 라이센스 번호

    // @OneToMany(mappedBy = "businessMember", fetch = FetchType.LAZY)
    //private List<Fastener> fastenerList;

//    @OneToMany(mappedBy = "businessMember", fetch = FetchType.LAZY)
//    private List<Posture> postureList;

    @ElementCollection(fetch = FetchType.EAGER)
    @JsonIgnore
    private List<String> roles = new ArrayList<>();

    @Builder
    public BusinessMember(Long key_id, Integer b_number, String license, List<String> roles) {
        this.key_id = key_id;
        this.b_number = b_number;
        this.license = license;
        this.roles = roles;
    }

    public BusinessMember(Integer b_number, String license) {
        this.b_number = b_number;
        this.license = license;
    }

    // 라이센스 확인
    public boolean matchLicense(String license) {
        return this.license.equals(license);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.license;
    }

    @Override
    public String getUsername() {
        return String.valueOf(this.b_number);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
