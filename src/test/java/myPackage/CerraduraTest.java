package myPackage;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class CerraduraTest {

    @Test
    public void crearCerradura(){

        Cerradura cerradura = new Cerradura();
        Assertions.assertThat(cerradura).isNotNull();
    }



    @Test
    public void crearCerraduraConClaveNumerica(){

        Cerradura cerradura = new Cerradura(1234);
        Assertions.assertThat(cerradura).isNotNull();
    }

    @Test
    public  void crearCerraduraConClaveNumericaYLaGuarde(){

        Cerradura cerradura = new Cerradura(1234);
        Assertions.assertThat(cerradura).isNotNull();
        Assertions.assertThat(cerradura.Clave).isEqualTo(1234);

    }

    @Test
    public  void crearCerraduraConOtraClaveNumericaYLaGuarde(){

        Cerradura cerradura = new Cerradura(1235);
        Assertions.assertThat(cerradura).isNotNull();
        Assertions.assertThat(cerradura.Clave).isEqualTo(1235);

    }

    @Test
    public void abrirCerraduraConClaveError(){

        int clave = 9999;
        Cerradura cerradura = new Cerradura(clave);
        cerradura.Cerrar();
        Assertions.assertThat(cerradura.isOpen).isFalse();

        cerradura.Abrir(clave + 1);

        Assertions.assertThat(cerradura.isOpen).isFalse();
    }

    @Test
    public void abrirCerraduraConClaveExito(){

        int clave = 9999;
        Cerradura cerradura = new Cerradura(clave);

        cerradura.Cerrar();
        Assertions.assertThat(cerradura.isOpen).isFalse();

        cerradura.Abrir(clave);

        Assertions.assertThat(cerradura.isOpen).isTrue();
    }

}
