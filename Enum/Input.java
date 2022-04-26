package cyc.Enum;

import cyc.UtilsPackage.Enums;

import java.util.Random;

public enum Input {

    NICKEL(5),DIME(10),QUARTER(15),DOLLAR(100),
    TOOTHPASTE(200),CHIPS(75),SODA(100),SOAP(50),
    ABORT_TRANSACTION{
        @Override
        int amount() {
            throw new RuntimeException("Abort.amount()");
        }
    },
    STOP{
        @Override
        int amount() {
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    }
    ;
    int value;
    Input(int value){this.value=value;}
    Input(){}
    int amount(){return value;}
    static Random rand=new Random(47);
    public static Input randomSelect()
    {
        // Don't include stop!
        return values()[rand.nextInt(values().length-1)];
    }
}
