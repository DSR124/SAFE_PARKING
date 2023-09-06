package pe.edu.upc.aaw.safeparking.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.safeparking.entities.Incidente;
import pe.edu.upc.aaw.safeparking.entities.Membresia;
import pe.edu.upc.aaw.safeparking.repositories.IIncidenteRepository;
import pe.edu.upc.aaw.safeparking.serviceinterfaces.IIncidentService;

import java.util.List;
@Service
public class IncidenteServiceImplement implements IIncidentService {
    @Autowired
    private IIncidenteRepository iR;
    @Override
    public void insert(Incidente incidente) {
        iR.save(incidente);
    }

    @Override
    public List<Incidente> list() {
        return iR.findAll();
    }

    @Override
    public void delete(int idIncidente) {
        iR.deleteById(idIncidente);
    }

    @Override
    public Incidente listId(int idIncidente) {
        return iR.findById(idIncidente).orElse(new Incidente());
    }
}
