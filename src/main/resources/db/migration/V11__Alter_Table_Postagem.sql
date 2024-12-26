CREATE SEQUENCE postagem_seq START WITH 1 INCREMENT BY 1;
ALTER TABLE postagem ALTER COLUMN id_postagem SET DEFAULT nextval('postagem_seq');
