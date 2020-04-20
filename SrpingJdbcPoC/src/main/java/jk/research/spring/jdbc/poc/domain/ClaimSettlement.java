package jk.research.spring.jdbc.poc.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = ClaimSettlement.TABLE_NAME)
public class ClaimSettlement {

	public static final String TABLE_NAME = "claim_settlement";

	public static final String COLUMN_NAME_PROVIDER_LEGAL_ENT_ID = "provider_legal_entity_id";
	public static final String COLUMN_NAME_HOSPITAL_CCP_ID = "hospital_ccp_id";
	public static final String COLUMN_NAME_CLAIM_ICD_CTR_PATRIES = "claim_ic_ctr_parties";
	public static final String COLUMN_NAME_CLAIM_SETTLEMENT_TYPE = "claim_settlement_type";

	private Long id;

	private Long providerLegalEntityId;

	private Long hospitalCCPId;

	private String claimICDCounterParties;

	private String claimSettlementType;

	public ClaimSettlement() {
		super();
	}

	public ClaimSettlement(Long id, Long providerLegalEntityId, Long hospitalCCPId, String claimICDCounterParties,
			String claimSettlementType) {
		super();
		this.id = id;
		this.providerLegalEntityId = providerLegalEntityId;
		this.hospitalCCPId = hospitalCCPId;
		this.claimICDCounterParties = claimICDCounterParties;
		this.claimSettlementType = claimSettlementType;
	}

	public ClaimSettlement(Long providerLegalEntityId, Long hospitalCCPId, String claimICDCounterParties,
			String claimSettlementType) {
		super();
		this.providerLegalEntityId = providerLegalEntityId;
		this.hospitalCCPId = hospitalCCPId;
		this.claimICDCounterParties = claimICDCounterParties;
		this.claimSettlementType = claimSettlementType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProviderLegalEntityId() {
		return providerLegalEntityId;
	}

	public void setProviderLegalEntityId(Long providerLegalEntityId) {
		this.providerLegalEntityId = providerLegalEntityId;
	}

	public Long getHospitalCCPId() {
		return hospitalCCPId;
	}

	public void setHospitalCCPId(Long hospitalCCPId) {
		this.hospitalCCPId = hospitalCCPId;
	}

	public String getClaimICDCounterParties() {
		return claimICDCounterParties;
	}

	public void setClaimICDCounterParties(String claimICDCounterParties) {
		this.claimICDCounterParties = claimICDCounterParties;
	}

	public String getClaimSettlementType() {
		return claimSettlementType;
	}

	public void setClaimSettlementType(String claimSettlementType) {
		this.claimSettlementType = claimSettlementType;
	}

	@Override
	public String toString() {
		return "ClaimSettlement [id=" + id + ", providerLegalEntityId=" + providerLegalEntityId + ", hospitalCCPId="
				+ hospitalCCPId + ", claimICDCounterParties=" + claimICDCounterParties + ", claimSettlementType="
				+ claimSettlementType + "]";
	}

}
