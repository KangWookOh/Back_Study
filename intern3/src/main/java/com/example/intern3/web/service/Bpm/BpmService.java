package com.example.intern3.web.service.Bpm;

import com.example.intern3.web.dto.BpmDto;
import com.example.intern3.web.entity.Bpm;
import com.example.intern3.web.entity.User;
import com.example.intern3.web.repository.BpmRepository;
import com.example.intern3.web.repository.UserRespository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BpmService {
    private final UserRespository userRespository;
    private final BpmRepository bpmRepository;
    @Transactional(readOnly = true)
    public  List<Bpm> getAll(HttpServletRequest request)
    {
        return bpmRepository.findBpmByUser(getId(request));

    }
    @Transactional
    public Long addInfo(HttpServletRequest request, BpmDto bpmDto)
    {
        String getUserId =findUserId(request);
        User user = userRespository.findUserByUserId(getUserId);
        Bpm bpm = bpmRepository.save(
                Bpm.builder()
                        .user(user)
                        .dia(bpmDto.getDia())
                        .sys(bpmDto.getSys())
                        .pulse(bpmDto.getPulse())
                        .build());
        return bpm.getId();
    }
    private Long getId(HttpServletRequest request)
    {
        String getUserId = findUserId(request);
        return userRespository.findByuserId(getUserId).get().getId();
    }

    private String findUserId(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        Object sessionId = session.getAttribute("sessionId");
        User sessionUser =(User)sessionId;
        return sessionUser.getUsername();
    }

}
