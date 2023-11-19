package ma.projet.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.entities.BoitierParcelle;
import ma.projet.idao.IDao;
import ma.projet.repositories.BoitierParcelleRepository;


@Service
public class BoitierParcelleService implements IDao<BoitierParcelle>{

	@Autowired
	private BoitierParcelleRepository btPrRep;

	@Override
	public BoitierParcelle create(BoitierParcelle o) {
		// TODO Auto-generated method stub
		return btPrRep.save(o);
	}

	@Override
	public boolean delete(BoitierParcelle o) {
		try {
			btPrRep.delete(o);
			return true;
		} catch (Exception e) {			
			return false;
		}
		
	}

	@Override
	public BoitierParcelle update(BoitierParcelle o) {
		return btPrRep.save(o);
	}

	@Override
	public List<BoitierParcelle> findAll() {
		// TODO Auto-generated method stub
		return btPrRep.findAll();
	}

	@Override
	public BoitierParcelle findById(long id) {
		// TODO Auto-generated method stub
		return btPrRep.findById(id).orElse(null);
	}

}