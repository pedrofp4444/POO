package MakeItFit.users.types;

import MakeItFit.users.Gender;
import MakeItFit.users.User;

public class Occasional extends User {
    private int frequency;

    public Occasional(int code, String name, int age, Gender gender, int weight, int height, int bpm, int level, String address, String phone, String email, int frequency) {
        super(code, name, age, gender, weight, height, bpm, level, address, phone, email);
        this.frequency = frequency;
    }

    public Occasional(Occasional o){
        super(o);
        this.frequency = o.getFrequency();
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
