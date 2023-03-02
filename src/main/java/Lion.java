import annotations.Private;
import annotations.Public;


public class Lion implements MyInterface {

    private String id;

    private String name;

    private int age;

    @Override
    @Public
    @Private
    public String getId() {
        return this.id;
    }

    @Override
    @Private
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    @Private
    public void giveSound() {
        System.out.println("Grrr Grrrr");
    }
}
