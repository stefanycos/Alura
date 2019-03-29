-- Utilização de cursores, ambos os exemplos tem a mesma função, porém o cursor 2 tem menos código

-- Cursor 1
DECLARE
    v_id cliente.id%type;
    v_segmercado_id  cliente.segmercado_id%type := 1;
    CURSOR cur_cliente IS SELECT id FROM cliente; -- Declaração do cursor.
BEGIN
    OPEN cur_cliente; -- Executa a query e guuarda o resultado em memória.
        LOOP
            FETCH cur_cliente INTO v_id; -- lê as linhas e guarda na varialve v_id, depois do INTO devemos ter o mesmo tanto de variáveis que o cursor
            EXIT WHEN cur_cliente%NOTFOUND; -- verifica se o FETCH falhou ou não, para parar o loop.
            atualizar_cli_seg_mercado(v_id, v_segmercado_id);
        END LOOP;
    CLOSE cur_cliente;
    COMMIT;
END;

-- Cursor 2
DECLARE
    v_segmercado_id  cliente.segmercado_id%type := 2;
    CURSOR cur_cliente IS SELECT id FROM cliente; -- Declaração do cursor.
BEGIN 
    FOR cli_rec IN cur_cliente LOOP -- o open do cursor e feito de maneira implicita, o fetch também.
        atualizar_cli_seg_mercado(v_segmercado_id, v_segmercado_id);
    END LOOP; -- o close do cursor e feito de maneira implicita
    COMMIT;
END;