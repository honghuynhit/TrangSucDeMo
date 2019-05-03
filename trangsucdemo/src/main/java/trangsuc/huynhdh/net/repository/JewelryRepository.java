package trangsuc.huynhdh.net.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import trangsuc.huynhdh.net.domain.Jewelry;

public interface JewelryRepository extends CrudRepository<Jewelry, Integer> {

    List<Jewelry> findByNameContaining(String q);

}
