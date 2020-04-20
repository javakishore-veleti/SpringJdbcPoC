package jk.research.spring.jdbc.poc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import jk.research.spring.jdbc.poc.domain.ClaimSettlement;

// https://www.journaldev.com/17053/spring-jdbctemplate-example
@Component
public class ClaimSettlementDAOImpl implements ClaimSettlementDAO {

	private final String SQL_FIND_CLAIM_SETTLEMENT = "SELECT * FROM " + ClaimSettlement.TABLE_NAME + " WHERE id = ?";

	private final String SQL_DELETE_CLAIM_SETTLEMENT = "DELETE FROM " + ClaimSettlement.TABLE_NAME + " WHERE id = ?";

	private final String SQL_UPDATE_CLAIM_SETTLEMENT = "UPDATE " + ClaimSettlement.TABLE_NAME + " SET "
			+ ClaimSettlement.COLUMN_NAME_PROVIDER_LEGAL_ENT_ID + " = ? , "
			+ ClaimSettlement.COLUMN_NAME_HOSPITAL_CCP_ID + " = ? , "
			+ ClaimSettlement.COLUMN_NAME_CLAIM_ICD_CTR_PATRIES + " = ? , "
			+ ClaimSettlement.COLUMN_NAME_CLAIM_SETTLEMENT_TYPE + " = ?  WHERE id = ?";

	private final String SQL_GET_ALL = "SELECT * from " + ClaimSettlement.TABLE_NAME;

	private final String SQL_INSERT_CLAIM_SETTLEMENT = "INSERT INTO " + ClaimSettlement.TABLE_NAME + " ( "
			+ ClaimSettlement.COLUMN_NAME_PROVIDER_LEGAL_ENT_ID + ", " + ClaimSettlement.COLUMN_NAME_HOSPITAL_CCP_ID
			+ ", " + ClaimSettlement.COLUMN_NAME_CLAIM_ICD_CTR_PATRIES + ", "
			+ ClaimSettlement.COLUMN_NAME_CLAIM_SETTLEMENT_TYPE + " ) " + " VALUES (?,?,?,?)";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ClaimSettlementDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public ClaimSettlement getClaimSettlementById(Long id) {
		return jdbcTemplate.queryForObject(SQL_FIND_CLAIM_SETTLEMENT, new Object[] { id }, new ClaimSettlementMapper());
	}

	public List<ClaimSettlement> getAllClaimSettlements() {
		return jdbcTemplate.query(SQL_GET_ALL, new ClaimSettlementMapper());
	}

	public boolean deleteClaimSettlement(ClaimSettlement claimSettlement) {
		return jdbcTemplate.update(SQL_DELETE_CLAIM_SETTLEMENT, claimSettlement.getId()) > 0;
	}

	public boolean updateClaimSettlement(ClaimSettlement claimSettlement) {
		return jdbcTemplate.update(SQL_UPDATE_CLAIM_SETTLEMENT, claimSettlement.getProviderLegalEntityId(),
				claimSettlement.getHospitalCCPId(), claimSettlement.getClaimICDCounterParties(),
				claimSettlement.getClaimSettlementType()) > 0;
	}

	public Long createClaimSettlement(ClaimSettlement claimSettlement) {

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(SQL_INSERT_CLAIM_SETTLEMENT, claimSettlement.getProviderLegalEntityId(),
				claimSettlement.getHospitalCCPId(), claimSettlement.getClaimICDCounterParties(),
				claimSettlement.getClaimSettlementType());

		return (Long) keyHolder.getKey();
	}

}
