DECLARE -- começa a seção de declaração das variáveis do bloco.
     -- Entre o declare e o begin colocamos os componentes que iremos utilizar, como variáveis, constantes e etc.
    v_segmercado_id cliente.segmercado_id%type := 3;
BEGIN
    -- Entre o begin e o end vão os comandos de ação.
    
    FOR i IN 1..3 LOOP
        ATUALIZAR_CLI_SEG_MERCADO(i, v_segmercado_id);
    END LOOP;
    COMMIT;
END;