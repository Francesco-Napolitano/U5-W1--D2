package it.esMattino.manutenzioni.tecnico;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    public Tecnico findByMatricola(String matricola);
}
