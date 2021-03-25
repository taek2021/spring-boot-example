package dto;
// 회원정보 때려넣기


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Memberdto {
    private String name;
    private String password;
}

// private로 하면 외부에서 못 읽어오지만 이를 가능하게 하게위해서 getter and setter를 씀
