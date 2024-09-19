package springbootboard.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootboard.member.entity.Member;
import springbootboard.member.repository.MemberRepository;
import springbootboard.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepo;

	@Override
	public Member getMember(Member member) {
		// Optional은 null 방지용 클래스
		Optional<Member> findMember = memberRepo.findById(member.getId());
		return findMember.isPresent() ? findMember.get() : null;
	}

}
