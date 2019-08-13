package ejercicioMotores;

import java.math.BigDecimal;

public class MotorNuclear extends MotorRerigerable {
    public MotorNuclear(){

    }

    @Override
    public void refrigerar() {
        this.temperatura = this.temperatura.multiply(BigDecimal.valueOf(0.8));
    }
}
