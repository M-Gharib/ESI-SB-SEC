INSERT INTO public.user (user_id, name, password, roles)
SELECT * FROM (SELECT 1, 'admin', 'admin', 'ADMIN') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM public.user  WHERE user_id = '1'
) LIMIT 1;

INSERT INTO public.user (user_id, name, password, roles)
SELECT * FROM (SELECT 2, 'user', 'user', 'USER') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM public.user  WHERE user_id = '2'
) LIMIT 1;

