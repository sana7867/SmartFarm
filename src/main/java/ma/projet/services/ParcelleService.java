package ma.projet.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.entities.Parcelle;
import ma.projet.idao.IDao;
import ma.projet.repositories.ParcelleRepository;

@Service
public class ParcelleService implements IDao<Parcelle>{

	@Autowired
	private ParcelleRepository prsllRep;

	@Override
	public Parcelle create(Parcelle o) {
		// TODO Auto-generated method stub
		return prsllRep.save(o);
	}

	@Override
	public boolean delete(Parcelle o) {
		try {
			prsllRep.delete(o);
			return true;
		} catch (Exception e) {			
			return false;
		}
		
	}

	@Override
	public Parcelle update(Parcelle o) {
		return prsllRep.save(o);
	}

	@Override
	public List<Parcelle> findAll() {
		// TODO Auto-generated method stub
		return prsllRep.findAll();
	}

	@Override
	public Parcelle findById(long id) {
		// TODO Auto-generated method stub
		return prsllRep.findById(id).orElse(null);
	}

}
