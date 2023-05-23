package kz.bitlab.techorda.techboot2.db;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    private Long Id;
    private String name;
    private String Author;
    private int duration;
}
