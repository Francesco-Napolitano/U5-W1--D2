package it.esMattino.manutenzioni.aziende;

import it.esMattino.manutenzioni.interventi.Intervento;
import it.esMattino.manutenzioni.tecnico.Tecnico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Azienda")
public class Azienda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private String indirizzo;
    private String telefono;
    @OneToMany
    private Set<Tecnico> tecnici = new HashSet<>();
    @OneToMany (mappedBy = "aziendaId")
    private Set<Intervento> interventi = new HashSet<>();


}
