package ArturRSO.Sistema_de_Restaurantes.Pratos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PratosRepository extends JpaRepository<PratosModel, Long>{
    
}