package it.esMattino.manutenzioni.tecnico;

import it.esMattino.manutenzioni.aziende.Azienda;
import it.esMattino.manutenzioni.interventi.Intervento;
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
@Table(name = "Tecnico")
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private String cognome;
    private String telefono;
    private String email;
    private Boolean attivo = true;
    @OneToMany
    private Set<Intervento> interventi = new HashSet<>();
    @ManyToOne
    private Azienda azienda;


}
