--------------------------------------------------------
--  File created - Friday-March-29-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure INCLUIR_CLIENTE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "CURSOPLSQL"."INCLUIR_CLIENTE" 
    (p_id IN cliente.id%type, -- quando definimos o parametro de entrada só como IN, seu valor não poderá ser alterado, apenas lido.
    p_razao_social  cliente.razao_social%type, -- se não definirmos se o parametro é IN ou OUT ele assume que é do tipo IN.
    p_segmercado_id IN cliente.segmercado_id%type,
    p_faturamento_previsto IN cliente.faturamento_previsto%type,
    p_cnpj IN cliente.cnpj%type)
IS
    -- definição de componentes, mesmo que não tenha temos que colocar o IS na procedure
    v_categoria cliente.categoria%type;
    v_cnpj cliente.cnpj%type := p_cnpj;
    
    -- variaveis para tratar execeção
    eh_null EXCEPTION;
    pragma exception_init(eh_null, -1400);
    
BEGIN
    v_categoria := get_categoria(p_faturamento_previsto);
    
    -- Chamada da procedure
    format_cnpj(v_cnpj);

    INSERT INTO cliente VALUES (p_id, UPPER(p_razao_social),p_segmercado_id, SYSDATE, p_faturamento_previsto, v_categoria, v_cnpj);
    COMMIT;
    
    -- tratamento de execeções: Predefined, No Prefined, User defined, Exceções não previstas.
    EXCEPTION 
        WHEN dup_val_on_index THEN -- Predefined, já existents (lista no site da Oracle)
            RAISE_APPLICATION_ERROR(-20010, 'Cliente já cadastrado!');
        WHEN eh_null THEN -- No Prefined
            RAISE_APPLICATION_ERROR(-20010, 'A coluna ID é obrigatória!');
        WHEN OTHERS THEN -- Exceções não previstas
            RAISE_APPLICATION_ERROR(-20020, sqlerrm());
        
END;

/
