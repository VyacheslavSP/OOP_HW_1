enum command { // наверняка не самый адекватный вариант исполнения. надо разделять доступность
               // команд где то на уровне абстакции в животных
    giveFood, pat, call, command_voice,
}

public class cat extends Animal {
    private command command;
    private String voice;
    private int mills;
    private long time;

    public cat(String name) {
        this.name = name;
        this.validStatus = true;
    }

    public String getName() {
        return name;
    }

    private int getMills() {
        return mills;
    }

    private void setMills(int mills) {
        this.mills = mills;
        this.time = System.currentTimeMillis();
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getVoice() {
        return voice;
    }

    public boolean getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(boolean status) {
        this.validStatus = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    private long sleep() {
        return this.time + getMills();
    }

    public void setCommand(command command, human human) {
        if (getValidStatus()) {
            switch (command) {
                case giveFood:
                    setValidStatus(false);
                    setVoice(" ест и слишком занят,чтобы отвечать");
                    System.out.println(getName() + getVoice());
                    // временая задержка//
                    setMills(10);
                    // setValidStatus(true);
                    break;
                case pat:
                    setValidStatus(false);
                    setVoice(getName() + " мурлыкает");
                    System.out.println(getVoice());
                    setMills(0);
                    break;
                case call:
                    System.out.println(human.getFullName() + " зовет " + getName());
                    double a = Math.random();
                    if (a < 0.7) {
                        setValidStatus(false);
                        setVoice(getName() + " говорит Мяу");
                        System.out.println(getVoice());
                        setMills(0); // утановить задержку для ограничения выполнения действий
                    } else {
                        setVoice(getName() + " игнорирует " + human.getFullName());
                        System.out.println(getVoice());
                    }
                    break;
                case command_voice:
                    setVoice(getName() + " смотрит на " + human.getFullName()
                            + " как на идиота.(кошки не выполняют команду 'Голос')");
                    System.out.println(getVoice());
                    setValidStatus(false);
                    // очень большая временая задержка-котик обидился//
                    setMills(0); // утановить задержку для ограничения выполнения действий
            }
        } else {
            System.out.println(getName() + " занят");
            if (System.currentTimeMillis() > sleep()) {
                setValidStatus(true);
            }
        }

    }
}
