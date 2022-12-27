package com.example.chang_intern1.web.service;

import com.example.chang_intern1.web.entity.Bpm;
import com.example.chang_intern1.web.entity.dto.BpmDto;
import com.example.chang_intern1.web.repository.BpmRepositroy;
import com.example.chang_intern1.web.repository.UserRepositroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BpmService  {
    private final UserRepositroy userRepositroy;

    private final BpmRepositroy bpmRepositroy;


//    @Transactional
//    public List<BpInfoDto> getList(String userName)
//    {
//        List<BpInfo> bpInfos = bpInfoRepositroy.findMemberByBpInfo(userName);
//        List<BpInfoDto> bpInfoDto = new ArrayList<>();
//
//        for(BpInfo b : bpInfos){
//            BpInfoDto dto = BpInfoDto.builder()
//                    .max_bp(b.getMax_bp())
//                    .min_bp(b.getMin_bp())
//                    .type(b.getType())
//                    .user(b.getUser())
//                    .build();
//            bpInfoDto.add(dto);
//        }
//        return bpInfoDto;
//    }

    @Transactional
    public List<BpmDto> InfoByUser(String user)
    {
        List<Bpm> bpInfos = bpmRepositroy.findUserByBpInfo(user);
        List<BpmDto> bpInfoDtos =new ArrayList<>();
        for(Bpm b : bpInfos){
            BpmDto dto = BpmDto.builder()
                    .dia(b.getDIA())
                    .sys(b.getSYS())
                    .pulse(b.getPULSE())
                    .build();
            bpInfoDtos.add(dto);
        }
        return bpInfoDtos;


    }




}
