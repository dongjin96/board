package Movie.service;


import Movie.domain.Dto.MemberDto;
import Movie.domain.Entity.Member.MemberEntity;
import Movie.domain.Entity.Member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;
    public boolean membersignup(MemberDto memberDto){
    memberRepository.save(memberDto.toentity());
        return true;
    }
    public MemberDto login(MemberDto memberDto){
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        for(MemberEntity memberEntity : memberEntityList){
            if(memberEntity.getMid().equals(memberDto.getMid())&& memberEntity.getMpassword().equals(memberDto.getMpassword())){
                return MemberDto.builder()
                        .mid(memberEntity.getMid())
                        .mno(memberEntity.getMno())
                        .build();
            }
        }return  null;
    }
}
