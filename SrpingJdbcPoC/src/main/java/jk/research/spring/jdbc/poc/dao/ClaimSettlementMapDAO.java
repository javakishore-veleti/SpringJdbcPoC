package jk.research.spring.jdbc.poc.dao;

import java.util.List;

import jk.research.spring.jdbc.poc.domain.ClaimSettlementMap;

public interface ClaimSettlementMapDAO {

	ClaimSettlementMap getClaimSettlementMapById(Long id);

	List<ClaimSettlementMap> getAllClaimSettlementMaps();

	boolean deleteClaimSettlementMap(ClaimSettlementMap ClaimSettlementMap);

	boolean updateClaimSettlementMap(ClaimSettlementMap ClaimSettlementMap);

	Long createClaimSettlementMap(ClaimSettlementMap ClaimSettlementMap);
}
