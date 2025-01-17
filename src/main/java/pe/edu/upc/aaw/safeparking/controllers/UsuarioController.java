package pe.edu.upc.aaw.safeparking.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.safeparking.dtos.UsuarioDTO;
import pe.edu.upc.aaw.safeparking.entities.Usuario;
import pe.edu.upc.aaw.safeparking.serviceinterfaces.IUsuarioService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService uS;
    @PostMapping("Registrar")
    @PreAuthorize("hasAuthority('administrador')  or hasAuthority('arrendador') or hasAuthority('conductor')")
    public void registrar(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario u=m.map(dto, Usuario.class);
        uS.insert(u);
    }
    @GetMapping("Listar")
    @PreAuthorize("hasAuthority('administrador')")
    public List<UsuarioDTO> listar(){
        return uS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("Eliminar/{id}")
    @PreAuthorize("hasAuthority('administrador')")
    public void eliminar(@PathVariable("id")Integer id){
        uS.delete(id);
    }

    @PutMapping("Modificar")
    @PreAuthorize("hasAuthority('administrador')")
    public void modificar(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario u=m.map(dto, Usuario.class);
        uS.insert(u);
    }
    @GetMapping("ListarporID/{id}")
    @PreAuthorize("hasAuthority('administrador')")
    public UsuarioDTO listarId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        UsuarioDTO u= m.map(uS.listId(id), UsuarioDTO.class);
        return u;
    }

}
