package br.com.caelum.aula_03;

public class TabelaDePrecoPadrao implements TabelaDePreco{
    public double descontoPara(double valor) {
        if(valor>5000) return 0.03;
        if(valor>1000) return 0.05;
        return 0;
    }
}
