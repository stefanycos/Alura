-- criação de tabelas
CREATE TABLE segmercado (id NUMBER(5), descricao VARCHAR(100), categoria VARCHAR2(20));

--adicionar primary key
ALTER TABLE segmercado ADD CONSTRAINT segmercado_id_pk PRIMARY KEY(id);

-- adicionar foreign key
ALTER TABLE segmercado ADD CONSTRAINT segmercado_id_pk PRIMARY KEY(id);

-- inserir dados
INSERT INTO segmercado VALUES (v_id, v_descricao);

-- remover dados
DELETE FROM segmercado WHERE id = v_id;

-- executar função no SQL, no PL/SQL pode chamar a função direto
VARIABLE g_descricao VARCHAR2(200)
EXECUTE :g_descricao := obter_descricao_segmercado(1)
PRINT g_descricao

-- declaração de variáveis, essa variável assume as características da coluna criada no banco, seu tipo e tamanho. 
v_id segmercado.id%type := 3;

-- executar procedure no SQL, no PL/SQL pode chamar a procedure direto
EXECUTE incluir_cliente(6, 'Test', 20, '12315', 1000100);
