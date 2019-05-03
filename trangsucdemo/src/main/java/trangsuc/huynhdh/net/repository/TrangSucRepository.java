package trangsuc.huynhdh.net.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import trangsuc.huynhdh.net.domain.TrangSucEntity;

@Repository
public interface TrangSucRepository extends CrudRepository<TrangSucEntity, Long> {

}
