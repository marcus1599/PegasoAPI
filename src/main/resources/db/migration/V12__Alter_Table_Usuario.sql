CREATE SEQUENCE usuario_seq START WITH 1 INCREMENT BY 1;
ALTER TABLE usuario ALTER COLUMN id_usuario SET DEFAULT nextval('usuario_seq')