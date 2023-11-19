package ma.projet.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.entities.Capteur;
import ma.projet.idao.IDao;
import ma.projet.repositories.CapteurRepository;

@Service
public class CapteurService implements IDao<Capteur>{

	@Autowired
	private CapteurRepository captRep;

	@Override
	public Capteur create(Capteur o) {
		// TODO Auto-generated method stub
		return captRep.save(o);
	}

	@Override
	public boolean delete(Capteur o) {
		try {
			captRep.delete(o);
			return true;
		} catch (Exception e) {			
			return false;
		}
		
	}

	@Override
	public Capteur update(Capteur o) {
		return captRep.save(o);
	}

	@Override
	public List<Capteur> findAll() {
		// TODO Auto-generated method stub
		return captRep.findAll();
	}

	@Override
	public Capteur findById(long id) {
		// TODO Auto-generated method stub
		return captRep.findById(id).orElse(null);
	}

}
