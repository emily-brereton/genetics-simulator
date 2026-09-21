package emily.io;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import emily.model.people.Male;

public class PersonPrompterTest {

    @Test
    void createManTest(){

        // blue eyes, brown hair
        Scanner fakeInput = new Scanner("1\ngreen\n1\nblonde");
        ConsolePrompter<String> consolePrompter = new ConsolePrompter<String>(fakeInput);
        TraitPrompter traitPrompter = new TraitPrompter(consolePrompter);
        PersonPrompter personPrompter = new PersonPrompter(traitPrompter);

        Male resultPerson = personPrompter.createMan("John", "Doe");
        System.out.println(resultPerson);
    }
    
}
