ALTER TABLE public.usuario
    ADD COLUMN IF NOT EXISTS senha VARCHAR(255);

ALTER TABLE public.usuario
    OWNER TO pegaso_postgresql_user;