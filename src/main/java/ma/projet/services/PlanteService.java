package ma.projet.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.entities.Plante;
import ma.projet.idao.IDao;
import ma.projet.repositories.PlanteRepository;

@Service
public class PlanteService implements IDao<Plante>{

	@Autowired
	private PlanteRepository plntRep;

	@Override
	public Plante create(Plante o) {
		// TODO Auto-generated method stub
		return plntRep.save(o);
	}

	@Override
	public boolean delete(Plante o) {
		try {
			plntRep.delete(o);
			return true;
		} catch (Exception e) {			
			return false;
		}
		
	}

	@Override
	public Plante update(Plante o) {
		return plntRep.save(o);
	}

	@Override
	public List<Plante> findAll() {
		// TODO Auto-generated method stub
		return plntRep.findAll();
	}

	@Override
	public Plante findById(long id) {
		// TODO Auto-generated method stub
		return plntRep.findById(id).orElse(null);
	}

}
