package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		if (funcionario.getSalario().compareTo(new BigDecimal("10000")) == 1) {
			throw new IllegalArgumentException("Funcionário com o salário maior que R$ 10.000,00 não pode receber bônus!");
		}
		
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
