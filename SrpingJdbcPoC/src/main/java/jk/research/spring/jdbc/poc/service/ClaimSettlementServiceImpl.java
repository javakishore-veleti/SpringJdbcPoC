package jk.research.spring.jdbc.poc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jk.research.spring.jdbc.poc.dao.ClaimSettlementDAO;
import jk.research.spring.jdbc.poc.dao.ClaimSettlementMapDAO;
import jk.research.spring.jdbc.poc.domain.ClaimSettlement;
import jk.research.spring.jdbc.poc.domain.ClaimSettlementMap;

@Service
public class ClaimSettlementServiceImpl implements ClaimSettlementService {

	@Autowired
	private ClaimSettlementDAO settlementDAO;

	@Autowired
	private ClaimSettlementMapDAO settlementMapDAO;

	@Override
	@Transactional
	public void populateClaimSettlements(ClaimSettlement claimStl, List<ClaimSettlementMap> newClaimStlMaps)
			throws Exception {

		Long primaryKey = settlementDAO.createClaimSettlement(claimStl);

		for (ClaimSettlementMap settlementMap : newClaimStlMaps) {

			settlementMap.setClaimSettlementId(primaryKey);
			settlementMapDAO.createClaimSettlementMap(settlementMap);
		}
	}

}
