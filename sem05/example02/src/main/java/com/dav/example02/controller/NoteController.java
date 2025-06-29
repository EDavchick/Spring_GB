package com.dav.example02.controller;

import com.dav.example02.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class NoteController {

    private final NoteService noteService;


}
