package pe.edu.upc.aaw.safeparking.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.safeparking.dtos.EstacionamientoDTO;
import pe.edu.upc.aaw.safeparking.entities.Estacionamiento;
import pe.edu.upc.aaw.safeparking.serviceinterfaces.IEstacionamientoService;



import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estacionamientos")
public class EstacionamientoController {
    @Autowired
    private IEstacionamientoService eS;

    public EstacionamientoController() {
    }

    public EstacionamientoController(IEstacionamientoService eS) {
        this.eS = eS;
    }

    @PostMapping("Registrar")
    public void registrar(@RequestBody EstacionamientoDTO dto){
        ModelMapper m=new ModelMapper();
        Estacionamiento d=m.map(dto,Estacionamiento.class);
        eS.insert(d);
    }
    @GetMapping("Listar")
    public List<EstacionamientoDTO> listar(){
        return eS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,EstacionamientoDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping("Modificar")
    public void modificar(@RequestBody EstacionamientoDTO dto){
        ModelMapper m=new ModelMapper();
        Estacionamiento d=m.map(dto, Estacionamiento.class);
        eS.insert(d);
    }

    @DeleteMapping("Eliminar/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        eS.delete(id);
    }

}




