CREATE SEQUENCE IF NOT EXISTS user_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS role_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS permission_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS role (
    role_id BIGINT PRIMARY KEY DEFAULT nextval('role_id_seq'),
    role_name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS app_user (  -- renamed "user" karena conflict
    user_id BIGINT PRIMARY KEY DEFAULT nextval('user_id_seq'),
    username VARCHAR(40) NOT NULL UNIQUE,
    password VARCHAR(40) NOT NULL,
    role_id BIGINT NOT NULL,
    CONSTRAINT fk_user_role FOREIGN KEY (role_id) REFERENCES role(role_id)
);

CREATE TABLE IF NOT EXISTS permission (
    permission_id BIGINT PRIMARY KEY DEFAULT nextval('permission_id_seq'),
    permission_type VARCHAR(20) NOT NULL CHECK (permission_type IN ('READ', 'READ_WRITE')),
    role_id BIGINT NOT NULL,
    CONSTRAINT fk_permission_role FOREIGN KEY (role_id) REFERENCES role(role_id)
);
