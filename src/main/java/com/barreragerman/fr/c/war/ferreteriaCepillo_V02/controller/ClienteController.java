package com.barreragerman.fr.c.war.ferreteriaCepillo_V02.controller;

import com.barreragerman.fr.c.war.ferreteriaCepillo_V02.entity.Cliente;
import com.barreragerman.fr.c.war.ferreteriaCepillo_V02.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/mostrar")
    public String mostrarClientes(Model model) {
        model.addAttribute("cliente", clienteService.findAll());
        return "ver_clientes";
    }
//    @GetMapping
//    public @ResponseBody
//    List<Cliente> findAll() {
//        System.out.println("findAllClientes");
//        return clienteService.findAll();
//    }

//    @GetMapping("/clienteUnico")
//    public String getUnicoCliente(){
//        return "clienteUnico";
//    }
//    @ModelAttribute("cliente")
//    public Cliente cliente(){
//        return new Cliente(1,"German","Brrera","Colonia Tirolesa","29999008","45678912");
//    }

    //en este metodo get nos trae la pagina html donde se hara el post para el agregado del cliente
    @GetMapping("/agregar")
    public String agregarCliente(Model model){
        model.addAttribute("cliente",new Cliente());
        return "agregar_clientes";
    }

    @PostMapping(value = "/agregar")
    public String guardarCliente(@ModelAttribute Cliente cliente,
                                  RedirectAttributes redirectAttrs) {
        clienteService.save(cliente);
        redirectAttrs
                .addFlashAttribute("mensaje", " Cliente agregado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/clientes/mostrar";
    }

    @GetMapping(value = "/editar/{id}")
    public String mostrarFormularioEditarCliente(@PathVariable int id, Model model) {
        model.addAttribute("cliente", clienteService.findById(id));
        return "editar_cliente";
    }

    // Se colocó el parámetro ID para eso de los errores, ya sé el id se puede recuperar
    // a través del modelo, pero lo que yo quiero es que se vea la misma URL para regresar la vista con
    // los errores en lugar de hacer un redirect, ya que si hago un redirect, no se muestran los errores del formulario
    // y por eso regreso mejor la vista ;)
    @PostMapping(value = "/editar/{id}")
    public String actualizarCliente(@ModelAttribute @Valid Cliente cliente, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        if (bindingResult.hasErrors()) {
            if (cliente.getId() != null) {
                return "editar_cliente";
            }
            return "redirect:/clientes/mostrar";
        }
        Cliente posibleClienteExistente = clienteService.findById(cliente.getId());

        if (posibleClienteExistente != null && !posibleClienteExistente.getId().equals(cliente.getId())) {
            redirectAttrs
                    .addFlashAttribute("mensaje", "Ya existe un cliente con ese ID")
                    .addFlashAttribute("clase", "warning");
            return "redirect:/clientes/agregar";
        }
        clienteService.save(cliente);
        redirectAttrs
                .addFlashAttribute("mensaje", "Cliente editado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/clientes/mostrar";
    }

    @PostMapping(value = "/eliminar")
    public String eliminarCliente(@ModelAttribute Cliente cliente, RedirectAttributes redirectAttrs) {
        redirectAttrs
                .addFlashAttribute("mensaje", "Cliente eliminado correctamente")
                .addFlashAttribute("clase", "warning");
        clienteService.deleteById(cliente.getId());
        return "redirect:/clientes/mostrar";
    }
//    //localhost:8080/cliente/2
//    @GetMapping("/{id}")
//    // @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
//    public @ResponseBody
//    Cliente findById(@PathVariable("id") Integer id) {
//        return clienteService.findById(id);
//    }

//    @PostMapping(value = "/agregar")
//    public @ResponseBody
//    Cliente save(@RequestBody Cliente cliente) {
//        return clienteService.save(cliente);
//    }
//
//    @PutMapping("/{id}")
//    // @PreAuthorize("hasAuthority('paciente:write')")
//    public @ResponseBody Cliente update(@PathVariable("id") Integer id,
//                                         @RequestBody Cliente paciente) {
//        return clienteService.update(paciente, id);
//    }
//
//    @DeleteMapping("/{id}")
//    // @PreAuthorize("hasAuthority('paciente:write')")
//    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) throws Exception{
//        clienteService.deleteById(id);
//        return new ResponseEntity<Object>(HttpStatus.OK);
//    }


}
