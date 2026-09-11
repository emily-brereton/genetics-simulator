package emily;

import java.util.Scanner;
import emily.model.people.Female;
import emily.model.people.Male;
import emily.model.people.Person;
import emily.model.people.PersonFactory;
import emily.model.utils.Ancillary;

import emily.io.PersonPrompter;


public class App {

    public static void main(String[] args) {

        Dashboard dashboard = new Dashboard();
        Scanner input = new Scanner(System.in);
        PersonPrompter personPrompter = new PersonPrompter(input);

        // title menu
        System.out.println(dashboard.title);
        
        Ancillary.pause(input, "Press Enter to continue...");
        String choice = "";

        // "Adam" and "Eve" (to start population)
        System.out.println("To get started, we need at least one male person and one female person.");
        input.nextLine();

        System.out.println("First, let's start with Adam.");
        System.out.println("This is Adam Paper. He needs DNA.");
        Male adam = personPrompter.createMan();
        Dashboard.savePerson(adam);

        Ancillary.pause(input, "Press Enter to continue...");

        System.out.println("Now, let's create Eve.");
        System.out.println("This is Eve Paper. She also needs DNA.");
        Female eve = personPrompter.createWoman();
        Dashboard.savePerson(eve);

        Ancillary.pause(input, "Press Enter to continue...");

        // Main menu loop
        while (!choice.equals("5")) {

            System.out.println(new Dashboard().menu);

            System.out.print("Enter a command: ");
            choice = input.nextLine();

            switch (choice) {
                case "1" -> {

                    Male dad = new Male();
                    Female mom = new Female();

                    boolean isMale = personPrompter.isMale(personPrompter.isMalePrompter(input));

                    String messageA = "default message.";
                    String pronoun = "";
                    if (isMale) {
                        messageA = "Your person is a male.";
                        pronoun = "his";
                    } else {
                        messageA = "Your person is a female.";
                        pronoun = "her";
                    }
                    System.out.println(messageA);

                    String firstName = personPrompter.namePrompter(input, isMale ? dad.getMaleNames() : mom.getFemaleNames(),"Give " + pronoun + " a first name, or enter \"R\" to randomize: ");
                    String lastName = personPrompter.namePrompter(input, dad.getLastNames(), "Give " + firstName + " a last name, or enter \"R\" to randomize: ");



                    Person person = PersonFactory.createStarterPerson(
                            input,
                            Person.makeFirstName(input, isMale, new Male(), new Female()),
                            Person.makeLastName(input),
                            isMale);

                    Person.printPerson(person);
                    Ancillary.pause(input, "Press Enter to continue...");

                    Dashboard.addToPopulation(person, input);
                }

                case "2" -> {
                    System.out.println("Are you ready to have a baby?");
                    Male dad = (Male) Dashboard.selectParent("dad", dashboard.getAllMales(), input);
                    Female mom = (Female) Dashboard.selectParent("mom", dashboard.getAllFemales(), input);

                    System.out.println("Gestating baby...");
                    input.nextLine();

                    boolean isMale = Math.random() < 0.5;
                    if (isMale) {
                        System.out.println("Congratulations, it's a boy! ");
                    } else {
                        System.out.println("Congratulations, it's a girl! ");
                    }

                    Person baby = PersonFactory.createBaby(input, dad, mom,
                            Person.makeFirstName(input, isMale, dad, mom), isMale);
                    Person.printPerson(baby);

                    Dashboard.addToPopulation(baby, input);
                }

                case "3" -> {
                    // need to make this print better
                    System.out.println("Here is your current population:");

                    System.out.println("""
                            --------------------------------------------------------
                                            All Men in Population
                            --------------------------------------------------------
                                    """);

                    for (Male m : dashboard.getAllMales()) {
                        System.out.println(m.toString());
                    }

                    System.out.println("""
                            --------------------------------------------------------
                                            All Women in Population
                            --------------------------------------------------------
                                    """);

                    for (Female f : dashboard.getAllFemales()) {
                        System.out.println(f.toString());
                    }
                }
                case "4" -> {
                }
                case "5" -> {
                }

                default -> {
                    System.out.println("Invalid entry. Please enter a number between 1 and 5.");
                }
            }
        }
    }
}
