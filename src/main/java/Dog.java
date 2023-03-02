import annotations.Private;
import annotations.Public;
import annotations.ScanMe;

@ScanMe
public class Dog implements MyInterface {
    private String id;

    private String name;

    private int age;

    @Override
    @Private
    public String getId() {
        return this.id;
    }

    @Override
    @Public
    public String getName() {
        return this.name;
    }

    @Override
    @Private
    @Public
    public int getAge() {
        return this.age;
    }

    @Override
    public void giveSound() {
        System.out.println("Hau Hau");
    }
}
