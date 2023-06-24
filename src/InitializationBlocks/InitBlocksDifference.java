package InitializationBlocks;

public class InitBlocksDifference {
    public static void main(String[] args) {
        Instance instance = new Instance();
        System.out.println(instance.field);

        System.out.println(Static.field);
    }
}

class Instance {

    int field = 2;

    {
        field++;
    }

    public Instance() {
        field = 8;
    }

    {
        field++;
    }
}

class Static {

    static int field = 20;

    static {
        field = 30;
    }

    static {
        field = 40;
    }
}
