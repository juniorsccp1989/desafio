CREATE TABLE IF NOT EXISTS customer (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    document_number VARCHAR (50),
    name VARCHAR(255),
    type VARCHAR(50),
    gender VARCHAR(50),
    date_of_birth VARCHAR(255),
    email VARCHAR(255),
    phone_number BIGINT
);

CREATE TABLE IF NOT EXISTS cotacao (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    insurance_policy_id BIGINT,
    product_id VARCHAR(255),
    offer_id VARCHAR(255),
    category VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    total_monthly_premium_amount DECIMAL(10, 2),
    total_coverage_amount DECIMAL(10, 2),
    customer_id BIGINT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE IF NOT EXISTS coverage (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome_coverage VARCHAR(255),
    vl_coverage DECIMAL(10, 2),
    cotacao_id BIGINT NOT NULL,
    FOREIGN KEY (cotacao_id) REFERENCES cotacao(id)
);

CREATE TABLE IF NOT EXISTS assistance (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome_assistance VARCHAR(255),
    cotacao_id BIGINT NOT NULL,
    FOREIGN KEY (cotacao_id) REFERENCES cotacao(id)
);