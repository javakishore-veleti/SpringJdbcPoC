package jk.research.spring.jdbc.poc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jk.research.spring.jdbc.poc.domain.ClaimSettlement;

public class ClaimSettlementMapper implements RowMapper<ClaimSettlement> {

	public ClaimSettlement mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClaimSettlement claimSettlement = new ClaimSettlement();

		claimSettlement.setId(rs.getLong("id"));
		claimSettlement.setProviderLegalEntityId(rs.getLong(ClaimSettlement.COLUMN_NAME_PROVIDER_LEGAL_ENT_ID));
		claimSettlement.setHospitalCCPId(rs.getLong(ClaimSettlement.COLUMN_NAME_HOSPITAL_CCP_ID));
		claimSettlement.setClaimICDCounterParties(rs.getString(ClaimSettlement.COLUMN_NAME_CLAIM_ICD_CTR_PATRIES));
		claimSettlement.setClaimSettlementType(rs.getString(ClaimSettlement.COLUMN_NAME_CLAIM_SETTLEMENT_TYPE));

		return claimSettlement;
	}

}
