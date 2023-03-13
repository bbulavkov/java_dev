CREATE TABLE IF NOT EXISTS java_lessons.account_account_types
(
    account_id INT,
    type       VARCHAR(20),
    FOREIGN KEY (account_id)
        REFERENCES java_lessons.account (id)
);
