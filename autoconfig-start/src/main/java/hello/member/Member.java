package hello.member;

import lombok.Data;

@Data
public class Member {

    private String memberId;

    private String name;

    public Member() {
    }

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }
}
