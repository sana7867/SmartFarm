package ma.projet.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.entities.Boitier;
import ma.projet.idao.IDao;
import ma.projet.repositories.BoitierRepository;

@Service
public class BoitierService implements IDao<Boitier>{

	@Autowired
	private BoitierRepository boitRep;

	@Override
	public Boitier create(Boitier o) {
		// TODO Auto-generated method stub
		return boitRep.save(o);
	}

	@Override
	public boolean delete(Boitier o) {
		try {
			boitRep.delete(o);
			return true;
		} catch (Exception e) {			
			return false;
		}
		
	}

	@Override
	public Boitier update(Boitier o) {
		return boitRep.save(o);
	}

	@Override
	public List<Boitier> findAll() {
		// TODO Auto-generated method stub
		return boitRep.findAll();
	}

	@Override
	public Boitier findById(long id) {
		// TODO Auto-generated method stub
		return boitRep.findById(id).orElse(null);
	}

}
