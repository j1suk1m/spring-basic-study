package study.spring.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Member {
    private Long id;
    private String name;
    private Grade grade;
}
