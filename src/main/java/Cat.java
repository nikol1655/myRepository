import annotations.Private;
import annotations.Public;

public class Cat implements MyInterface {
    private String id;

    private String name;

    private int age;

    @Override
    @Private
    @Public
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    @Public
    public void giveSound() {
        System.out.println("Miau Miau");
    }
}
