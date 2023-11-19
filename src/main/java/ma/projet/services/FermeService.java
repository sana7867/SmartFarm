package ma.projet.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.entities.Ferme;
import ma.projet.idao.IDao;
import ma.projet.repositories.FermeRepository;

@Service
public class FermeService implements IDao<Ferme>{

	@Autowired
	private FermeRepository frmRep;

	@Override
	public Ferme create(Ferme o) {
		// TODO Auto-generated method stub
		return frmRep.save(o);
	}

	@Override
	public boolean delete(Ferme o) {
		try {
			frmRep.delete(o);
			return true;
		} catch (Exception e) {			
			return false;
		}
		
	}

	@Override
	public Ferme update(Ferme o) {
		return frmRep.save(o);
	}

	@Override
	public List<Ferme> findAll() {
		// TODO Auto-generated method stub
		return frmRep.findAll();
	}

	@Override
	public Ferme findById(long id) {
		// TODO Auto-generated method stub
		return frmRep.findById(id).orElse(null);
	}

}
