ALTER TABLE java_lessons.account
    ADD COLUMN account_info_id INT;

ALTER TABLE java_lessons.account
    ADD
        FOREIGN KEY (account_info_id)
            REFERENCES java_lessons.account_info (id)

