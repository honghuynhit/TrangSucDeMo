package trangsuc.huynhdh.net.service;

import java.util.List;
import java.util.Optional;

import trangsuc.huynhdh.net.domain.TrangSucEntity;

public interface TrangSucService {
	  List<TrangSucEntity> getAllTrangSuc();

	  void saveTrangSuc(TrangSucEntity trangSuc);

	  void deleteTrangSuc(Long id);

	  Optional<TrangSucEntity> findTrangSucById(Long id);
}
