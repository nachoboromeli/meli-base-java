package ejercicioMotores;

import org.assertj.core.api.Assertions;

import java.math.BigDecimal;
import org.junit.Test;

public class MotoresTest {

    @Test
    public void crearMotor(){
        Motor motor = new Motor();
        Assertions.assertThat(motor).isNotNull();
    }

    @Test
    public void crearMotorCombustible(){
        MotorCombustible motorC = new MotorCombustible();
        Assertions.assertThat(motorC).isNotNull();
    }

    @Test
    public void crearMotorNuclear(){
        MotorNuclear motorN = new MotorNuclear();
        Assertions.assertThat(motorN).isNotNull();
    }

    @Test
    public void crearMotorSolar(){
        MotorSolar motorS = new MotorSolar();
        Assertions.assertThat(motorS).isNotNull();
    }

    @Test
    public void subirNivelPotencia(){
        Motor motor = new Motor();
        float potenciaInicial = motor.getPotencia();
        motor.subirNivelPotencia();
        float potenciaFinal = motor.getPotencia();
        Assertions.assertThat(potenciaFinal).isGreaterThanOrEqualTo(potenciaInicial);
    }

    @Test
    public void subirNivelTemperatura(){
        Motor motor = new Motor();
        BigDecimal temperaturaInicial = motor.getTemperatura();
        motor.subirNivelPotencia();
        BigDecimal temperaturaFinal = motor.getTemperatura();
        Assertions.assertThat(temperaturaFinal).isGreaterThanOrEqualTo(temperaturaInicial);
    }

    @Test
    public void refrigerarMotorSolar(){
        MotorSolar motorS = new MotorSolar();
        for (int i = 0; i < 100; i ++){
            motorS.subirNivelPotencia();
        }
        BigDecimal temperaturaInicial = motorS.getTemperatura();
        motorS.refrigerar();
        BigDecimal temperaturaFinal = motorS.getTemperatura();
        Assertions.assertThat(temperaturaFinal).isEqualTo(temperaturaInicial.multiply(BigDecimal.valueOf(0.8)));
    }

    @Test
    public void refrigerarMotorNuclear(){
        MotorNuclear motorN = new MotorNuclear();
        motorN.subirNivelPotencia();
        BigDecimal temperaturaInicial = motorN.getTemperatura();
        motorN.refrigerar();
        BigDecimal temperaturaFinal = motorN.getTemperatura();
        Assertions.assertThat(temperaturaFinal).isLessThanOrEqualTo(temperaturaInicial);
        Assertions.assertThat(temperaturaFinal).isEqualTo(temperaturaInicial.multiply(BigDecimal.valueOf(0.8)));
    }

}
