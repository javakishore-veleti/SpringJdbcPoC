CREATE DATABASE IF NOT EXISTS jk_research_spring_jdbc_poc_db;

USE jk_research_spring_jdbc_poc_db;

CREATE TABLE IF NOT EXISTS claim_settlement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    provider_legal_entity_id INT,
    hospital_ccp_id INT,
    claim_ic_ctr_parties VARCHAR(100),
    claim_settlement_type VARCHAR(100) ,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS claim_settlement_map (
    id INT AUTO_INCREMENT PRIMARY KEY,
    claim_settlement_id INT,
    claim_icd_counter_party_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (claim_settlement_id)
        REFERENCES claim_settlement (id)
)  ENGINE=INNODB;

