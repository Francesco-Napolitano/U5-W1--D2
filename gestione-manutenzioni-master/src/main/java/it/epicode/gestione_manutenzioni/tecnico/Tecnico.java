package it.epicode.gestione_manutenzioni.tecnico;

import it.epicode.gestione_manutenzioni.aziende.Azienda;
import it.epicode.gestione_manutenzioni.interventi.Intervento;
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
@Table(name = "tecnici")

public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    // nome cognome matricola
    private String nome;
    private String cognome;
    @Column(unique = true)
    private String matricola;
    @Column(unique = true)
    private String codiceFiscale;
    private Boolean attivo=true;

    @ManyToOne
    Azienda azienda;

    @OneToMany(mappedBy = "tecnico")
    private Set<Intervento> interventi = new HashSet<>();

}
