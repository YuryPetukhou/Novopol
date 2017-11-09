package lv.javaguru.novopol.logic.service.surfacetype.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.SurfaceTypeDAO;
import lv.javaguru.novopol.logic.api.surfacetype.UpdateSurfaceTypeRequest;
import lv.javaguru.novopol.logic.api.surfacetype.UpdateSurfaceTypeResponse;
import lv.javaguru.novopol.logic.service.surfacetype.UpdateSurfaceTypeService;

@Component
public class UpdateSurfaceTypeServiceImpl implements UpdateSurfaceTypeService {

	@Autowired
	private SurfaceTypeDAO dao;
	
	
	@Override
	public UpdateSurfaceTypeResponse updateSurfaceType(UpdateSurfaceTypeRequest request) {
		return new UpdateSurfaceTypeResponse(dao.updateSurfaceType(request.getSurfaceType(), request.getId()));
	}

}
