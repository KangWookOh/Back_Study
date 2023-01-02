//package com.example.intern.web.controller;
//
//import com.example.intern.web.service.FastenerService;
//import com.example.intern.web.service.PostureService;
//import io.swagger.annotations.Api;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@RestController
//@RequiredArgsConstructor
//@Api(tags = {"CSV API"})
//public class ExportController {
//
//    private final PostureService postureService;
//    private final FastenerService fastenerService;
//
//    @GetMapping("/pos/export/{id}")
//    public void exportPos(HttpServletResponse response, @PathVariable Long id) throws IOException {
//        postureService.posCsv(response, id);
//    }
//
//    @GetMapping("/fas/export/{id}")
//    public void exportToFas(HttpServletResponse response, @PathVariable Long id) throws IOException {
//        fastenerService.fasCsv(response, id);
//    }
//}
