package jk.research.spring.jdbc.poc.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = ClaimSettlementMap.TABLE_NAME)
public class ClaimSettlementMap {

	public static final String TABLE_NAME = "claim_settlement_map";

	public static final String COLUMN_NAME_CLAIM_SET_ID = "claim_settlement_id";
	public static final String COLUMN_NAME_ICD_COUNTER_PARTY_ID = "claim_icd_counter_party_id";

	private Long id;
	private Long claimSettlementId;
	private Long claimICDCounterPartyId;

	public ClaimSettlementMap() {
		super();
	}

	public ClaimSettlementMap(Long claimSettlementId, Long claimICDCounterPartyId) {
		super();
		this.claimSettlementId = claimSettlementId;
		this.claimICDCounterPartyId = claimICDCounterPartyId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClaimSettlementId() {
		return claimSettlementId;
	}

	public void setClaimSettlementId(Long claimSettlementId) {
		this.claimSettlementId = claimSettlementId;
	}

	public Long getClaimICDCounterPartyId() {
		return claimICDCounterPartyId;
	}

	public void setClaimICDCounterPartyId(Long claimICDCounterPartyId) {
		this.claimICDCounterPartyId = claimICDCounterPartyId;
	}

	@Override
	public String toString() {
		return "ClaimSettlementMap [claimSettlementId=" + claimSettlementId + ", claimICDCounterPartyId="
				+ claimICDCounterPartyId + "]";
	}

}
