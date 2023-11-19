package ma.projet.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.entities.Mesure;
import ma.projet.idao.IDao;
import ma.projet.repositories.MesureRepository;

@Service
public class MesureService implements IDao<Mesure>{

	@Autowired
	private MesureRepository msrRep;

	@Override
	public Mesure create(Mesure o) {
		// TODO Auto-generated method stub
		return msrRep.save(o);
	}

	@Override
	public boolean delete(Mesure o) {
		try {
			msrRep.delete(o);
			return true;
		} catch (Exception e) {			
			return false;
		}
		
	}

	@Override
	public Mesure update(Mesure o) {
		return msrRep.save(o);
	}

	@Override
	public List<Mesure> findAll() {
		// TODO Auto-generated method stub
		return msrRep.findAll();
	}

	@Override
	public Mesure findById(long id) {
		// TODO Auto-generated method stub
		return msrRep.findById(id).orElse(null);
	}

}
