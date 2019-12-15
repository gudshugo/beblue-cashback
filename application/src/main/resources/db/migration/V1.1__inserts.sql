INSERT INTO genero (descricao)
VALUES ('POP')
,('MPB')
,('CLASSIC')
,('ROCK');

INSERT INTO public.genero_cashback (cashback,dia,genero_id) VALUES
(0.25,0,1)
,(0.07,1,1)
,(0.06,2,1)
,(0.02,3,1)
,(0.1,4,1)
,(0.15,5,1)
,(0.2,6,1)
,(0.3,0,2)
,(0.5,1,2)
,(0.1,2,2);

INSERT INTO public.genero_cashback (cashback,dia,genero_id) VALUES
(0.15,3,2)
,(0.2,4,2)
,(0.25,5,2)
,(0.3,6,2)
,(0.35,0,3)
,(0.3,1,3)
,(0.5,2,3)
,(0.8,3,3)
,(0.13,4,3)
,(0.18,5,3);

INSERT INTO public.genero_cashback (cashback,dia,genero_id) VALUES
(0.25,6,3)
,(0.4,0,4)
,(0.1,1,4)
,(0.15,2,4)
,(0.15,3,4)
,(0.15,4,4)
,(0.2,5,4)
,(0.4,6,4);


