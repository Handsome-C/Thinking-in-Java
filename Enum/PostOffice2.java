package cyc.Enum;

import cyc.UtilsPackage.Enums;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

class Mail2{
    enum GeneralDelivery{YES,NO1,NO2,NO3,NO4,NO5}
    enum Scannability{UNSCANNABLE,YES1,YES2,YES3,YES4}
    enum Readability{ILLEGIBLE,YES1,YES2,YES3,YES4}
    enum Address{INCORRECT,OK1,OK2,OK3,OK4,OK5,OK6}
    enum ReturnAddress{MISSING,OK1,OK2,OK3,OK4,OK5}
    enum ForwardMail{NO,YES1,YES2,YES3,YES4}
    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    ForwardMail forwardMail;
    static long counter=0;
    long id=counter++;
    public String toString()
    {
        return "Mail:"+id;
    }
    public String details()
    {
        return toString()+
                ", General Delivery:"+generalDelivery+
                ", Address Scannability:"+scannability+
                ", Address Readability:"+readability+
                ",Address address:"+address+
                ",Forward mail:"+forwardMail;
    }
    // Generate test Mail:
    public static Mail2 randomMail()
    {
        Mail2 m=new Mail2();
        m.address= Enums.random(Address.class);
        m.readability=Enums.random(Readability.class);
        m.scannability=Enums.random(Scannability.class);
        m.generalDelivery=Enums.random(GeneralDelivery.class);
        m.forwardMail=Enums.random(ForwardMail.class);
        m.returnAddress=Enums.random(ReturnAddress.class);
        return m;
    }
    // A Generator to create random Mail in the For-each loop
    public static Iterable<Mail2>generator(final int num)
    {
        return new Iterable<Mail2>() {
            private int n=num;
            @Override
            public Iterator<Mail2> iterator() {
                return new Iterator<Mail2>() {
                    @Override
                    public boolean hasNext() {
                        return n-->0;
                    }

                    @Override
                    public Mail2 next() {
                        return randomMail();
                    }
                };
            }
        };
    }
}
interface Command2{
    boolean handler(Mail2 m);
}
public class PostOffice2 {
    enum MailHandler
    {
        GeneralDelivery,Address,Readability,Scannability,ForwardMail,ReturnAddress
    }
    private static EnumMap<MailHandler,Command2>enumMap=
            new EnumMap<MailHandler, Command2>(MailHandler.class);
    // Initial the enumMap
    static{
        enumMap.put(MailHandler.GeneralDelivery, new Command2() {
            @Override
            public boolean handler(Mail2 m) {
                switch (m.generalDelivery)
                {
                    case YES:
                        System.out.println("Using general delivery for"+m);
                        return true;
                    default:
                        return false;
                }
            }
        });
        enumMap.put(MailHandler.Scannability, new Command2() {
            @Override
            public boolean handler(Mail2 m) {
                switch (m.scannability)
                {
                    case UNSCANNABLE:return false;
                    default:
                        switch (m.address)
                        {
                            case INCORRECT:return false;
                            default:
                                System.out.println("Delivering "+m+" automatically");
                                return true;
                        }
                }
            }
        });
        enumMap.put(MailHandler.Readability, new Command2() {
            @Override
            public boolean handler(Mail2 m) {
                switch (m.readability)
                {
                    case ILLEGIBLE:return false;
                    default:
                        System.out.println("Delivering "+m+" normally");
                        return true;
                }
            }
        });
        enumMap.put(MailHandler.ForwardMail, new Command2() {
            @Override
            public boolean handler(Mail2 m) {
                switch (m.forwardMail)
                {
                    case NO:return false;
                    default:
                        System.out.println("Forwarding "+m);
                        return true;
                }
            }
        });
        enumMap.put(MailHandler.ReturnAddress, new Command2() {
            @Override
            public boolean handler(Mail2 m) {
                switch (m.returnAddress)
                {
                    case MISSING:return false;
                    default:
                        System.out.println("Returning "+m+"to sender");
                        return true;
                }
            }
        });
    }
    public static void handler(Mail2 m)
    {
        for(Map.Entry<MailHandler,Command2>entry: enumMap.entrySet())
        {
            if(entry.getValue().handler(m))
                return;
        }
    }
    public static void main(String []args)
    {
        for(Mail2 m: Mail2.generator(10))
        {
            System.out.println(m.details());
            handler(m);
            System.out.println("****");
        }
    }

}
