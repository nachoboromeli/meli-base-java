package ejercicioMotores;

import java.math.BigDecimal;

public class Motor {

    public int potencia;
    public BigDecimal temperatura;

    public Motor(){
        potencia = 0;
        temperatura = BigDecimal.valueOf(0);
    }

    public int getPotencia(){
        return this.potencia;
    }

    public void subirNivelPotencia(){
        this.potencia += 1;
        subirTemperatura();
    }

    public BigDecimal getTemperatura(){
        return this.temperatura;
    }

    public void subirTemperatura(){
        this.temperatura = this.temperatura.add(BigDecimal.valueOf(1));
    }

}

