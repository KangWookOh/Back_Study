package com.example.work.commute;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CommuteController {
    private final CommuteRepository commuteRepository;
}
