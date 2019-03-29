--------------------------------------------------------
--  File created - Friday-March-29-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure INCLUIR_CLIENTE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "CURSOPLSQL"."INCLUIR_CLIENTE" 
    (p_id IN cliente.id%type, -- quando definimos o parametro de entrada s� como IN, seu valor n�o poder� ser alterado, apenas lido.
    p_razao_social  cliente.razao_social%type, -- se n�o definirmos se o parametro � IN ou OUT ele assume que � do tipo IN.
    p_segmercado_id IN cliente.segmercado_id%type,
    p_faturamento_previsto IN cliente.faturamento_previsto%type,
    p_cnpj IN cliente.cnpj%type)
IS
    -- defini��o de componentes, mesmo que n�o tenha temos que colocar o IS na procedure
    v_categoria cliente.categoria%type;
    v_cnpj cliente.cnpj%type := p_cnpj;
    
    -- variaveis para tratar exece��o
    eh_null EXCEPTION;
    pragma exception_init(eh_null, -1400);
    
BEGIN
    v_categoria := get_categoria(p_faturamento_previsto);
    
    -- Chamada da procedure
    format_cnpj(v_cnpj);

    INSERT INTO cliente VALUES (p_id, UPPER(p_razao_social),p_segmercado_id, SYSDATE, p_faturamento_previsto, v_categoria, v_cnpj);
    COMMIT;
    
    -- tratamento de exece��es: Predefined, No Prefined, User defined, Exce��es n�o previstas.
    EXCEPTION 
        WHEN dup_val_on_index THEN -- Predefined, j� existents (lista no site da Oracle)
            RAISE_APPLICATION_ERROR(-20010, 'Cliente j� cadastrado!');
        WHEN eh_null THEN -- No Prefined
            RAISE_APPLICATION_ERROR(-20010, 'A coluna ID � obrigat�ria!');
        WHEN OTHERS THEN -- Exce��es n�o previstas
            RAISE_APPLICATION_ERROR(-20020, sqlerrm());
        
END;

/
