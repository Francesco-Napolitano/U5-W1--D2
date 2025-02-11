package it.esMattino.manutenzioni.interventi;

import it.esMattino.manutenzioni.aziende.Azienda;
import it.esMattino.manutenzioni.tecnico.Tecnico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Intervento")
public class Intervento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long id;

    private String descrizione;
    private String data;
    private String stato;
    private String tecnico;
    private String azienda;
    @ManyToOne
    private Azienda aziendaId;
    @ManyToOne
    private Tecnico tecnicoId;
}
