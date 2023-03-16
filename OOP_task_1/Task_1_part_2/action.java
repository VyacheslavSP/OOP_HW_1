import java.util.ArrayList;

enum actionVariant {
    put, pull, get_access, terminate_access, allStatus;

}

public class action {
    private actionVariant actionVariant;

    public action(human human, closet closet, actionVariant actionVariant) {
        switch (actionVariant) {
            case get_access:
                if (closet.getStatusDoor() == StatusDoor.open) {
                    System.out.println("действие удачно.дверь уже открыта");
                } else {
                    closet.setStatusDoor(StatusDoor.open);
                    System.out.println("действие удачно.дверь открыта");
                }
                break;
            case terminate_access:
                if (closet.getStatusDoor() != StatusDoor.open) {
                    System.out.println("действие невозможно.дверь уже закрыта");
                } else {
                    System.out.println("действие удачно.дверь закрыта");
                    closet.setStatusDoor(StatusDoor.closet);
                }
                break;
            case put:
                if (closet.getStatusDoor() == StatusDoor.open) {
                    int count = closet.getCapacity() - closet.getItems().size();
                    System.out.println("свободного места " + String.valueOf(count));
                    if (count > 0) {
                        ArrayList<String> tmp = closet.getItems();
                        tmp.add("Вещь"); // Это самый примитивный вариант исполнения. по хорошему надо бы создавать
                                         // объект Вещь со своими атрибутами как наименование,размер, ID. тогда список
                                         // шкафа заполняется этими объектами. на каждой итерации требуется проверить
                                         // текущий остаток размера шкафа и, если размер позволяет, засунуть вещь
                                         // количество раз,равное ее размеру. при выводе преобразовать ArrayList в map
                                         // (ключ ID) и получим список вещей. оставлю это к следующим ДЗ
                        closet.setElement(tmp);
                        System.out.println("Действие удачно вещь добавлена");
                    } else {
                        System.out.println("действие невозможно. кончилось место");
                    }
                } else {
                    System.out.println("действие невозможно.дверь закрыта");
                }
                break;
            case pull:
                try {
                    ArrayList<String> tmp = closet.getItems();
                    System.out.println("Взята вешь " + tmp.get(0)); // взяли и удалили первую положеную вещь
                    tmp.remove(0);
                    int count = closet.getCapacity() - closet.getItems().size();
                    System.out.println("свободного места " + String.valueOf(count));
                    closet.setElement(tmp);
                } catch (Exception e) {
                    System.out.println("действие невозможно.шкаф пуст");
                }
                break;
            case allStatus:
                ArrayList<String> tmp = closet.getItems();
                System.out.println("общяя всестимость шкафа: " + closet.getCapacity());
                System.out.println("состояние двери: " + closet.toStringDoor());
                System.out
                        .println("вещей в шкафу всего: " + tmp.size() + " полный список: " + closet.toStringAllItems());
                System.out.println("человек,совeршающий действия: " + human.toString());
                break;
        }

    }
}
