package it.impara.blogging.post;

import it.impara.blogging.autore.Autore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private PostCategoria categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private LocalDate tempoDiLettura;

    @ManyToOne
    private Autore autore;



}
