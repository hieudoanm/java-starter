DROP SCHEMA IF EXISTS public;

CREATE SCHEMA IF NOT EXISTS public;

DROP TABLE IF EXISTS public.user;

CREATE TABLE IF NOT EXISTS public.user (
    id varchar PRIMARY KEY NOT NULL,
    username varchar NOT NULL,
    password varchar NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

DROP TABLE IF EXISTS public.list;

CREATE TABLE IF NOT EXISTS public.list (
    id varchar PRIMARY KEY NOT NULL,
    title varchar NOT NULL,
    description varchar NOT NULL DEFAULT '',
    user_id varchar NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

DROP TABLE IF EXISTS public.task;

CREATE TABLE IF NOT EXISTS public.task (
    id varchar PRIMARY KEY NOT NULL,
    title varchar NOT NULL,
    description varchar NOT NULL DEFAULT '',
    list_id varchar NOT NULL,
    completed BOOLEAN DEFAULT false,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
