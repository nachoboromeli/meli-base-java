package ejercicioMotores;

import java.math.BigDecimal;

public abstract class MotorRerigerable extends Motor  {
    public void refrigerar(){
        this.temperatura = this.temperatura.multiply(BigDecimal.valueOf(0.8));
    }
}
