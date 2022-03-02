package Movie.domain.Entity.Member;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="member")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mno")//회원번호
    private int mno;
    @Column(name="mid") // 회원 아이디
    private String mid;
    @Column(name="mpassword")  // 회원 비밀번호
    private String mpassword;
    @Column(name="mname")   //  이름
    private String mname;
    @Column(name="memail")  //  이메일
    private String memail;
    @Column(name="mphone")  // 핸드폰번호
    private String mphone;
    @Column(name="maddress")  // 주소
    private String maddress;
    @Column(name="msex")  // 성별
    private String msex;
    @Column(name="mage")  // 나이
    private String mage;

}
