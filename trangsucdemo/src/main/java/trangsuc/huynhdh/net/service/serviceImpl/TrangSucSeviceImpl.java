package trangsuc.huynhdh.net.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trangsuc.huynhdh.net.domain.TrangSucEntity;
import trangsuc.huynhdh.net.repository.TrangSucRepository;
import trangsuc.huynhdh.net.service.TrangSucService;

@Service
public class TrangSucSeviceImpl implements TrangSucService {

	@Autowired private TrangSucRepository trangSucRepository;

	  @Override
	  public List<TrangSucEntity> getAllTrangSuc() {
		  List<TrangSucEntity> trangSucs= (List<TrangSucEntity>) trangSucRepository.findAll();
		  System.out.println(trangSucs);
	    return (List<TrangSucEntity>) trangSucRepository.findAll();
	  }

	  @Override
	  public void saveTrangSuc(TrangSucEntity trangSucEntity) {
	    trangSucRepository.save(trangSucEntity);
	  }

	  @Override
	  public void deleteTrangSuc(Long id) {
	    trangSucRepository.deleteById(id);
	  }

	  @Override
	  public Optional<TrangSucEntity> findTrangSucById(Long id) {
	    return trangSucRepository.findById(id);
	  }

}
