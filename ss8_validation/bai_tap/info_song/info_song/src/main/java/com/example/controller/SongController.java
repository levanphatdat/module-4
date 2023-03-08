package com.example.controller;

import com.example.dto.SongDTO;
import com.example.model.Song;
import com.example.service.ISongService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("songList", songService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songDTO", new SongDTO());
        return "/create";
    }

    @PostMapping("/showCreate")
    public String formCreate(@Valid @ModelAttribute SongDTO songDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/create";
        }

        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        songService.create(song);
        redirectAttributes.addFlashAttribute("msg", "msg.createSuccess");
        return "redirect:/song";
    }

    @GetMapping("/showEdit")
    public String showEditForm(@RequestParam int id, Model model) {
        SongDTO songDTO = new SongDTO();
        BeanUtils.copyProperties(songService.findById(id), songDTO);
        model.addAttribute("songOTD", songDTO);
        return "/edit";
    }

    @PostMapping("/edit")
    public String formEdit(@Valid @ModelAttribute SongDTO songDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        songService.update(song);

        redirectAttributes.addFlashAttribute("message", "msg.editSuccess");
        return "redirect:/song";
    }
}