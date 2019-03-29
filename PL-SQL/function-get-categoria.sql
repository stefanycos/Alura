--------------------------------------------------------
--  File created - Friday-March-29-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Function GET_CATEGORIA
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "CURSOPLSQL"."GET_CATEGORIA" (p_faturamento_previsto cliente.faturamento_previsto%type)
    RETURN cliente.categoria%type
IS
    v_categoria cliente.categoria%type;
BEGIN
    IF p_faturamento_previsto < 10000 THEN
        v_categoria := 'PEQUENO';
    ELSIF p_faturamento_previsto < 50000 THEN
        v_categoria := 'MEDIO';
    ELSE 
        v_categoria := 'GRANDE';
    END IF;

    RETURN v_categoria;
END;

/
