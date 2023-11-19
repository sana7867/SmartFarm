package ma.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.project.Entities.Admin;
import ma.project.idao.IDao;
import ma.project.repositories.AdminRepository;

@Service
public class AdminService implements IDao<Admin>{

	@Autowired
	private AdminRepository adRep;

	@Override
	public Admin create(Admin o) {
		// TODO Auto-generated method stub
		return adRep.save(o);
	}

	@Override
	public boolean delete(Admin o) {
		try {
			adRep.delete(o);
			return true;
		} catch (Exception e) {			
			return false;
		}
		
	}

	@Override
	public Admin update(Admin o) {
		return adRep.save(o);
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return adRep.findAll();
	}

	@Override
	public Admin findById(long id) {
		// TODO Auto-generated method stub
		return adRep.findById(id).orElse(null);
	}

}
