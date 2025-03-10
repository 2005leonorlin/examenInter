package org.example.examenfinalinterfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {
    @Autowired ItemRepository itemRepository;

    @GetMapping("/")
    public String index(Model model) {
        var items = itemRepository.findAll();
        model.addAttribute("titulo", "Listado de Items");
        model.addAttribute("items", items);
        return "index";
    }

    @GetMapping("/{id}")
    public String detalle(@PathVariable String id, Model model) {
        var item = itemRepository.findById(id).orElse(null);
        model.addAttribute("titulo", "Detalles del Item");
        model.addAttribute("item", item);
        return "detalle";
    }

}
