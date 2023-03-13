CREATE TABLE IF NOT EXISTS java_lessons.account_info
(
    account_id INT,
    info       VARCHAR(200),
    FOREIGN KEY (account_id)
        REFERENCES java_lessons.account (id)
);