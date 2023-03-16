import java.lang.reflect.Array;

public class main {
    public static void main(String[] args) {
        byte capacity = 30;
        closet myCloset = new closet(capacity);
        human myHuman = new human("тестовый человек");
        new action(myHuman, myCloset, actionVariant.terminate_access);
        new action(myHuman, myCloset, actionVariant.get_access);
        new action(myHuman, myCloset, actionVariant.get_access);

        for (int i = 0; i < 31; i++) {
            new action(myHuman, myCloset, actionVariant.put);
        }

        for (int i = 0; i < 35; i++) {
            new action(myHuman, myCloset, actionVariant.pull);
        }
        for (int i = 0; i < 10; i++) {
            new action(myHuman, myCloset, actionVariant.put);
        }
        new action(myHuman, myCloset, actionVariant.allStatus);
    }
}