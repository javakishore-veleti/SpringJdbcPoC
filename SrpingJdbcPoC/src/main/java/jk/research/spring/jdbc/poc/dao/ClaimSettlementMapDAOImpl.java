package jk.research.spring.jdbc.poc.dao;

import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import jk.research.spring.jdbc.poc.domain.ClaimSettlementMap;

@Component
public class ClaimSettlementMapDAOImpl implements ClaimSettlementMapDAO {

	private final String SQL_FIND_CLAIM_SETTLEMENT_MAP = "SELECT * FROM " + ClaimSettlementMap.TABLE_NAME
			+ " WHERE id = ?";

	private final String SQL_DELETE_CLAIM_SETTLEMENT_MAP = "DELETE FROM " + ClaimSettlementMap.TABLE_NAME
			+ " WHERE id = ?";

	private final String SQL_UPDATE_CLAIM_SETTLEMENT_MAP = "UPDATE " + ClaimSettlementMap.TABLE_NAME + " SET "
			+ ClaimSettlementMap.COLUMN_NAME_CLAIM_SET_ID + " = ? , "
			+ ClaimSettlementMap.COLUMN_NAME_ICD_COUNTER_PARTY_ID + " = ?  WHERE id = ?";

	private final String SQL_GET_ALL = "SELECT * from " + ClaimSettlementMap.TABLE_NAME;

	private final String SQL_INSERT_CLAIM_SETTLEMENT_MAP = "INSERT INTO " + ClaimSettlementMap.TABLE_NAME + " ( "
			+ ClaimSettlementMap.COLUMN_NAME_CLAIM_SET_ID + ", " + ClaimSettlementMap.COLUMN_NAME_ICD_COUNTER_PARTY_ID
			+ " ) " + " VALUES (?,?)";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ClaimSettlementMapDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public ClaimSettlementMap getClaimSettlementMapById(Long id) {
		return jdbcTemplate.queryForObject(SQL_FIND_CLAIM_SETTLEMENT_MAP, new Object[] { id },
				new ClaimSettlementMapMapper());
	}

	@Override
	public List<ClaimSettlementMap> getAllClaimSettlementMaps() {
		return jdbcTemplate.query(SQL_GET_ALL, new ClaimSettlementMapMapper());
	}

	@Override
	public boolean deleteClaimSettlementMap(ClaimSettlementMap claimSettlementMap) {
		return jdbcTemplate.update(SQL_DELETE_CLAIM_SETTLEMENT_MAP, claimSettlementMap.getId()) > 0;
	}

	@Override
	public boolean updateClaimSettlementMap(ClaimSettlementMap claimSettlementMap) {
		return jdbcTemplate.update(SQL_UPDATE_CLAIM_SETTLEMENT_MAP, claimSettlementMap.getClaimSettlementId(),
				claimSettlementMap.getClaimICDCounterPartyId()) > 0;
	}

	@Override
	public Long createClaimSettlementMap(ClaimSettlementMap claimSettlementMap) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(SQL_INSERT_CLAIM_SETTLEMENT_MAP, claimSettlementMap.getClaimSettlementId(),
				claimSettlementMap.getClaimICDCounterPartyId());

//		PreparedStatement ps = jdbcTemplate.getDataSource().getConnection()
//				.prepareStatement(SQL_INSERT_CLAIM_SETTLEMENT_MAP);
//		ps.setLong(1, claimSettlementMap.getClaimSettlementId());
//		ps.setLong(2, claimSettlementMap.getClaimICDCounterPartyId());
//
//		jdbcTemplate.update(ps, keyHolder);

		return (Long) keyHolder.getKey();
	}

}
