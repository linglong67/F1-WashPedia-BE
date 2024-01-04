package com.kernel360.member.entity;

import com.kernel360.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_id_gen")
    @SequenceGenerator(name = "member_id_gen", sequenceName = "member_member_no_seq", allocationSize = 50)
    @Column(name = "member_no", nullable = false)
    private Integer memberNo;

    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    public static Member of(Integer memberNo, String id, String email, String password, String gender, LocalDate birthdate) {
        return new Member(memberNo, id, email, password, gender, birthdate);
    }

    /** All Binding **/
    private Member(Integer memberNo, String id, String email, String password, String gender, LocalDate birthdate) {
        this.memberNo = memberNo;
        this.id = id;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    /** joinMember **/
    public static Member createJoinMember(String id, String email, String password){
        return new Member(id,email,password);
    }

    /** joinMember Binding **/
    public Member(String id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }

}