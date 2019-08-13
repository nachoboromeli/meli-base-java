package ejercicioMotores;

import java.math.BigDecimal;

public class MotorSolar extends MotorRerigerable {
    @Override
    public void refrigerar() {
        this.temperatura = this.temperatura.multiply(BigDecimal.valueOf(0.8));
    }
}
