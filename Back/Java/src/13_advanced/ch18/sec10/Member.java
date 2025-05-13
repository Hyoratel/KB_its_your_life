package ch18.sec10;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

//@AllArgsConstructor
//@Data
public class Member implements Serializable {
    private String id;
    private String name;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + ": " + name;
    }
}
