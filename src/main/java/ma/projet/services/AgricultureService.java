package ma.projet.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.entities.Agriculture;
import ma.projet.idao.IDao;
import ma.projet.repositories.AgricultureRepository;

@Service
public class AgricultureService implements IDao<Agriculture>{

	@Autowired
	private AgricultureRepository agRep;

	@Override
	public Agriculture create(Agriculture o) {
		// TODO Auto-generated method stub
		return agRep.save(o);
	}

	@Override
	public boolean delete(Agriculture o) {
		try {
			agRep.delete(o);
			return true;
		} catch (Exception e) {			
			return false;
		}
		
	}

	@Override
	public Agriculture update(Agriculture o) {
		return agRep.save(o);
	}

	@Override
	public List<Agriculture> findAll() {
		// TODO Auto-generated method stub
		return agRep.findAll();
	}

	@Override
	public Agriculture findById(long id) {
		// TODO Auto-generated method stub
		return agRep.findById(id).orElse(null);
	}

}