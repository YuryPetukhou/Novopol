package lv.javaguru.novopol.logic.service.surfacetype.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.SurfaceTypeDAO;
import lv.javaguru.novopol.logic.api.surfacetype.AddSurfaceTypeRequest;
import lv.javaguru.novopol.logic.api.surfacetype.AddSurfaceTypeResponse;
import lv.javaguru.novopol.logic.service.surfacetype.AddSurfaceTypeService;

@Component
public class AddSurfaceTypeServiceImpl implements AddSurfaceTypeService {
	@Autowired
	private SurfaceTypeDAO dao;
	
	@Override
	public AddSurfaceTypeResponse addSurfaceType(AddSurfaceTypeRequest request) {
		return new AddSurfaceTypeResponse(dao.insertSurfaceType(request.getSurfaceType()));
	}

}
