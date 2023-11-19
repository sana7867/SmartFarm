package ma.projet.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.entities.PlanteParcelle;
import ma.projet.idao.IDao;
import ma.projet.repositories.PlanteParcelleRepository;

@Service
public class PlanteParcelleService implements IDao<PlanteParcelle>{

	@Autowired
	private PlanteParcelleRepository pltPrcRep;

	@Override
	public PlanteParcelle create(PlanteParcelle o) {
		// TODO Auto-generated method stub
		return pltPrcRep.save(o);
	}

	@Override
	public boolean delete(PlanteParcelle o) {
		try {
			pltPrcRep.delete(o);
			return true;
		} catch (Exception e) {			
			return false;
		}
		
	}

	@Override
	public PlanteParcelle update(PlanteParcelle o) {
		return pltPrcRep.save(o);
	}

	@Override
	public List<PlanteParcelle> findAll() {
		// TODO Auto-generated method stub
		return pltPrcRep.findAll();
	}

	@Override
	public PlanteParcelle findById(long id) {
		// TODO Auto-generated method stub
		return pltPrcRep.findById(id).orElse(null);
	}

}
