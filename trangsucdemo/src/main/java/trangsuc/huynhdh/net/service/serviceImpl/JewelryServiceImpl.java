package trangsuc.huynhdh.net.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trangsuc.huynhdh.net.domain.Jewelry;
import trangsuc.huynhdh.net.repository.JewelryRepository;
import trangsuc.huynhdh.net.service.JewelryService;

@Service
public class JewelryServiceImpl implements JewelryService {
	@Autowired
	private JewelryRepository jewelryRepository;

	@Override
	public Iterable<Jewelry> findAll() {
		return jewelryRepository.findAll();
	}

}
