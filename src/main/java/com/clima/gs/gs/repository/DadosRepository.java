package com.clima.gs.gs.repository;

import com.clima.gs.gs.model.Dados;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DadosRepository extends JpaRepository<Dados, Long> {
    Page<Dados> findByCidadeContainingIgnoreCase(String cidade, Pageable pageable);

    @Query("SELECT d.cidade FROM Dados d WHERE d.cidade IS NOT NULL GROUP BY d.cidade ORDER BY MAX(d.dataColeta) DESC")
    List<String> listarCidadesDistintasMaisRecentes();

    Optional<Dados> findFirstByCidadeIgnoreCaseOrderByDataColetaDesc(String cidade);
}
