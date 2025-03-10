package org.example.examenfinalinterfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * WebController es un controlador de Spring MVC que maneja las solicitudes web para la aplicación.
 * Proporciona endpoints para mostrar una lista de ítems y los detalles de un ítem específico.
 */
@Controller
@RequestMapping("/web")
public class WebController {
    @Autowired ItemRepository itemRepository;
    /**
     * Maneja las solicitudes GET a la URL raíz ("/web/").
     * Recupera todos los ítems del repositorio y los añade al modelo.
     *
     * @param model el modelo al que se añaden los atributos
     * @return el nombre de la vista a renderizar ("index")
     */
    @GetMapping("/")
    public String index(Model model) {
        var items = itemRepository.findAll();
        model.addAttribute("titulo", "Listado de Items");
        model.addAttribute("items", items);
        return "index";
    }

    /**
     * Maneja las solicitudes GET a "/web/{id}".
     * Recupera el ítem con el ID especificado del repositorio y lo añade al modelo.
     *
     * @param id el ID del ítem a recuperar
     * @param model el modelo al que se añaden los atributos
     * @return el nombre de la vista a renderizar ("detalle")
     */
    @GetMapping("/{id}")
    public String detalle(@PathVariable String id, Model model) {
        var item = itemRepository.findById(id).orElse(null);
        model.addAttribute("titulo", "Detalles del Item");
        model.addAttribute("item", item);
        return "detalle";
    }

}
