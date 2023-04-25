package pl.javastart;

import pl.javastart.task.HardDrive;
import pl.javastart.task.Memory;
import pl.javastart.task.Processor;

public class Main {

    public static void main(String[] args) {
        try {
            Memory memory = new Memory("Ripjaws", "GSkill", "2137312", 2666, 40, 70, 4096);
            Processor processor = new Processor("Core i3 2120", "Intel", "3231312", 3000, 40, 70);
            HardDrive hardDrive = new HardDrive("Caviar Blue 1TB", "WD", "3203219", 1000);
            System.out.println(memory);
            System.out.println(processor);
            System.out.println(hardDrive);

            System.out.println("Testy podkręcania:");
            memory.overclock();
            System.out.println(memory);
            memory.overclock();
            System.out.println(memory);
            memory.overclock();
            System.out.println(memory);

//            processor.overclock();
//            System.out.println(processor);
//            processor.overclock();
//            System.out.println(processor);
//            processor.overclock();
//            System.out.println(processor);
//            processor.overclock();
//            System.out.println(processor);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
}
