package cyc.Enum;
import cyc.Containers.Generator;
import cyc.UtilsPackage.TextFile;

import java.util.EnumMap;
import java.util.Iterator;

import static cyc.Enum.Input.*;
enum Category
{
    MONEY(NICKEL,DIME,QUARTER,DOLLAR),
    ITEM_SELECTION(TOOTHPASTE,CHIPS,SODA,SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP)
    ;
    Input []inputs;
    private static EnumMap<Input,Category>categories=
            new EnumMap<Input, Category>(Input.class);
    static
    {
        for(Category c:Category.class.getEnumConstants())
        {
            for(Input type:c.inputs)
                categories.put(type, c);
        }
    }
    public static Category category(Input input)
    {
        return categories.get(input);
    }
    Category(Input... inputs)
    {
        this.inputs=inputs;
    }
}
public class VendingMachine {
    private static State state=State.Resting;
    private static int amount=0;
    private static Input selection=null;
    enum StateDuration{TRANSIENT}
    enum State{
        AddingMoney{
            @Override
            void next(Input input) {
                switch(Category.category(input))
                {
                    case MONEY:
                        amount+=input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection=input;
                        if(amount<selection.amount())
                            System.out.println("Insufficient money for"+selection);
                        else
                            state=Dispensing;
                        break;
                    case QUIT_TRANSACTION:
                        state=GivingChange;
                        break;
                    case SHUT_DOWN:
                        state=Terminal;
                    default:
                }
            }
        },
        GivingChange(StateDuration.TRANSIENT)
                {
                    @Override
                    void next() {
                        if(amount>0)
                        {
                        System.out.println("Your change:"+amount);
                        amount=0;
                        }
                        state=Resting;
                    }
                },
        Dispensing(StateDuration.TRANSIENT){
            @Override
            void next() {
                System.out.println("here is your "+selection);
                amount-= selection.amount();
                state=GivingChange;
            }
        },
        Resting{
            @Override
            void next(Input input) {
                switch (Category.category(input))
                {
                    case MONEY:
                      amount+=input.amount();
                      state=AddingMoney;
                      break;
                    case SHUT_DOWN:
                        state=Terminal;
                    default:
                }
            }
        },
        Terminal;
        private boolean isTransient=false;
        State(){}
        State(StateDuration trans){isTransient=true;}
        void next(Input input)
        {
            // It will be overrided in the non-transient State
            // if the transient call this method ,it will throw
            // the runtimeException.
            throw new RuntimeException("Only call "+
                    "next(Input input)for non-transient states");
        }
        void next()
        {
            // It will be overrided in the transient State
            // If the non-transient call this method, it will throw
            // the runtimeException
            throw new RuntimeException("Only call next() for"+
                    "StateDuration.TRANSIENT states");
        }
        void output()
        {
            System.out.println(amount);
        }
    }
    static void run(Generator<Input>gen)
    {
        while(state!=State.Terminal)
        {
            state.next(gen.next());
            while(state.isTransient)
                state.next();
            state.output();
        }
    }
    public static void main(String[]args)
    {
        Generator<Input>gen=new RandomInputGenerator();
        if(args.length==1)
            gen=new FileInputGenerator(args[0]);
        run(gen);
    }
}

// For a basic sanity check
class RandomInputGenerator implements Generator<Input>
{
    @Override
    public Input next() {
        return Input.randomSelect();
    }
}

// Create Inputs from a file of ";" -separated strings:
class FileInputGenerator implements Generator<Input>
{
    private Iterator<String>input;
    public FileInputGenerator(String filename)
    {
        input= new TextFile(filename,";").iterator();
    }
    @Override
    public Input next() {
        if(!input.hasNext())
            return null;
        return Enum.valueOf(Input.class, input.next().trim());
    }
}
