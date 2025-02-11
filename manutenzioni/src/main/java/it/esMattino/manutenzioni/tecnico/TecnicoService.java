package it.esMattino.manutenzioni.tecnico;

import com.fasterxml.jackson.databind.util.BeanUtil;
import it.esMattino.manutenzioni.general.responses.CreateResponse;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TecnicoService {
    private final TecnicoRepository tecnicoRepository;

    // metodo per trovare tutti i dipendenti
    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }
    // metodo per inserire un tecnico nuovo al database

    public CreateResponse save(TecnicoRequest request) {
        if(tecnicoRepository.existsByMatricola(request.getMatricola())) {
            new EntityExistsException("Tecnico già esistente");
        }
        Tecnico tecnico = new Tecnico();
        BeanUtils.copyProperties(request, tecnico);
        tecnicoRepository.save(tecnico);

        CreateResponse response = new CreateResponse("Tecnico aggiunto con successo");
        BeanUtils.copyProperties(tecnico, response);
        return new CreateResponse("Tecnico aggiunto con successo");
    }


    // metodo per trovare uno specifico tecnico (per id)

    public Tecnico findById(Long id){
        if(!tecnicoRepository.existsById(id)){
            System.out.println("Tecnico non trovato");
            return null;
        }
        return tecnicoRepository.findById(id).get();
    }

}
