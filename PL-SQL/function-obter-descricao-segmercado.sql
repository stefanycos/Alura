--------------------------------------------------------
--  File created - Friday-March-29-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Function OBTER_DESCRICAO_SEGMERCADO
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "CURSOPLSQL"."OBTER_DESCRICAO_SEGMERCADO" (p_id IN segmercado.id%type)
    RETURN segmercado.descricao%type -- tipo de dado que ser� retornado
IS
    v_descricao segmercado.descricao%type;
BEGIN
    SELECT descricao INTO v_descricao -- pega o conte�do da coluna descri��o e atribui a variavel v_descricao
        FROM segmercado
        WHERE id = p_id;
    RETURN v_descricao;
END;

/
