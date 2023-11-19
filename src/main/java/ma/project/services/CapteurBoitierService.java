package ma.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.Entities.CapteurBoitier;
import ma.project.idao.IDao;
import ma.project.repositories.CapteurBoitierRepository;

@Service
public class CapteurBoitierService implements IDao<CapteurBoitier>{

	@Autowired
	private CapteurBoitierRepository cptBtRep;

	@Override
	public CapteurBoitier create(CapteurBoitier o) {
		// TODO Auto-generated method stub
		return cptBtRep.save(o);
	}

	@Override
	public boolean delete(CapteurBoitier o) {
		try {
			cptBtRep.delete(o);
			return true;
		} catch (Exception e) {			
			return false;
		}
		
	}

	@Override
	public CapteurBoitier update(CapteurBoitier o) {
		return cptBtRep.save(o);
	}

	@Override
	public List<CapteurBoitier> findAll() {
		// TODO Auto-generated method stub
		return cptBtRep.findAll();
	}

	@Override
	public CapteurBoitier findById(long id) {
		// TODO Auto-generated method stub
		return cptBtRep.findById(id).orElse(null);
	}

}
