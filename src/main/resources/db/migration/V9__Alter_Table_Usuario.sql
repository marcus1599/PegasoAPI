ALTER TABLE public.usuario
    RENAME COLUMN nome TO username;

ALTER TABLE IF EXISTS public.usuario
    OWNER TO pegaso_postgresql_user;