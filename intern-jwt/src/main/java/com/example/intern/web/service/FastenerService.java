package com.example.intern.web.service;

import com.example.intern.web.dto.fastener.CreateFastenerDto;
import com.example.intern.web.entity.Fastener;
import com.example.intern.web.repository.FastenerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FastenerService {

    private final FastenerRepository fastenerRepository;

    @Transactional
    public Fastener CreatFastener(CreateFastenerDto createFastenerDto) {
        Fastener fastener =Fastener.builder()
                .height(createFastenerDto.getHeight())
                .fd(createFastenerDto.getFd())
                .pv(createFastenerDto.getPv())
                .tv(createFastenerDto.getTv())
                .t_f(createFastenerDto.getT_f())
                .bm(createFastenerDto.getBm())
                .build();
        return fastenerRepository.save(fastener);
    }

    @Transactional
    public List<CreateFastenerDto> getList(String license) {
        List<Fastener> fasteners = fastenerRepository.findMemberByFastener(license);
        List<CreateFastenerDto> createFastenerDto = new ArrayList<>();

        for (Fastener f : fasteners) {
            CreateFastenerDto dto = CreateFastenerDto.builder()
                    .createTime(f.getCreateTime())
                    .createDate(f.getCreateDate())
                    .t_f(f.getT_f())
                    .fd(f.getFd())
                    .height(f.getHeight())
                    .pv(f.getPv())
                    .tv(f.getTv())
                    .bm(f.getBusinessMember())
                    .build();
            createFastenerDto.add(dto);
        }

        return createFastenerDto;
    }

    /**
     * CSV
     * @param response
     * @param id
     * @throws IOException
     */
//    @Transactional
//    public void fasCsv(HttpServletResponse response, Long id) throws IOException {
//        List<Fastener> listfastner = fastenerRepository.findMemberByFastener(id);
//        if (id == null) {
//            throw new NullPointerException("Id를 찾지 못했습니다");
//        }
//
//        response.setContentType("text/csv; charset=MS949");
//        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
//        String currentDateTime = dateFormatter.format(new Date());
//
//        String headerKey = "Content-Disposition";
//        String headerValue = "attachment; filename=result_" + currentDateTime + ".csv";
//        response.setHeader(headerKey, headerValue);
//
//        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
//        String[] csvHeader = {"날짜", "시간", "원자재 높이", "체결 편차", "압력", "토크값", "양불"};
//        String[] nameMapping = {"createDate", "createTime", "height", "fd", "pv", "tv", "t_f"};
//        csvWriter.writeHeader(csvHeader);
//
//        for (Fastener fastener : listfastner) {
//            csvWriter.write(fastener, nameMapping);
//        }
//
//        csvWriter.close();
//    }
}
