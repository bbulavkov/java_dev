CREATE TABLE IF NOT EXISTS java_lessons.account_info
(
    account_id INT,
    info       VARCHAR(200)
);

ALTER TABLE java_lessons.account_info
    ADD
        FOREIGN KEY (account_id)
            REFERENCES java_lessons.account (id);