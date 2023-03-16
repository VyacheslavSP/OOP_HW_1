
enum action {
    command, giveFood, pat, call, voice, fetch
}

public abstract class Animal {
    public String name;
    public action action;
    public String voiceAnimal;
    public boolean validStatus;
}
