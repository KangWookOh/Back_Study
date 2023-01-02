package com.example.intern2.web.service;

import com.example.intern2.web.dto.BpmDto;
import com.example.intern2.web.entity.Bpm;
import com.example.intern2.web.entity.User;
import com.example.intern2.web.repository.BpmRepository;
import com.example.intern2.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BpmService {

    private final BpmRepository bpmRepository;
    private final UserRepository userRepository;

    @Transactional
    public Bpm input(BpmDto bpmDto)
    {
        User user =userRepository.findById(bpmDto.getUser_id()).get();
        Bpm bpm =Bpm.builder()
                .dia(bpmDto.getDia())
                .sys(bpmDto.getSys())
                .pulse(bpmDto.getPulse())
                .uid(user)
                .build();


        return bpmRepository.save(bpm);

    }




    @Transactional
    public List<BpmDto> getList(String userId)
    {
        List<Bpm> bpms =bpmRepository.findUserByBpm(userId);
        List<BpmDto> bpmDtos = new ArrayList<>();
        for(Bpm b : bpms){
            BpmDto dto = BpmDto.builder()
                    .uid(b.getUid())
                    .dia(b.getDia())
                    .sys(b.getSys())
                    .pulse(b.getPulse())
                    .build();

            bpmDtos.add(dto);
        }
        return bpmDtos;
    }

    @Transactional
    public List<Bpm> getList()
    {
        return bpmRepository.findAll();
    }

}
