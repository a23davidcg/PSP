package org.example;

import java.util.Random;

public class Mesa {
    private int ingrediente1;
    private int ingrediente2;

    //1 = papel
    //2 = tabaco
    //3 = cerillas

    public void producir() {

        while (ingrediente1 != 0 && ingrediente2 != 0) {
            Random random = new Random();

            this.ingrediente1 = random.nextInt(3) + 1;
            this.ingrediente2 = random.nextInt(3) + 1;
            if (ingrediente1 == ingrediente2) {
                this.ingrediente1 = random.nextInt(3) + 1;
            }

        }

    }
}
