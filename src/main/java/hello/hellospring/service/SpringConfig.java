package hello.hellospring.service;

import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

//    private final DataSource dataSource;
//
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository, EntityManager em) {
        this.memberRepository = memberRepository;
        this.em = em;
    }

    private EntityManager em;

    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository);
//        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {

//        return new MemoryMemberRepository();
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
