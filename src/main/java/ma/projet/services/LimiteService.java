package ma.projet.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.entities.Limite;
import ma.projet.idao.IDao;
import ma.projet.repositories.LimiteRepository;

@Service
public class LimiteService implements IDao<Limite>{

	@Autowired
	private LimiteRepository lmtRep;

	@Override
	public Limite create(Limite o) {
		// TODO Auto-generated method stub
		return lmtRep.save(o);
	}

	@Override
	public boolean delete(Limite o) {
		try {
			lmtRep.delete(o);
			return true;
		} catch (Exception e) {			
			return false;
		}
		
	}

	@Override
	public Limite update(Limite o) {
		return lmtRep.save(o);
	}

	@Override
	public List<Limite> findAll() {
		// TODO Auto-generated method stub
		return lmtRep.findAll();
	}

	@Override
	public Limite findById(long id) {
		// TODO Auto-generated method stub
		return lmtRep.findById(id).orElse(null);
	}

}
