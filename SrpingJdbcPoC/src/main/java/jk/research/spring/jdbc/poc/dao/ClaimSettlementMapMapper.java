package jk.research.spring.jdbc.poc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jk.research.spring.jdbc.poc.domain.ClaimSettlementMap;

public class ClaimSettlementMapMapper implements RowMapper<ClaimSettlementMap> {

	public ClaimSettlementMap mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClaimSettlementMap claimSettlementMap = new ClaimSettlementMap();

		claimSettlementMap.setId(rs.getLong("id"));
		claimSettlementMap.setClaimICDCounterPartyId(rs.getLong(ClaimSettlementMap.COLUMN_NAME_ICD_COUNTER_PARTY_ID));
		claimSettlementMap.setClaimSettlementId(rs.getLong(ClaimSettlementMap.COLUMN_NAME_CLAIM_SET_ID));

		return claimSettlementMap;
	}

}
