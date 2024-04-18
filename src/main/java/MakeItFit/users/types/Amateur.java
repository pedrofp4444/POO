package MakeItFit.users.types;

import MakeItFit.users.Gender;
import MakeItFit.users.User;

public class Amateur extends User {

    public Amateur(int code, String name, int age, Gender gender, int weight, int height, int bpm,int level,  String address, String phone, String email) {
        super(code, name, age, gender, weight, height, bpm,level ,address, phone, email);
    }

    public Amateur(Amateur a){
        super(a);
    }
}
