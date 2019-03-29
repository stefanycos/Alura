--------------------------------------------------------
--  File created - Friday-March-29-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure INCLUIR_SEGMERCADO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "CURSOPLSQL"."INCLUIR_SEGMERCADO" (p_id IN NUMBER, p_descricao IN VARCHAR2)
IS -- o IS precisa estar presente mesmo que não haja nenhum parametro.
BEGIN
    INSERT INTO segmercado VALUES(p_id, UPPER(p_descricao));
    COMMIT;
END;

/
