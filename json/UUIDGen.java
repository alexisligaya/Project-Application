import java.util.UUID;

public class UUIDGen{

    public void run(){
        for(int i=0; i < 10; i++)
        System.out.println(UUID.randomUUID());
    }

    public static void main(String args[])
    {
        UUIDGen gen = new UUIDGen();
        gen.run();
    }
    
}