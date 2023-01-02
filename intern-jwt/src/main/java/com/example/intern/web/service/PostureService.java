package com.example.intern.web.service;

import com.example.intern.web.dto.posture.CreatePostureDto;
import com.example.intern.web.entity.Posture;
import com.example.intern.web.repository.PostureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostureService {

    private final PostureRepository postureRepository;

    @Transactional
    public Posture createPosture(CreatePostureDto createPostureDto) {
        Posture posture = Posture.builder()
                .bm(createPostureDto.getBm())
                .bd(createPostureDto.getBd())
                .td(createPostureDto.getTd())
                .bp(createPostureDto.getBp())
                .tp(createPostureDto.getTp())
                .t_f(createPostureDto.getT_f())
                .build();

        return postureRepository.save(posture);
    }

    public List<Posture> getAllList() {
        return postureRepository.findAll();
    }

    @Transactional
    public List<CreatePostureDto> getList(String license) {
        List<Posture> postures = postureRepository.findMemberByPosture(license);
        List<CreatePostureDto> createPostureDto = new ArrayList<>();

        for (Posture p : postures) {
            CreatePostureDto dto = CreatePostureDto.builder()
                    .createTime(p.getCreateTime())
                    .createDate(p.getCreateDate())
                    .t_f(p.getT_f())
                    .tp(p.getTp())
                    .td(p.getTd())
                    .bp(p.getBp())
                    .bd(p.getBd())
                    .bm(p.getBusinessMember())
                    .build();
            createPostureDto.add(dto);
        }
        return createPostureDto;
    }


    /**
     * CSV
     * @param response
     * @param id
     * @throws IOException
     */
//    @Transactional
//    public void posCsv(HttpServletResponse response, Long id) throws IOException {
//        List<Posture> listposture = postureRepository.findMemberByPosture(id);
//        if (id == null) {
//            throw new NullPointerException("Id를 찾지 못했습니다");
//        }
//
//        response.setContentType("text/csv; charset=MS949");
//        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
//        String currentDateTime = dateFormatter.format(new Date());
//
//        // HTTP 헤더와 ContentType 설정
//        String headerKey = "Content-Disposition";
//        String headerValue = "attachment; filename=result_" + currentDateTime + ".csv";
//        response.setHeader(headerKey, headerValue);
//
//        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
//        String[] csvHeader = {"날짜", "시간", "상부변위", "하부변위", "상가압", "하가압", "양불"};         // csv 파일 컴럼명
//        String[] nameMapping = {"createDate", "createTime", "td", "bd", "tp", "bp", "t_f"};     // db 컬럼명
//        csvWriter.writeHeader(csvHeader);
//
//        for (Posture posture : listposture) {
//            csvWriter.write(posture, nameMapping);
//        }
//
//        csvWriter.close();
//    }
}


// 세션처리
//        Object logInfo = session.getAttribute("logInfo");
//        String s = objectMapper.writeValueAsString(logInfo);
//
//        JsonNode jsonNode = objectMapper.readTree(s);
//        String license = jsonNode.get("license").asText();