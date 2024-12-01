DROP TABLE IF EXISTS wallets;

CREATE TABLE IF NOT EXISTS wallets
 (
    wallet_id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    wallet_balance    DOUBLE PRECISION     NOT NULL
);