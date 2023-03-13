CREATE TABLE IF NOT EXISTS java_lessons.account_sub_accounts
(
    account_id  INT,
    sub_account VARCHAR(20),
    FOREIGN KEY (account_id)
        REFERENCES java_lessons.account (id)
);

