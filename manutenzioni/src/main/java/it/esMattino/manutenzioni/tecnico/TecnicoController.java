
package it.esMattino.manutenzioni.tecnico;


import it.esMattino.manutenzioni.general.responses.CreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TecnicoController {
    private final TecnicoService tecnicoService;
    ;

    @GetMapping
    // GET http://localhost:8080/api/tecnico
    @ResponseStatus(HttpStatus.OK)
    public List<Tecnico> findAll() {
        return tecnicoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    // GET http://localhost:8080/api/tecnico/1
    public Tecnico findById(@PathVariable Long id) {
        return tecnicoService.findById(id);
    }

    @PostMapping
    // POST http://localhost:8080/api/tecnico
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponse save(@RequestBody TecnicoRequest request) {
        return tecnicoService.save(request);
    }


}
