ALTER TABLE public.usuario
    ADD COLUMN IF NOT EXISTS avatar VARCHAR(255);

ALTER TABLE public.usuario
    OWNER TO pegaso_postgresql_user;