package ParcelProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ParcelProject.dao.ParcelDAO;
import ParcelProject.exception.ParcelKeepException;
import ParcelProject.service.ParcelKeepService;
import ParcelProject.vo.KeepRequest;

@Service("parcelKeepService")
@Transactional
public class ParcelKeepServiceImpl implements ParcelKeepService {
	@Autowired
	private ParcelDAO parcelDAO;

	@Override
	public int insertParcel(KeepRequest keepRequest) throws Exception {

		int result = parcelDAO.insertParcel(keepRequest);
		if (result == 1) {
			return result;
		} else {
			throw new ParcelKeepException("fail keep");
		}
	}
	
	

}
