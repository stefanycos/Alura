DECLARE -- come�a a se��o de declara��o das vari�veis do bloco.
     -- Entre o declare e o begin colocamos os componentes que iremos utilizar, como vari�veis, constantes e etc.
    v_segmercado_id cliente.segmercado_id%type := 3;
BEGIN
    -- Entre o begin e o end v�o os comandos de a��o.
    
    FOR i IN 1..3 LOOP
        ATUALIZAR_CLI_SEG_MERCADO(i, v_segmercado_id);
    END LOOP;
    COMMIT;
END;