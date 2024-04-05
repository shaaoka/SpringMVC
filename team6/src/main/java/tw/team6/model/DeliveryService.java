package tw.team6.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeliveryService {

	@Autowired
	private DeliveryDao dDao;
	
	public Delivery findById(Integer id) {
		return dDao.findById(id);
	}
	
	public List<Delivery> findAll() {
		return dDao.FindAll();
	}
	public Delivery insert(Delivery delivery) {
		return dDao.insert(delivery);
	}
	
	public boolean Del(Integer id) {
		return dDao.deleteById(id);
	}
	
	public Delivery update(Delivery delivery) {
		return dDao.update(delivery);
	}
	
	
}
