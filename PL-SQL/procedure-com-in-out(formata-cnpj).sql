CREATE OR REPLACE PROCEDURE FORMAT_CNPJ (
    -- quando colocamos IN OUT estamos dizendo que os dados obtidos são para leitura e escrita. 
    -- Além disso esse mesmo parametro é retornado pela procedure automaticamente.
    p_cnpj IN OUT cliente.cnpj%type)
IS
BEGIN
    p_cnpj := substr(p_cnpj,1,2) ||'/'|| substr(p_cnpj,3);
END;

-- Criação da variavel
VARIABLE g_cnpj VARCHAR2(19)
EXECUTE :g_cnpj := '12345'
PRINT g_cnpj

-- Execução da procedure, que retorna o cnpj formatado. 
EXECUTE format_cnpj(:g_cnpj);
PRINT g_cnpj;

-- Só precisamos colocar o execute quando estamos executando o SQL, no PL/SQL podemos invocar a procedure direto
EXECUTE INCLUIR_CLIENTE(3, 'Industria RTY', NULL, 110000, '13518');
