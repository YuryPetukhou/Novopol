package lv.javaguru.novopol.logic.service.surfacetype.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.SurfaceTypeDAO;
import lv.javaguru.novopol.logic.api.surfacetype.RemoveSurfaceTypeRequest;
import lv.javaguru.novopol.logic.api.surfacetype.RemoveSurfaceTypeResponse;
import lv.javaguru.novopol.logic.service.surfacetype.RemoveSurfaceTypeService;

@Component
public class RemoveSurfaceTypeServiceImpl implements RemoveSurfaceTypeService {

	@Autowired
	private SurfaceTypeDAO dao;
	
	@Override
	public RemoveSurfaceTypeResponse removeSurfaceType(RemoveSurfaceTypeRequest request) {
		return new RemoveSurfaceTypeResponse(dao.removeSurfaceType(request.getSurfaceType()));
	}

}
