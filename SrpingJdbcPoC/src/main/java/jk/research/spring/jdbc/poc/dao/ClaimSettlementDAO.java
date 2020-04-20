package jk.research.spring.jdbc.poc.dao;

import java.util.List;

import jk.research.spring.jdbc.poc.domain.ClaimSettlement;

public interface ClaimSettlementDAO {

	ClaimSettlement getClaimSettlementById(Long id);

	List<ClaimSettlement> getAllClaimSettlements();

	boolean deleteClaimSettlement(ClaimSettlement ClaimSettlement);

	boolean updateClaimSettlement(ClaimSettlement ClaimSettlement);

	Long createClaimSettlement(ClaimSettlement ClaimSettlement);
}
