DECLARE -- come�a a se��o de declara��o das vari�veis do bloco.
     -- Entre o declare e o begin colocamos os componentes que iremos utilizar, como vari�veis, constantes e etc.
    v_segmercado_id cliente.segmercado_id%type := 1;
    v_counter NUMBER(3);
BEGIN
    v_counter := 1;
    LOOP
        ATUALIZAR_CLI_SEG_MERCADO(v_counter, v_segmercado_id);
        v_counter := v_counter + 1;
        EXIT WHEN v_counter > 3; -- pode ser colocado em qualquer ligar do loop, n�o apenas no final.
    END LOOP;
END;