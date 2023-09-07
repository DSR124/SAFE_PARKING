package pe.edu.upc.aaw.safeparking.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.safeparking.dtos.MembresiaDTO;
import pe.edu.upc.aaw.safeparking.entities.Membresia;
import pe.edu.upc.aaw.safeparking.serviceinterfaces.IMembresiaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/membresia")
public class MembresiaController {
    @Autowired
    private IMembresiaService dS;
    @PostMapping
    public void registrar(@RequestBody MembresiaDTO dto){
        ModelMapper m=new ModelMapper();
        Membresia d=m.map(dto,Membresia.class);
        dS.insert(d);
    }
    @GetMapping
    public List<MembresiaDTO> listar(){
        return dS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,MembresiaDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        dS.delete(id);
    }
    @GetMapping("/{id}")
    public MembresiaDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        MembresiaDTO mem=m.map(dS.listId(id),MembresiaDTO.class);
        return mem;
    }

    @PutMapping
    public void modificar(@RequestBody MembresiaDTO dto){
        ModelMapper m=new ModelMapper();
        Membresia mem=m.map(dto,Membresia.class);
        dS.insert(mem);
    }

}
