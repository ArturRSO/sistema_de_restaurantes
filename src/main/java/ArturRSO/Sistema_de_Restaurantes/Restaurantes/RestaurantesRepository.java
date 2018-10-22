package ArturRSO.Sistema_de_Restaurantes.Restaurantes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantesRepository extends JpaRepository<RestaurantesModel, Long> {
    
}