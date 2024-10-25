INSERT INTO receitas(id, observacoes, rendimento, tempo_preparo, tipo_receita, titulo) VALUES (1, 'Fritar em óleo quente', '30 unidades', '30 min', 1, 'Bolinho de chuva salgado');
INSERT INTO ingredientes(id, nome, quantidade, unidade_medida) VALUES
(1, 'Farinha de trigo', '2', 'Xícaras'),
(2, 'Ovos', '2', 'Unidade'),
(3, 'Leite', '1', 'Xícara'),
(4, 'Fermento', '1', 'Colher'),
(5, 'Queijo parmesão ralado', '100', 'Gramas');

INSERT INTO modo_preparo(id, descricao, ordem) VALUES
(1, 'Esquente o leite, mas não levante fervura', 1),
(2, 'Misture todos os ingredientes até ficar uma massa homogânea', 2);

INSERT INTO receitas_ingredientes(receitas_id, ingredientes_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5);

INSERT INTO receitas_modo_preparo(receitas_id, modo_preparo_id) VALUES
(1, 1),
(1, 2);