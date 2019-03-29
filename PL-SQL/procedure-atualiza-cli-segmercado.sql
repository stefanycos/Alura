--------------------------------------------------------
--  File created - Friday-March-29-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure ATUALIZAR_CLI_SEG_MERCADO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "CURSOPLSQL"."ATUALIZAR_CLI_SEG_MERCADO" 
    (p_id cliente.id%type,
    p_segmercado_id IN cliente.segmercado_id%type)
IS
    eh_cliente_id_inexistente EXCEPTION;

BEGIN
    UPDATE cliente
        SET segmercado_id = p_segmercado_id
        WHERE id = p_id;
    
    -- valida se o comando executado acima retornou alguma coisa
    IF SQL%NOTFOUND THEN
        -- RAISE: provoca erro de execução, invocando a exception
        RAISE eh_cliente_id_inexistente;
    END IF;
    COMMIT; 
    
    EXCEPTION
        WHEN eh_cliente_id_inexistente THEN
			-- invoca a uma procedure do PL/SQL
            RAISE_APPLICATION_ERROR(-20100, 'Cliente inexistente.');
END;

/
