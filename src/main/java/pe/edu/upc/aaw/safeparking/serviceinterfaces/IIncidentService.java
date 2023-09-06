package pe.edu.upc.aaw.safeparking.serviceinterfaces;

import pe.edu.upc.aaw.safeparking.entities.Incidente;
import pe.edu.upc.aaw.safeparking.entities.Membresia;

import java.util.List;

public interface IIncidentService {
    public void insert(Incidente incidente);
    public List<Incidente> list();
    public void delete(int idIncidente);
    public Incidente listId(int idIncidente);
}
