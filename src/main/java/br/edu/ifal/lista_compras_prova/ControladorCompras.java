package br.edu.ifal.lista_compras_prova;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorCompras{

    @Autowired
    ComprasRepositorio comprasRepo;

    Item item = new Item();

    @RequestMapping("/")
    public String index() {
        return "index";
    }


    @RequestMapping("/listacompras")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("listacompras.html");
        mv.addObject("itens", comprasRepo.findAll());
        mv.addObject(new Item());
        return mv;  
    }

    @RequestMapping("/cadastrar")
    public ModelAndView cadastrar(Item item) {
        
        ModelAndView mv = new ModelAndView("redirect:/listacompras");
        comprasRepo.save(item);

        return mv;
    }

    @RequestMapping("/excluir/{id}")
    public ModelAndView excluirConvidado(@PathVariable(name = "id") Long id){
        comprasRepo.deleteById(id);
        return new ModelAndView("redirect:/listacompras");
    }
   
}