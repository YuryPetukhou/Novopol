package lv.javaguru.novopol.logic.service.surfacetype.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.SurfaceTypeDAO;
import lv.javaguru.novopol.logic.api.surfacetype.ListSurfaceTypesRequest;
import lv.javaguru.novopol.logic.api.surfacetype.ListSurfaceTypesResponse;
import lv.javaguru.novopol.logic.service.surfacetype.ListSurfaceTypeService;

@Component
public class ListSurfaceTypesServiceImpl implements ListSurfaceTypeService {

	@Autowired
	private SurfaceTypeDAO dao;
	
	@Override
	public ListSurfaceTypesResponse getSurfaceTypes(ListSurfaceTypesRequest request) {
		return new ListSurfaceTypesResponse(dao.getAllSurfaceTypes());
	}

}
