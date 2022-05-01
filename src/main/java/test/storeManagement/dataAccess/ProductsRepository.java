package test.storeManagement.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.storeManagement.entities.ProductEntity;

@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, Long> {
}
