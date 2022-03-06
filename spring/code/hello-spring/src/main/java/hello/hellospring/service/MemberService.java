package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 다형성

    private final MemberRepository memberRepository; // DI 의존성 주입

    @Autowired
    public MemberService(MemberRepository memberRepository){ // DI // constructor
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Long join( Member member) {
        //같은 이름 있는 중복회원은 X
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) { // 메서드 추출 ctrl + m
        memberRepository.findByName(member.getName())
                .ifPresent(m -> { // optional 이기 때문에
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
