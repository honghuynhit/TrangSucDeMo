package trangsuc.huynhdh.net.service;

import trangsuc.huynhdh.net.domain.Jewelry;

public interface JewelryService {
	/**
	 * Find all jewelry
	 * @return
	 */
	Iterable<Jewelry> findAll();
	
}
