package Movie.domain.Dto;


import Movie.domain.Entity.Member.MemberEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDto {
    private int mno;
    private String mid;
    private String mpassword;
    private String mname;
    private String msex;
    private String mphone;
    private String memail;
    private String mage;
    private String maddress;
    private String mgrade;

    //dto->entity 메소드
    public MemberEntity toentity(){
        return MemberEntity.builder()
                .mid(this.mid)
                .mpassword(this.mpassword)
                .mname(this.mname)
                .msex(this.msex)
                .mphone(this.mphone)
                .mage(this.mage)
                .maddress(this.maddress)
                .build();

    }

}
