package com.quill.test.controller;
import com.quill.test.model.Quill;
import com.quill.test.service.QuillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Controller
public class QuillController {
	final String HTML_FILE_PATH = "src/main/resources/static/html/";
	
    @Autowired
    private QuillService quillService;

    @GetMapping({"","/","/create"})
    public String index(Model model) {
        List<Quill> posts = quillService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }


    @PostMapping("/save")
    public String savePost(@RequestParam(required = false) Long id, @RequestParam String title, @RequestParam String content) throws IOException {
        Quill quill;
        if (id != null && id > 0) {
            quill = quillService.getPostById(id);
            if (quill == null) {
                
                return "redirect:/edit/{id}";
            }
        } else {
            quill = new Quill();
            String fileName = UUID.randomUUID().toString() + ".html";
            quill.setHtmlFileName(fileName);
        }

        String filePath = HTML_FILE_PATH + quill.getHtmlFileName();
        if (Files.exists(Paths.get(filePath))) {
            // Update existing file
            Files.write(Paths.get(filePath), content.getBytes());
        } else {
            // Create new file
            Files.write(Paths.get(filePath), content.getBytes());
        }

        quill.setTitle(title);
        quillService.savePost(quill);
        return "redirect:/create";
    }

    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable Long id, Model model) throws IOException {
        Quill post = quillService.getPostById(id);
        if (post == null) {
         
            return "redirect:/edit/{id}";
        }

        String content = new String(Files.readAllBytes(Paths.get(HTML_FILE_PATH + post.getHtmlFileName())));
        model.addAttribute("post", post);
        model.addAttribute("content", content);
        return "edit";
    }
    
    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        Quill post = quillService.getPostById(id);
        if (post != null) {
            try {
                Files.deleteIfExists(Paths.get(HTML_FILE_PATH + post.getHtmlFileName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            quillService.deletePost(id);
        }
        return "redirect:/create";
    }
}
