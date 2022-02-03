package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class BonusServiceTest {
    
    @Test
    public void deveCalcularBonusSalarioMenor10000() {
        // cenário
        Funcionario funcionario = new Funcionario("João", 
                LocalDate.of(2014, 12, 17), 
                new BigDecimal("5000"));
        
        // execução
        BonusService bonusService = new BonusService();
        BigDecimal valorBonus = bonusService.calcularBonus(funcionario);

        // verificação
        Assertions.assertEquals(new BigDecimal("500.00"), valorBonus);
    }

    @Test
    public void deveCalcularBonusSalarioMaior10000() {
        // cenário
        Funcionario funcionario = new Funcionario("João",
                LocalDate.of(2014, 12, 17),
                new BigDecimal("15000"));

        BonusService bonusService = new BonusService();

        // execução e verificação
        Assertions.assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(funcionario));
    }

    @Test
    public void deveCalcularBonusSalarioIgual10000() {
        // cenário
        Funcionario funcionario = new Funcionario("João",
                LocalDate.of(2014, 12, 17),
                new BigDecimal("10000"));

        // execução
        BonusService bonusService = new BonusService();
        BigDecimal valorBonus = bonusService.calcularBonus(funcionario);

        // verificação
        Assertions.assertEquals(new BigDecimal("1000.00"), valorBonus);
    }

}