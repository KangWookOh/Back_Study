package com.example.intern3.web.controller;

import com.example.intern3.web.dto.BpmDto;
import com.example.intern3.web.repository.BpmRepository;
import com.example.intern3.web.service.Bpm.BpmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class BpmController {
    private final BpmService bpmService;
    private final BpmRepository bpmRepository;

    @GetMapping("/Info")
    public String info(Model model, HttpServletRequest request)
    {
        model.addAttribute("info",bpmService.getAll(request));
        return "info";
    }
    @PostMapping("/info/addInfo")
    public String addInfo(HttpServletRequest request, @ModelAttribute("bpmDto")@RequestBody BpmDto bpmDto , Model model)
    {
        model.addAttribute("bpmDto",bpmService.addInfo(request,bpmDto));
        return "redirect:/info";
    }




}
