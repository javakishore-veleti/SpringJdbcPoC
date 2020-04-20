package jk.research.spring.jdbc.poc.service;

import java.util.List;

import jk.research.spring.jdbc.poc.domain.ClaimSettlement;
import jk.research.spring.jdbc.poc.domain.ClaimSettlementMap;

public interface ClaimSettlementService {

	void populateClaimSettlements(ClaimSettlement claimStl, List<ClaimSettlementMap> newClaimStlMaps) throws Exception;

}
